package com.mrl.emulate.buffer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 直接缓冲区
 *
 * @author liuchun
 * @date 2020/02/26  16:50
 */
public class DirectBuffer {

    private static final String IN = "user.txt";
    private static final String COPY = "user-copy.txt";


    public static void main(String[] args) {


        try (FileOutputStream outputStream = new FileOutputStream(COPY);
             FileInputStream inputStream = new FileInputStream(IN);
             FileChannel outChannel = outputStream.getChannel();
             FileChannel inChannel = inputStream.getChannel()
        ) {
            ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

            while (true) {
                buffer.clear();
                int i = inChannel.read(buffer);
                if (i == -1) {
                    break;
                }

                buffer.flip();

                outChannel.write(buffer);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
