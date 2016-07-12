package com.jikexueyuan.server.Review;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;

/**
 * Created by fangc on 2016/7/12.
 即时通信server is ok！！*///TODO: 2016/7/12 GOOD 总算明白作为即时通信，用命令行提示符，只能单个字符发送，而在android app上则不会，此情况可由客户端的设置而变。
    //
public class Main {
    public static void main(String[] args) {
        try {
            AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(12345));
            while (true) {
                AsynchronousSocketChannel channel = serverSocketChannel.accept().get();
                 new MySocketHandler(channel);
            }

        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
