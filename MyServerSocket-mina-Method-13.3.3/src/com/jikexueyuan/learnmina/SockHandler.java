package com.jikexueyuan.learnmina;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

/**
 * Created by fangc on 2016/5/24.
 */
public class SockHandler extends IoHandlerAdapter {//参数需要是IoHandler类型，而实现IoHandler需要实现很多方法，
    // 而IoHandlerAdapter恰好实现了该IoHandler，所以SockHandler类继承之更方便。   2、设置一个Handler

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        super.sessionCreated(session);

        System.out.println("create");
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        super.messageReceived(session, message);
//未添加滤镜时：
//        IoBuffer buffer= (IoBuffer) message;
//        String str=new String(buffer.array(),"UTF-8");
//        System.out.println(str.trim());//同样这里需要去除buffer里的空字符
// 添加了TextLineCodecFactory滤镜后：
        String line= (String) message;
        System.out.println(line);
        if (line.equals("quit")){
            session.close();
        }
    }
}
