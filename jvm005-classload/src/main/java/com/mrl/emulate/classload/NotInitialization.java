package com.mrl.emulate.classload;

import com.mrl.emulate.classload.passivereference1.SubClazz;

/**
 * @author liuchun
 * @date 2018/9/27 15:51
 */
public class NotInitialization {


    /**
     * 对于静态字段，只有直接定义这个字段的类才会被初始化。
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(SubClazz.value);
    }
}
