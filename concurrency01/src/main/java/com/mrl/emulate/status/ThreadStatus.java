package com.mrl.emulate.status;

import java.util.concurrent.TimeUnit;

/**
 * 线程状态展示
 *
 * @author liuchun
 * @date 2018/8/31 12:48
 */
public class ThreadStatus {

    public void testStatus() {
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "TIME_WAITING").start();


        new Thread(() -> {
            synchronized (ThreadStatus.class) {
                try {
                    ThreadStatus.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "WAITING").start();


        new Thread(new BlockDemo(), "BlockDemo-0").start();
        new Thread(new BlockDemo(), "BlockDemo-1").start();

    }

    static class BlockDemo extends Thread {

        @Override
        public void run() {
            synchronized (BlockDemo.class) {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
