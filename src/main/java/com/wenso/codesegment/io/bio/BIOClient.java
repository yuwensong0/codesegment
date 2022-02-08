package com.wenso.codesegment.io.bio;

import java.io.InputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author yuwensong
 * @date 2022/2/2
 */
public class BIOClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 9008);
        socket.getOutputStream().write("hello Server，中文".getBytes(StandardCharsets.UTF_8));
        socket.getOutputStream().flush();
        // 发送结束字符，否则服务点一直阻塞在read方法
        socket.shutdownOutput();
        System.out.println("向服务端发送数据结束");
        byte[] bytes = new byte[1024];
        System.out.println("准备read...");
        InputStream inputStream = socket.getInputStream();
        int read;
        while ((read = inputStream.read(bytes)) != -1) {
            System.out.println("接收到客户端数据：" + new String(bytes, 0, read, StandardCharsets.UTF_8));
        }
        socket.close();
    }
}
