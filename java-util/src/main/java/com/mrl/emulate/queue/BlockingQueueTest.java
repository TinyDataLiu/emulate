package com.mrl.emulate.queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author liucun
 * @Description: 阻塞队列了解一下
 * @date 2018/6/2016:41
 */
public class BlockingQueueTest {

    /**
     * ----阻塞队列特点
     * 1.在队列为空时，获取元素的线程会等待队列变为非空。
     * 2.当队列满时，存储元素的线程会等待队列可用。
     * <p>
     * 方法\处理方式 	抛出异常 	返回特殊值 	一直阻塞 	超时退出
     * 插入方法 	    add(e) 	    offer(e) 	put(e) 	    offer(e,time,unit)
     * 移除方法 	    remove() 	poll() 	    take() 	    poll(time,unit)
     * 检查方法 	    element() 	peek() 	    不可用 	    不可用
     */

    static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(5);


    public static void testAdd() throws InterruptedException {
        for (; ; ) {
            String str = UUID.randomUUID().toString();
            // 跑出异常
            queue.add(str);
            // 一直等待
            queue.put(str);
            // 返回特殊值
            queue.offer(str);
            //超时退出
            queue.offer(str, 1L, TimeUnit.SECONDS);
        }
    }


    public static void testRemove() throws InterruptedException {
        String remove = queue.remove();
        String pool = queue.poll();
        String take = queue.take();
        String pollTime = queue.poll(1L, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws InterruptedException {
        for (; ; ) {
            Boolean b = queue.offer(UUID.randomUUID().toString());
            if (!b) {
                break;
            }
        }
        String s = queue.peek();
        System.out.println(String.format("size = %s ,s = %s", queue.size(), s));
    }


    static DelayQueue<StringObject> delayQueue = new DelayQueue<StringObject>();


    class StringObject implements Delayed {
        @Override
        public long getDelay(TimeUnit unit) {
            return 0;
        }

        @Override
        public int compareTo(Delayed o) {
            return 0;
        }
    }
}
