package com.mrl.emulate.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * NIO Selector 选择器
 *
 * @author liuchun
 * @date 2020/02/27  10:47
 */
public class SelectorDemo {

    private Selector getSelector() throws IOException {
        //创建选择器对象
        Selector selector = Selector.open();
        // 创建可选择通道，并配置为设置为非阻塞模式
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(Boolean.FALSE);
        // 绑定通道，指定端口
        ServerSocket serverSocket = new ServerSocket();
        InetSocketAddress address = new InetSocketAddress(8080);
        serverSocket.bind(address);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        return selector;
    }


    private void listen() {
        System.out.println("listen on 8080");
        while (true){

        }
    }
}
