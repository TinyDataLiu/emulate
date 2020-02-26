package com.mrl.emulate.buffer;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * @author liuchun
 * @date 2020/02/26  16:33
 */
public class BufferSlice {
    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put(i);
        }
        // 创建子缓冲区
        buffer.position(3);
        buffer.limit(7);
        IntBuffer slice = buffer.slice();
        // 改变子缓冲区内容
        for (int i = 0; i < slice.capacity(); i++) {
            slice.put(i, slice.get(i) * 10);
        }
        buffer.position(0);
        buffer.limit(buffer.capacity());
        while (buffer.remaining() > 0) {
            System.out.print(buffer.get() + " ");
        }
    }
}
