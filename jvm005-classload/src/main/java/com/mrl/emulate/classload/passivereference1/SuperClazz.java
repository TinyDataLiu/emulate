package com.mrl.emulate.classload.passivereference1;

/**
 * 通过子类引用父类的静态字段，不会导致子类初始化
 *
 * @author liuchun
 * @date 2018/9/27 15:45
 */
public class SuperClazz {

    static {
        System.err.println("Super Class init!");
    }

    public static int value = 123;
}
