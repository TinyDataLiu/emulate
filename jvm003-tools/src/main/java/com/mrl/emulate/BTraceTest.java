package com.mrl.emulate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author liuchun
 * @date 2018/9/19 09:56
 */
public class BTraceTest {


    public int add(int a, int b) {
        return a + b;
    }


    public void run() {
        int a = (int) (Math.random() * 1000);
        int b = (int) (Math.random() * 1000);
        System.out.println(add(a, b));
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BTraceTest bTraceTest = new BTraceTest();
        br.readLine();
        for (int i = 0; i < 10; i++) {
            bTraceTest.run();
        }
    }
}
