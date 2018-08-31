package com.mrl.emulate.threadsafe;

import java.util.concurrent.TimeUnit;

/**
 * 可见性用例
 *
 * @author liuchun
 * @date 2018/8/31 13:35
 */
public class VisibleDemo {

    /**
     * 如果不对字段进行volatile 修饰， stop
     * 无法被子线程visible 可见， 子线程将无法停止运行
     */
    private volatile static boolean stop = false;


    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            int i = 0;
            while (!stop) {
                i++;
            }
        }, "visible").start();

        TimeUnit.SECONDS.sleep(1);
        stop = true;
    }
}
