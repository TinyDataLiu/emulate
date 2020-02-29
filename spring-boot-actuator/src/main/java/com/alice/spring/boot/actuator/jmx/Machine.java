package com.alice.spring.boot.actuator.jmx;

/**
 * @author liuchun
 * @date 2020/02/29  12:51
 */
public class Machine implements MachineMBean {
    @Override
    public long availableProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }

    @Override
    public long freeMemory() {
        return Runtime.getRuntime().freeMemory();
    }

    @Override
    public void shutdown() {
        System.exit(0);
    }


}
