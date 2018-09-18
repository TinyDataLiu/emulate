package com.mrl.emulate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuchun
 * @date 2018/9/18 13:58
 */
public class JconsoleTest001Space {


    static class OOMObject {
        public byte[] plac = new byte[64 * 1024];
    }

    public static void fillHeap(int cyc) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>(cyc);
        for (int i = 0; i < cyc; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        fillHeap(1000);
        System.gc();
        System.out.println("-------");
        System.in.read();
    }
}
