package com.mrl.emulate;

import java.io.IOException;

/**
 * @author liuchun
 * @date 2018/9/18 14:25
 * <p>
 * 线程死锁 ：Jconsole 线程标签
 */
public class JconsoleTest002Thread {


    /**
     * 线程死循环
     */
    public static void createBusyThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                }
            }
        }, "test-busy-thred");
        thread.start();
    }


    /**
     * 线程死锁
     */
    public static void createLockThread(final Object lock) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "lock-thread");
        thread.start();
    }


    static class SyncAddRunnalbe implements Runnable {
        int a, b;

        public SyncAddRunnalbe(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)) {
                synchronized (Integer.valueOf(b)) {
                    System.out.println(a + b);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
       /* //等待设备资源
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ss = br.readLine();
        System.out.println(ss);

        createBusyThread();
        ss = br.readLine();
        System.out.println(ss);

        Object object = new Object();
        createLockThread(object);
        object.notifyAll();*/

        for (int i = 0; i < 100; i++) {
            new Thread(new SyncAddRunnalbe(1, 2)).start();
            new Thread(new SyncAddRunnalbe(2, 1)).start();
        }
    }


}