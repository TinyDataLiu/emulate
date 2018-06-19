package com.mrl.emulate.synchronizer;

import java.io.Serializable;

/**
 * @author liucun
 * @Description: 偷窥大师经典，自同步器学习
 * @date 2018/6/1911:23
 */
public abstract class AbstractOwnableSynchronizer implements Serializable {

    private static final long serialVersionUID = -6560065003681285519L;

    /*为子类提供的空构造方法*/
    protected AbstractOwnableSynchronizer() {
    }

    /*当前同步器的持有者*/
    private transient Thread exclusiveOwnerThread;

    /*只允许子类使用， 且不可变更 ， 获取当前同步器的使用者*/
    protected final Thread getExclusiveOwnerThread() {
        return exclusiveOwnerThread;
    }

    /*设置当前同步器的持有者*/
    protected final void setExclusiveOwnerThread(Thread thread) {
        this.exclusiveOwnerThread = thread;
    }
}
