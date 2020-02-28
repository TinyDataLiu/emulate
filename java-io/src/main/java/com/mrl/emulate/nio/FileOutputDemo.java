package com.mrl.emulate.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 面向流，与面向缓冲区
 *
 * @author liuchun
 * @date 2020/02/27  12:19
 */
public class FileOutputDemo {
    public static void main(String[] args) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("user1.txt");
             FileChannel fileChannel = fileOutputStream.getChannel()
        ) {
            ByteBuffer buffer = ByteBuffer.wrap("alice".getBytes("UTF-8"));
            fileChannel.write(buffer);
            buffer.clear();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
