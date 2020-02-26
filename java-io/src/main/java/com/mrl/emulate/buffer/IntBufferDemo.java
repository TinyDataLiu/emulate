package com.mrl.emulate.buffer;

import java.nio.IntBuffer;

/**
 * @author liuchun
 * @date 2020/02/26  15:57
 */

public class IntBufferDemo {

    public static void main(String[] args) {
        /**
         * 分配int 缓冲区，参数为缓冲区容量
         * 当前int buffer 当前位置为0 ，其界限= 缓冲区容量，
         */
        IntBuffer intBuffer = IntBuffer.allocate(8);

        for (int i = 0; i < intBuffer.capacity(); i++) {
            int v = 2 * (i + 1);
            intBuffer.put(v);
        }

        //重设此缓冲区，将限制设置为当前位置，然后将当前位置设置为 0
        intBuffer.flip();

        while (intBuffer.hasRemaining()) {
            int v = intBuffer.get();
            System.out.println("value=" + v);
        }

    }
}
