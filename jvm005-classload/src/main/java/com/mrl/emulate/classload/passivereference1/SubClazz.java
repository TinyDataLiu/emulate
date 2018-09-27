package com.mrl.emulate.classload.passivereference1;

/**
 * @author liuchun
 * @date 2018/9/27 15:48
 */
public class SubClazz extends SuperClazz {

    static {
        System.err.println("Sub Class init!");
    }



}
