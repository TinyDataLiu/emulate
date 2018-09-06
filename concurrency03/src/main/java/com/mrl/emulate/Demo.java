package com.mrl.emulate;

/**
 * @author liuchun
 * @date 2018/9/6 11:42
 */
public class Demo {

    public Demo() {
        //锁定当前实例
        synchronized (this) {

        }
    }


    public Demo(String name) {
        //锁定所有实例
        synchronized (Demo.class) {

        }
    }


    //锁定当前方法
    public synchronized void incr() {
    }
}
