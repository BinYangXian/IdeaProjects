package com.company;

import java.net.Socket;
import java.util.Vector;

/**
 * Created by fangc on 2016/5/21.
 */
public class ChatManager {//第四节、

    private ChatManager() {
    }                                                          //1、私有类型

    private static final ChatManager cm = new ChatManager();//2、static类型

    public static ChatManager getChatManager() {
        return cm;                                            //3、static类型，就完成了类的单例化
    }

    //现在就能开始对ChatSocket的管理了：
    Vector<ChatSocket> vector = new Vector<ChatSocket>();

    public void add(ChatSocket cs) {
        vector.add(cs);
    }

    public void publish(ChatSocket cs, String out) {//其中的某一个ChatSocket线程(这里作为参数1.传入)，
        // 可以通过此方法向所有的其余socket发送信息(这里作为参数2.传入)
        for (int i = 0; i < vector.size(); i++) {
            ChatSocket csChatSocket = vector.get(i);
            if (!cs.equals(csChatSocket)) {//排除向自己发送消息的情况
                csChatSocket.out(out);
            System.out.println(out);
            }
        }
    }
}
