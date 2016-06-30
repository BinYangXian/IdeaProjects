package com.jikexueyuan.chat;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fangc on 2016/5/24.
 */
public class ChatHandler extends IoHandlerAdapter {

    private List<IoSession> allSessions=new ArrayList<>();
    @Override
    public void sessionCreated(IoSession session) throws Exception {
        super.sessionCreated(session);
        allSessions.add(session);
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        super.messageReceived(session, message);
        for (IoSession ioSession:  //将客户端接收到的数据广播出去，包括自己
             allSessions) {
            ioSession.write(message);
            System.out.println(message);
        }
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        super.sessionClosed(session);
        allSessions.remove(session);
    }
}
