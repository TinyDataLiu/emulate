package com.mrl.emulate.impl;

import com.mrl.emulate.spi.HelloSpiJava;

/**
 * 实现类
 */
public class HelloSPI01 implements HelloSpiJava {
    @Override
    public String sayHello(String name) {
        System.out.println("==============");
        return "01";
    }
}
