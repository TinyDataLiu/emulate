package com.mrl.emulate;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String s = "sss";
        s.intern(); //将新的常量放入常量池
        System.out.println("Hello World!");
    }
}
