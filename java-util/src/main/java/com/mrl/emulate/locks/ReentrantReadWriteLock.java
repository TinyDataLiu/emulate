package com.mrl.emulate.locks;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * @author liucun
 * @Description: ${todo}
 * @date 2018/6/2015:06
 */
public class ReentrantReadWriteLock implements ReadWriteLock, Serializable {

    private static final long serialVersionUID = -8818335191635931284L;

    @Override
    public Lock readLock() {
        return null;
    }

    @Override
    public Lock writeLock() {
        return null;
    }


    /**
     * 同步器
     */
    abstract static class Sync extends AbstractQueuedSynchronizer {

    }
}
