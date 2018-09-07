package com.mrl.emulate.sync;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author liuchun
 * @date 2018/9/6 12:42
 * <p>
 * <p>
 * 当sync 作用于this 的时候， 只是影响当前实例
 */
public class Sync1Test {

    @Test
    public void incr1() throws InterruptedException {
        Sync1 sync10 = new Sync1();

        for (int i = 0; i < 10000; i++) {
            Thread thread = new Thread(() -> {
                sync10.incr();
            });
            thread.start();
        }
        TimeUnit.SECONDS.sleep(15);
        System.out.println(sync10.i);
    }
}