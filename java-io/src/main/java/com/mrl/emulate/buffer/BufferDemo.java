package com.mrl.emulate.buffer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author liuchun
 * @date 2020/02/26  16:11
 */
public class BufferDemo {
    public static void main(String[] args) {
        try (FileInputStream inputStream = new FileInputStream("alice.txt");
             FileChannel channel = inputStream.getChannel()
        ) {
            // 相当于初始化一个10大小的byte 数组
            ByteBuffer byteBuffer = ByteBuffer.allocate(10);
            output("初始化", byteBuffer);

            channel.read(byteBuffer);
            output("read", byteBuffer);

//            操作之前锁定操作范围
            byteBuffer.flip();
            output("flip", byteBuffer);
//              判断有没有肯读数据
            while (byteBuffer.remaining() > 0) {
                byte b = byteBuffer.get();
//                System.out.println((char)b);
            }
            output("get", byteBuffer);

            byteBuffer.clear();
            output("clear", byteBuffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //把这个缓冲里面实时状态给答应出来
    public static void output(String step, Buffer buffer) {
        System.out.println(step + " : ");
//容量，数组大小
        System.out.print("capacity: " + buffer.capacity() + ", ");
//当前操作数据所在的位置，也可以叫做游标
        System.out.print("position: " + buffer.position() + ", ");
//锁定值，flip，数据操作范围索引只能在 position - limit 之间
        System.out.println("limit: " + buffer.limit());
        System.out.println();
    }


    private void allocate() {
        //分配指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(10);
        //包装一个现有的数组
        byte[] bytes = new byte[15];
        buffer = ByteBuffer.wrap(bytes);
    }
}
