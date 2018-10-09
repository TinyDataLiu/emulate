package com.mrl.emulate.anaudition;

/**
 * @author liuchun
 * @date 2018/10/9 10:41
 */
public class ThreadTest {


    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (; ; ) {
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
}
