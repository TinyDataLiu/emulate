package com.mrl.emulate.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author liuchun
 * @date 2020/02/27  10:58
 */
public class NIOServerDemo {

    /**
     * 监听端口
     */
    private int port;

    /**
     * 事件选择器
     */
    private Selector selector;

    /**
     * 缓冲区
     */
    private ByteBuffer buffer = ByteBuffer.allocate(1024);

    /**
     * 构造并监听
     *
     * @param port
     */
    public NIOServerDemo(int port) {
        this.port = port;
        try {
            // 打开通道
            ServerSocketChannel socketChannel = ServerSocketChannel.open();
            socketChannel.bind(new InetSocketAddress(port));
            socketChannel.configureBlocking(Boolean.FALSE);
            // 选择器开始工作，等待注册事件,事件都会注册到，这里
            selector = Selector.open();
            // 将表示通道可以接收请求，并且会由 selector 管理事件
            socketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void listen() {
        System.out.println("server listen to " + this.port + "....");
        while (true) {
            try {
                selector.select();
                // 每次拿到所有的事件信息
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();
                while (iterator.hasNext()) {
                    // 将事件拿出来
                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();
                    process(selectionKey);
                    // 处理完成相应事件后移除
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 对于不同事件的数据，进行不同的处理
     *
     * @param selectionKey
     */
    private void process(SelectionKey selectionKey) throws IOException {
        // 如果是可连接状态
        if (selectionKey.isAcceptable()) {
            ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
            //打开通道，并且接收数据
            SocketChannel accept = channel.accept();
            accept.configureBlocking(Boolean.FALSE);
            accept.register(selector, SelectionKey.OP_READ);
        } else if (selectionKey.isReadable()) {
            // 客户端请求
            SocketChannel channel = (SocketChannel) selectionKey.channel();
            int len = channel.read(buffer);


            if (len > 0) {
                buffer.flip();
                String message = new String(buffer.array(), 0, len);
                System.out.println("message=" + message);
                SelectionKey key = channel.register(selector, SelectionKey.OP_WRITE);
                key.attach(message);
            }
        } else if (selectionKey.isWritable()) {
            SocketChannel channel = (SocketChannel) selectionKey.channel();
            String attachment = (String) selectionKey.attachment();
            channel.write(ByteBuffer.wrap(("output " + attachment).getBytes()));
            channel.close();
        }
    }


    public static void main(String[] args) {
        new NIOServerDemo(8080).listen();
    }

}
