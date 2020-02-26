package com.mrl.emulate.buffer;

import java.nio.IntBuffer;

/**
 * @author liuchun
 * @date 2020/02/26  16:42
 */
public class ReadOnlyBuffer {

    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put(i);
        }

        IntBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();
        // 改变原来缓冲区内容
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put(i, buffer.get(i) + 10);
        }

        readOnlyBuffer.position(0);
        readOnlyBuffer.limit(readOnlyBuffer.capacity());

        while (readOnlyBuffer.remaining() > 0) {
            System.out.print(readOnlyBuffer.get() + " ");
        }

        readOnlyBuffer.put(3, 100);
    }
}
