package com.jikexueyuan.server;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.Channel;
import java.nio.channels.CompletionHandler;

/**
 * Created by fangc on 2016/5/23.
 */
public class SocketHandler {

    private ByteBuffer buffer=ByteBuffer.allocate(1024);
    public SocketHandler(AsynchronousSocketChannel channel) {
//参数2.传入的附着参数；参数3.接收成功后要处理的函数；
        channel.read(buffer, channel, new CompletionHandler<Integer, AsynchronousSocketChannel>() {
            @Override
            public void completed(Integer result, AsynchronousSocketChannel attachment) {

                buffer.flip();
                try {
                    String msg=new String(buffer.array(),0,buffer.remaining(),"utf-8");
                    System.out.println(msg);
                    if (msg.trim().equals("quit")){
                        attachment.close();
                        System.out.println("客户端主动断开连接");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                buffer.clear();
                if (result!=-1){  //windows下是ctrl+z （输入EOF结束符号，后回车）
                    attachment.read(buffer,attachment,this);//将this（当处理器处理完本次数据后，再将这个
                    // CompletionHandler处理器传入），它就可以不断的侦听用户的输入。
                }else {
                    System.out.println("链接已断开");
                }
            }

            @Override
            public void failed(Throwable exc, AsynchronousSocketChannel attachment) {
                System.out.println("读取失败");
            }
        });
    }
}
