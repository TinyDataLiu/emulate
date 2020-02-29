package com.alice.spring.boot.actuator.jmx;

/**
 * @author liuchun
 * @date 2020/02/29  12:50
 */
public interface MachineMBean {


    long availableProcessors();

    long freeMemory();

    void shutdown();

}
