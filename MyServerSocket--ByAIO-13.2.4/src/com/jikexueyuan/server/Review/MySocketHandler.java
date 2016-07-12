package com.jikexueyuan.server.Review;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.TimeUnit;

/**
 * Created by fangc on 2016/7/12.
 */
public class MySocketHandler {
    private AsynchronousSocketChannel channel;

    public MySocketHandler(AsynchronousSocketChannel channel) {
        this.channel = channel;
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer, channel, new CompletionHandler<Integer, AsynchronousSocketChannel>() {
            @Override
            public void completed(Integer result, AsynchronousSocketChannel attachment) {

                   if (!MySocketHandlerManager.getMySocketHandlerManager().getSocketHandlerList().contains(MySocketHandler.this)) {
                       MySocketHandlerManager.getMySocketHandlerManager().add(MySocketHandler.this);
                   }

                try {
                    buffer.flip();
                    String msg = new String(buffer.array(), 0, buffer.remaining(), "utf-8").trim();
                    System.out.println(msg);

                    if (msg.equals("quit")) {
                        attachment.close();
                        System.out.println("client主动断开连接");
                    }

                    MySocketHandlerManager.getMySocketHandlerManager().pushMsg(MySocketHandler.this, msg);

                    buffer.clear();
                    if (result != -1) {
                        attachment.read(buffer, attachment, this);
                    } else {
                        System.out.println("链接已经断开");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, AsynchronousSocketChannel attachment) {
                System.out.println("读取接失败");
            }
        });

    }

    public void out(String buffer) {
        try {
            channel.write(ByteBuffer.wrap((buffer.trim()+"\n").getBytes("utf-8")));//+"\n" 可以去重复发送已输入字符
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
