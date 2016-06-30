package com.company;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by fangc on 2016/5/21.
 */
public class ServerListener extends Thread {
    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            while (true) { //循环侦听客户端的连接请求
                //阻塞
                Socket socket = serverSocket.accept();//Listens for a connection to be made to this socket and accepts
               // * it. The method blocks until a connection is made.之后，一旦客户端与服务端建立了链接，socket就会执行
                // 完本次循环内的代码（既该客户端通过ChatSocket线程，实现与服务器相互传递信息的功能），此后本次循环结束，
                // 而下一次循环又回到此句被阻塞，继续处于监听状态（等待下一个客户端的连接请求）。
                //建立连接
                JOptionPane.showMessageDialog(null, "有客户端连接到了本机的12345端口");
                //将socket传递给新的独立线程
                ChatSocket cs = new ChatSocket(socket);
                cs.start();
                ChatManager.getChatManager().add(cs);//第四节、添加新建的ChatSocket到管理器
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
