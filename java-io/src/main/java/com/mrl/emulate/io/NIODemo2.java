package com.mrl.emulate.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author liuchun
 * @date 2020/02/26  15:37
 */
public class NIODemo2 {

    public static void main(String[] args) {
        try (
                FileInputStream inputStream = new FileInputStream("user.txt");
                // NIO 通过通道去读取数据
                FileChannel channel = inputStream.getChannel();
        ) {
            // 面向缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(100);
            int len = -1;
            while ((len = channel.read(byteBuffer)) != -1) {
                byteBuffer.clear();
                byte[] bytes = byteBuffer.array();
                String str = new String(bytes, 0, len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
