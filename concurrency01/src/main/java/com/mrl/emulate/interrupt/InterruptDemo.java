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

    public static void main(String[] args) throws InterruptedException {
        //stop();
        reset();
    }


    /**
     * 线程停止
     *
     * @throws InterruptedException
     */
    public static void stop() throws InterruptedException {
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


    /**
     * 线程复位
     *
     * @throws InterruptedException
     * @see Thread#interrupt()
     */
    public static void reset() throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                boolean status = Thread.currentThread().isInterrupted();
                if (status) {
                    logger.info("before:" + status);
                    Thread.interrupted();
                    logger.info("after:" + Thread.currentThread().isInterrupted());
                }
            }
        }, "reset");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }
}
