package com.wenso.codesegment.io.nio;

import javax.sound.midi.Soundbank;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

/**
 * @author yuwensong
 * @date 2022/2/2
 */
public class NIOServer {

    public static void main(String[] args) throws Exception {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        ssc.socket().bind(new InetSocketAddress(9000));
        Selector selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            System.out.println("等待事件发生..");
            selector.select();
            System.out.println("有事件发生了..");
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                handle(selectionKey);
            }
        }
    }

    private static void handle(SelectionKey key) throws Exception {
        if (key.isAcceptable()) {
            System.out.println("有客户端连接事件发生..");
            ServerSocketChannel ssc = ServerSocketChannel.class.cast(key.channel());
            SocketChannel sc = ssc.accept();
            sc.configureBlocking(false);
            // selector 监听读事件
            sc.register(key.selector(), SelectionKey.OP_READ);
        } else if (key.isReadable()) {
            System.out.println("客户端有读事件...");
            SocketChannel sc = SocketChannel.class.cast(key.channel());
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int len;
            while ((len = sc.read(buffer)) != -1) {
                System.out.println("读取到客户端的数据：" + new String(buffer.array(), 0, len, StandardCharsets.UTF_8));
            }
            ByteBuffer bufferToWrite = ByteBuffer.wrap("hello Client, 中文".getBytes(StandardCharsets.UTF_8));
            sc.write(bufferToWrite);
            key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        } else if (key.isWritable()) {
            System.out.println("发生读事件");
        }
    }
}
