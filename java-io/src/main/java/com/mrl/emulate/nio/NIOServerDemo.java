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
     * 创建了 ServerSocketChannel 对象，并调用 configureBlocking()方法，配置为非阻塞模式，接下来的三行代码把该通道绑定到指定
     * 端口，最后向 Selector 中注册事件，此处指定的是参数是 OP_ACCEPT，即指定我们想要监听 accept 事件，也就是新的连接发 生
     * 时所产生的事件，对于 ServerSocketChannel 通道来说，我们唯一可以指定的参数就是 OP_ACCEPT。
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

    /**
     * 从 Selector 中获取感兴趣的事件，即开始监听，进入内部循环：
     */
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
     * 在非阻塞 I/O 中，内部循环模式基本都是遵循这种方式。首先调用 select()方法，该方法会阻塞，直到至少有一个事件发生，然后
     * 再使用 selectedKeys()方法获取发生事件的 SelectionKey，再使用迭代器进行循环。
     * 最后一步就是根据不同的事件，编写相应的处理代码：
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
        }
        // 可读事件
        else if (selectionKey.isReadable()) {
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
        }
        // 可写事件
        else if (selectionKey.isWritable()) {
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
