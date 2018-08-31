package com.mrl.emulate.interrupt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author liuchun
 * @date 2018/8/31 14:40
 */
public class InterruptDemo {

    private static Logger logger = LoggerFactory.getLogger(InterruptDemo.class);

    private static int num = 0;

    /**
     * 优雅的停止
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                num++;
            }
            logger.info("num:" + num);
        }, "interrupt");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }
}
