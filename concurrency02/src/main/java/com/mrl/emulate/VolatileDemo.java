package com.mrl.emulate;

/**
 * 编译器乱序问题
 *
 * @author liuchun
 * @date 2018/9/5 13:21
 */
public class VolatileDemo {

    private static int a = 0, b = 0;
    private static int x = 0, y = 0;


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            a = 1;
            x = b;
        });
        Thread t2 = new Thread(() -> {
            b = 1;
            y = a;
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("x=" + x + " y=" + y);
    }

}
