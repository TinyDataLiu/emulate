package com.mrl.emulate.synchronizer;

import sun.misc.Unsafe;

import java.io.Serializable;
import java.util.concurrent.locks.LockSupport;

/**
 * @author liucun
 * @Description: 窥探大师经典
 * @date 2018/6/1912:09
 */
public class AbstractQueuedSynchronizer extends AbstractOwnableSynchronizer implements Serializable {
    private static final long serialVersionUID = -6856958959642824045L;

    protected AbstractQueuedSynchronizer() {

    }

    /**
     * CLH存储队列
     */
    static final class Node {
        /**
         * 共享模式
         */
        static final Node SHARED = new Node();

        /**
         * 独占模式
         */
        static final Node EXCLUSIVE = null;

        /**
         * 线程取消状态
         */
        static final int CANCELLED = 1;
        /**
         * 后续线程需要等待
         */
        static final int SIGNAL = -1;
        /**
         * 线程需要等待，某个特定条件
         */
        static final int CONDITION = -2;
        /**
         * waitStatus value to indicate the next acquireShared should
         * unconditionally propagate ？？？？？？ TODO
         */
        static final int PROPAGATE = -3;

        /**
         * 等待状态
         */
        volatile int waitStatus;

        /**
         * 上一个节点
         */
        volatile Node prev;

        /**
         * 下一个节点
         */
        volatile Node next;

        /**
         * 当前线程，持有同步器的线程
         */
        volatile Thread thread;

        /**
         * 等待节点
         */
        Node nextWaiter;

        /**
         * 判断是否为共享模式
         */
        final boolean isShared() {
            return nextWaiter == SHARED;
        }

        /**
         * @return the predecessor of this node
         */
        final Node predecessor() throws NullPointerException {
            Node p = prev;
            if (null == p) {
                throw new NullPointerException();
            } else {
                return p;
            }
        }

        Node() {    // Used to establish initial head or SHARED marker
        }

        /**
         * @param thread 当前持有者
         * @param mode   下一个持有者
         */
        Node(Thread thread, Node mode) {     // Used by addWaiter
            this.nextWaiter = mode;
            this.thread = thread;
        }

        /**
         * @param thread     当前持有者
         * @param waitStatus 等待状态，释放状态
         */
        Node(Thread thread, int waitStatus) { // Used by Condition
            this.waitStatus = waitStatus;
            this.thread = thread;
        }
    }

    /**
     * 头结点
     */
    private transient volatile Node head;

    private transient volatile Node tail;

    /**
     * 状态
     */
    private volatile int state;

    /**
     * 获取同步状态
     *
     * @return
     */
    protected final int getState() {
        return state;
    }

    /**
     * 设置同步状态
     */
    protected final void setState(int newState) {
        state = newState;
    }

    /**
     * CAS 更新 state 字段
     *
     * @param expect 期望值
     * @param update 新值
     * @return
     */
    protected final boolean compareAndSetState(int expect, int update) {
        return unsafe.compareAndSwapInt(this, stateOffset, expect, update);
    }


    /**
     * 纳秒级别的操作，主要是为了提供更高的响应速度
     */
    static final long spinForTimeoutThreshold = 1000L;

    /**
     * 从这里我们可以看出入队操作是从尾节点入队
     *
     * @param node
     * @return node 的前置节点
     */
    private Node enq(final Node node) {
        //这里采用死循环的方式设置，知道设置成功
        for (; ; ) {
            //从尾部入队
            Node t = tail;
            // Must initialize
            //如果没有尾节点， 说明当前队列尾空
            if (t == null) {
                if (compareAndSetHead(new Node())) {
                    //头结点 === 尾节点
                    tail = head;
                }
            } else {
                //如果尾节点不为空， 则将尾节点设置成上一个节点
                node.prev = t;
                //更新尾节点信息
                if (compareAndSetTail(t, node)) {
                    t.next = node;
                    return t;
                }
            }
        }
    }


