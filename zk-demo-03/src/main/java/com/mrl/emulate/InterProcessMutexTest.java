package com.mrl.emulate;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.RetryOneTime;

import java.util.concurrent.TimeUnit;

public class InterProcessMutexTest {

    private final static CuratorFramework client = CuratorFrameworkFactory
            .builder()
            .connectString(ConnTest.CONN_STR)
            .retryPolicy(new RetryOneTime(1000))
            .namespace(ConnTest.NAME_SPACE)
            .build();

    static {
        client.start();
    }

    public static void main(String[] args) throws Exception {
        InterProcessMutex lock = new InterProcessMutex(client, "/lock_01");
        if (lock.acquire(5, TimeUnit.SECONDS)) {
            try {
                TimeUnit.SECONDS.sleep(20);
            } finally {
                lock.release();
            }
        }
    }
}
