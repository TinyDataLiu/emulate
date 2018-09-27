package com.mrl.emulate.classload.passivereference2;

/**
 * @author liuchun
 * @date 2018/9/27 16:14
 */
public class ConstClazz {
    static {
        System.err.println("ConstClazz init!");
    }

    public static final String HELLO_WORLD = "hello_world";
}
