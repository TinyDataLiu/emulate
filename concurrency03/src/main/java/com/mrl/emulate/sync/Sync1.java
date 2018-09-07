package com.mrl.emulate.sync;

/**
 * @author liuchun
 * @date 2018/9/6 12:40
 */
public class Sync1 {

    public static int i = 0;


    public void sync() {
        synchronized (this) {
            //锁定当前实例
        }
    }

    public void incr() {
        i++;
    }
}
