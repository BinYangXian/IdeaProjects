package com.jikexueyuan.server.Review;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.List;
import java.util.Vector;

/**
 * Created by fangc on 2016/7/12.
 */
public class MySocketHandlerManager {
    //下三句为单利模式的创建
    private static final MySocketHandlerManager shm=new MySocketHandlerManager();

    private MySocketHandlerManager() {
    }

    static MySocketHandlerManager getMySocketHandlerManager(){
        return shm;
    }


    private Vector<MySocketHandler> socketHandlerList=new Vector<>();

    public Vector<MySocketHandler> getSocketHandlerList() {
        return socketHandlerList;
    }

    void add(MySocketHandler mySocketHandler){
        socketHandlerList.add(mySocketHandler);
    }
    void remove(MySocketHandler mySocketHandler){
        socketHandlerList.remove(mySocketHandler);
    }


    public void pushMsg(MySocketHandler mySocketHandler, String buffer) {
        for (MySocketHandler m:
             socketHandlerList) {
            if (!m.equals(mySocketHandler)){
                m.out(buffer);
            }
        }
    }
}