    /**
     * 设置等待节点
     *
     * @param mode Node.EXCLUSIVE for exclusive, Node.SHARED for shared
     * @return 返回新节点
     */
    private Node addWaiter(Node mode) {
        //设置等待节点
        //占用同步器的节点是当前线程
        Node node = new Node(Thread.currentThread(), mode);
        // 快速定位的操作， 如果不行就调用 入队方法 ，这里减少了头定位问题的判断 ，不考虑效率 可以直接调用 入队方法enq ()
        Node pred = tail;
        if (pred != null) {
            node.prev = pred;
            if (compareAndSetTail(pred, node)) {
                pred.next = node;
                return node;
            }
        }
        enq(node);
        return node;
    }

    /**
     * Sets head of queue to be node, thus dequeuing. Called only by
     * acquire methods.  Also nulls out unused fields for sake of GC
     * and to suppress unnecessary signals and traversals.
     * 这里也是大师对高性能的要求 仅仅会使用在获取方法中。防止不必要的遍历，造成多余的内存消耗
     *
     * @param node the node
     */
    private void setHead(Node node) {
        head = node;
        node.thread = null;
        node.prev = null;
    }

    /**
     * 唤醒后续节点
     *
     * @param node
     */
    private void unparkSuccessor(Node node) {
        /**
         * fails or if status is changed by waiting thread.
         */
        int ws = node.waitStatus;
        if (ws < 0) {
            /*设置当前节点状态为0 */
            compareAndSetWaitStatus(node, ws, 0);
        }
        /**
         * 先判断NEXT 节点，如果next节点为空，则从尾部开始唤醒等待中的节点
         */
        Node s = node.next; //后续节点
        if (s == null || s.waitStatus > 0) {
            //设置可用节点为空
            s = null;
            // 从尾部循环当前队列，知道找到合适的为止
            for (Node t = tail; t != null && t != node; t = t.prev) {
                if (t.waitStatus <= 0) {
                    s = t;
                }
            }
        }
        /*唤醒当前同步器持有者*/
        if (s != null) {
            LockSupport.unpark(s.thread);
        }
    }

    /**
     * CAS  设置头 Used only by enq.
     */
    private final boolean compareAndSetHead(Node update) {
        return unsafe.compareAndSwapObject(this, headOffset, null, update);
    }

    /**
     * CAS 设置尾 Used only by enq.
     */
    private final boolean compareAndSetTail(Node expect, Node update) {
        return unsafe.compareAndSwapObject(this, tailOffset, expect, update);
    }

    /**
     * CAS waitStatus field of a node. CAS 设置弄得的等待状态
     */
    private static final boolean compareAndSetWaitStatus(Node node, int expect, int update) {
        return unsafe.compareAndSwapInt(node, waitStatusOffset, expect, update);
    }

    /**
     * 一下代码主要提供CAS操作。大师说不用JUC包的工具类
     * 是出于效率和可扩展性。 {@link java.util.concurrent.atomic.AtomicInteger}
     * 可以使用这个取完成，  牺牲了部分友好性，为了扩展性和效率的提升
     */
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final long stateOffset;
    private static final long headOffset;
    private static final long tailOffset;
    private static final long waitStatusOffset;
    private static final long nextOffset;

    static {
        try {
            stateOffset = unsafe.objectFieldOffset(AbstractQueuedSynchronizer.class.getDeclaredField("state"));
            headOffset = unsafe.objectFieldOffset(AbstractQueuedSynchronizer.class.getDeclaredField("head"));
            tailOffset = unsafe.objectFieldOffset(AbstractQueuedSynchronizer.class.getDeclaredField("tail"));
            waitStatusOffset = unsafe.objectFieldOffset(Node.class.getDeclaredField("waitStatus"));
            nextOffset = unsafe.objectFieldOffset(Node.class.getDeclaredField("next"));
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }
}
