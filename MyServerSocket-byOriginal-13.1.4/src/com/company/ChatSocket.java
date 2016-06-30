package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by fangc on 2016/5/21.
 */
// TODO: 2016/6/19 此原始法对于安卓聊天app，收不到消息，用mina框架行
public class ChatSocket extends Thread{
     Socket socket;

    public ChatSocket(Socket s) {
        this.socket = s;
    }
    public void out(String out){  //获取到该客户端的输出流对象,通过其自身write方法将 字符串 参数发送出去。
        try {
            socket.getOutputStream().write(out.getBytes("utf-8"));//write方法较为快捷
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
////第四节、将前的循环发送"loop+"+count 消息改为接收数据的功能：从与ServerSocket的12345端口建立了链接的
// Socket中（例如在第一个打开的终端里，输入字符串后按enter键，形成输入流）取得输入流，然后转化为缓存读取对象，
// 从中循环读取字符串并赋值给line，
// 然后将之通过单例ChatManager对象的publish方法发送给其余的所有客户端，以此实现任意一个chatSocket对象都
// 可以同样通过下述方法接收到字符串，同时任意客户端也可以像第一个打开的终端一样，通过此法发送消息。
//        int count=0;
        try {
            BufferedReader br=new BufferedReader(//解释见上
                    new InputStreamReader(
                            socket.getInputStream(),"utf-8"));
            String line=null;
            while ((line=br.readLine())!=null){ //line为从客户端输入的数据
                ChatManager.getChatManager().publish(this,line);//将line发送给其余所有的ChatSocket对象
//            count++;
//            out("loop+"+count);
//            try {sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
