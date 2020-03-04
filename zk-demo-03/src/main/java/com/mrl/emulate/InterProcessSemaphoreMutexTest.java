package com.mrl.emulate;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreMutex;
import org.apache.curator.retry.RetryOneTime;

import java.util.concurrent.TimeUnit;

public class InterProcessSemaphoreMutexTest {


    private final static CuratorFramework client = CuratorFrameworkFactory
            .builder()
            .connectString(ConnTest.CONN_STR)
            .retryPolicy(new RetryOneTime(1000))
            .namespace(ConnTest.NAME_SPACE)
            .build();

    static {
        client.start();
    }


    public static void main(String[] args) {

        InterProcessSemaphoreMutex interProcessSemaphoreMutex = new InterProcessSemaphoreMutex(client, "interProcessSemaphoreMutex");

        try {
            if (interProcessSemaphoreMutex.acquire(10, TimeUnit.SECONDS)) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                interProcessSemaphoreMutex.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
