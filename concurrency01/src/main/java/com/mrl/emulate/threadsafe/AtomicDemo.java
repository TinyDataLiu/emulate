package com.mrl.emulate.threadsafe;

import java.util.concurrent.TimeUnit;

/**
 * 原子性问题（多线程情况下）
 *
 * @author liuchun
 * @date 2018/8/31 13:43
 */
public class AtomicDemo {

    private static int count = 0;

    public static void inc() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(AtomicDemo::inc).start();
        }
        //等待子线程充分运行
        TimeUnit.SECONDS.sleep(4);
        System.out.println("result=" + count);
    }
}
