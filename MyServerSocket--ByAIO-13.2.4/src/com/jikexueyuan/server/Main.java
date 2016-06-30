package com.jikexueyuan.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;

/**
 * Created by fangc on 2016/5/23.
 */
public class Main {
    public static void main(String[] args){
        try {
            AsynchronousServerSocketChannel server=AsynchronousServerSocketChannel.open();
            server.bind(new InetSocketAddress(12345));//绑定端口

            while (true){ //用循环实现同步监听。
                AsynchronousSocketChannel socketChannel = server.accept().get();//这里需要阻塞在此（因这里需要等待输入）
                // ，所以用同步accept方法。
                new SocketHandler(socketChannel);
            }
        } catch (IOException | ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
