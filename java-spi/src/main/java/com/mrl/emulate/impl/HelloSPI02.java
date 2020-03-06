package com.mrl.emulate.impl;

import com.mrl.emulate.spi.HelloSpiJava;

/**
 * 另一种实现
 */
public class HelloSPI02 implements HelloSpiJava {
    @Override
    public String sayHello(String name) {
        System.out.println(">>>>>>>>>>>>");
        return "02";
    }
}
