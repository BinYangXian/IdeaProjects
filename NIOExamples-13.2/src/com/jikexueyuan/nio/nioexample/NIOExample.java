package com.jikexueyuan.nio.nioexample;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by fangc on 2016/5/22.
 NIO:由于是FileOutputStream该通道可写,没有了传统流的概念，同样是文件操作的时候线程(同步执行)是会阻塞的。在
 java1.4中加入*/
public class NIOExample {
    public static void main(String[] args) throws IOException {
        new NIOExample();
        System.out.println("end");

    }

    public NIOExample() throws IOException {
        write();
        read();
    }
    void write() throws IOException {
        File file=new File("data.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fileOutputStream=new FileOutputStream(file);
        //------------------------------------------------------以下便是NIO
        FileChannel channel = fileOutputStream.getChannel();
        channel.write(ByteBuffer.wrap("Hello Java NIO".getBytes("utf-8")));
        channel.close();
        fileOutputStream.close();
    }
    void read() throws IOException {
        File file=new File("data.txt");
        if (file.exists()){
            FileInputStream fileInputStream=new FileInputStream(file);

            FileChannel channel = fileInputStream.getChannel();

            ByteArrayOutputStream dist=new ByteArrayOutputStream();

            ByteBuffer buffer=ByteBuffer.allocate(1024);//allocateDirect方法直接分配系统内存，较快，容易内存泄漏，
            // 而前者是java虚拟机内存，较慢，较安全。
            int result=0;
            while ((result=channel.read(buffer))!=-1){
                buffer.flip(); //flip后，就可以用buffer.remaining()来获取buffer的长度了
                dist.write(buffer.array(),0,buffer.remaining());
                buffer.clear();
            }
            System.out.println(new String(dist.toByteArray(),"utf-8"));//只要使用ByteArrayOutputStream能将文件读取为字节数组，那么就可用其相关api读取任何文件了；
            // 事实上，就算不用ByteArrayOutputStream，将文件读取为ByteBuffer，也足够用了。
            fileInputStream.close();
        }

    }
}
