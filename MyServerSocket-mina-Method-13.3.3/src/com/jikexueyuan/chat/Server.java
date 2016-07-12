package com.jikexueyuan.chat;

import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by fangc on 2016/5/24.
 使用mina框架创建一个基于终端的聊天框，也是十分的太方便了，给我们的开发带了巨大的便利*/
public class Server {

    public static void main(String[] args){

        NioSocketAcceptor acceptor=new NioSocketAcceptor();
        acceptor.getFilterChain().addLast("LineCodecName",new ProtocolCodecFilter(new TextLineCodecFactory()));
        //通过上述方式，可以对输入字符一行行的解析。（参数1.是自定义标识符，为了给addBefore、addAfter方法
        // 定位添加滤镜的。）
        acceptor.setHandler(new ChatHandler());
        try {
            acceptor.bind(new InetSocketAddress(12345));
            System.out.println("server started port 12345");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
