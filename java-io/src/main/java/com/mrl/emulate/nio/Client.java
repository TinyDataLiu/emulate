package com.mrl.emulate.nio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author liuchun
 * @date 2020/02/27  11:20
 */
public class Client {


    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8080);
            OutputStream stream = socket.getOutputStream();
            stream.write("22222222222".getBytes("UTF-8"));
            stream.flush();

            InputStream inputStream = socket.getInputStream();

            byte[] bytes = new byte[1024];

            inputStream.read(bytes);

            String s = new String(bytes);

            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
