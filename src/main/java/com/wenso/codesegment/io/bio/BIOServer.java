package com.wenso.codesegment.io.bio;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author yuwensong
 * @date 2022/2/2
 */
public class BIOServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9008);
        while (true) {
            System.out.println("等待连接..");
            Socket socket = serverSocket.accept();
            System.out.println("有客户端连接..");
            new Thread(() -> {
                try {
                    handle(socket);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }


    private static void handle(Socket socket) throws Exception {
        System.out.println("thread id = " + Thread.currentThread().getId());
        byte[] bytes = new byte[1024];
        System.out.println("准备read...");
        InputStream inputStream = socket.getInputStream();
        System.out.println("准备read1...");
        int read;
        while ((read = inputStream.read(bytes)) != -1) {
            System.out.println("接收到客户端数据：" + new String(bytes, 0, read, StandardCharsets.UTF_8));
        }
        System.out.println("读取客户端数据完成");
        socket.getOutputStream().write("hello Client, 中文".getBytes(StandardCharsets.UTF_8));
        socket.getOutputStream().flush();
        socket.close();
    }
}
