package com.jikexueyuan.learnmina;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.session.IoSession;

/**
 * Created by fangc on 2016/5/24.
 */
public class StringFilter extends IoFilterAdapter {
    @Override
    public void messageReceived(NextFilter nextFilter, IoSession session, Object message) throws Exception {

        IoBuffer buffer= (IoBuffer) message;
        String str=new String(buffer.array(),"UTF-8").trim();//将message转化为str字符串，来给下边传递

        super.messageReceived(nextFilter, session, str);

//        super.messageReceived(nextFilter, session, message);//不添加别的语句的默认情况下，此话是将传入该方法的参数
        // session的message直接传递给下一个滤镜。
    }
}
