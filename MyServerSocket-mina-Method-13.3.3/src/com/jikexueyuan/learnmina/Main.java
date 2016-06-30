package com.jikexueyuan.learnmina;

import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by fangc on 2016/5/24.
 */
public class Main {
    public static void main(String[] args){
        NioSocketAcceptor acceptor=new NioSocketAcceptor();//该类属于mina。           1、创建接收器

        //一、addLast是添加一个滤镜到滤镜链的最后:
        // 它的作用是把客户端传来的数据分成一行行的，然后再往后边传递，！其对Handler
        // 中的messageReceived方法的参数message有直接影响，使其成为字符串类型。mina封装好的API，很方便。
//        acceptor.getFilterChain().addLast("textLineCodeName",new ProtocolCodecFilter(new TextLineCodecFactory()));如果要在特定位置添加滤镜，可以通过参数1.textLineCodeName确定位置。

        //二、添加一个自定义的滤镜（实现了与一、相同的功能）：
        acceptor.getFilterChain().addLast("StringFilterName",new StringFilter());

        acceptor.setHandler(new SockHandler());//参数需要时IoHandler类型，而实现IoHandler需要实现很多方法，
        // 而IoHandlerAdapter恰好实现了该IoHandler，所以SockHandler类继承之更方便。   2、设置一个Handler来处理acceptor。
        try {
            acceptor.bind(new InetSocketAddress(8000));                             //3、设置一个绑定的端口，
            // 然后这个服务器就可以运行了.
            System.out.println("server started at port 8000");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
