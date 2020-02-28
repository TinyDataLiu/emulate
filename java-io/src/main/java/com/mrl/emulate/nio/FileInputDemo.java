package com.mrl.emulate.nio;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NIO 读数据
 *
 * @author liuchun
 * @date 2020/02/27  12:13
 */
public class FileInputDemo {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("user.txt");
             FileChannel channel = fileInputStream.getChannel()
        ) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            channel.read(buffer);
            buffer.flip();
            System.out.println(new String(buffer.array(), 0, buffer.limit()));
            buffer.clear();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
