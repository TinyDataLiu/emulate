package com.mrl.emulate;

import com.mrl.emulate.spi.HelloSpiJava;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * JAVA SPI 调用
 */
public class App {
    public static void main(String[] args) {
        ServiceLoader<HelloSpiJava> spiJavas = ServiceLoader.load(HelloSpiJava.class);

        Iterator<HelloSpiJava> iterator = spiJavas.iterator();

        while (iterator.hasNext()) {
            HelloSpiJava next = iterator.next();
            next.sayHello("alice");
        }
    }
}
