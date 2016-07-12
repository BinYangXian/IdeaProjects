package com.jikexueyuan.nio.aioexample;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.StandardOpenOption;

/**
 * Created by fangc on 2016/5/23.
 * AIO:属于NIO，是其扩充，属于异步操作，不会阻塞线程。在java1.7中加入.学会后肯定比之前爽很多，
 * 只是需要一点观念转变
 */
public class AIOExample {
    public static void main(String[] args) throws IOException {
        new AIOExample();
        try {
            Thread.sleep(1000);//主线程可以等待异步任务读写工作结束后的输出语句“end”，否则没有提示“end”
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public AIOExample() throws IOException {
//        write();
        read();
    }

    public void write() throws IOException {
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(new File("data.txt").toPath()
                , StandardOpenOption.WRITE, StandardOpenOption.CREATE);//参数3.当不存在此文件时自动创建
        //方法1、通过future对象中的方法实现对异步状态的控制与监控。
//        Future<Integer> future = channel.write(ByteBuffer.wrap("hello java AIO".getBytes("utf-8")), 0);
        //方法2、当异步工作结束之后可以通知你。参数3.将当前contex等对象作为参数附着在异步工作里（因为当异步工作结束的时候，上下文
        // 对象很可能已经发生了改变），这里用不需要就用null。
        channel.write(ByteBuffer.wrap("hello java AIO，where are you".getBytes("utf-8")), 0  //ByteBuffer.wrap("this is a AIO test.".getBytes("utf-8"))
                , null, new CompletionHandler<Integer, Object>() {
                    @Override
                    public void completed(Integer result, Object attachment) {//参数1.写出数据的字节数，
                        // 当硬盘写入带宽被占满时等情况，result可能会为0，此时应当手动处理；参数2.附着对象。
                        try {
                            channel.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("end");

                    }

                    @Override
                    public void failed(Throwable exc, Object attachment) {//发生情况目标磁盘不可写、没有权限等
                        exc.printStackTrace();
                        try {
                            channel.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

    }

    //Read:

    public void read() throws IOException {
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(new File("data.txt").toPath()
                , StandardOpenOption.READ);

        ByteArrayOutputStream dist = new ByteArrayOutputStream();
        ByteBuffer buffer = ByteBuffer.allocate(1024);//allocateDirect方法直接分配系统内存，而前者是java虚拟机内存

        channel.read(buffer, 0, null, new CompletionHandler<Integer, Object>() {
            @Override
            public void completed(Integer result, Object attachment) {
//                System.out.println(new String(buffer.array()).trim());//当然如NIO一样可能一次读不完，要循环读取，在ReadLargeFileByRecursionMethod类中采用了递归方法读异步取大文件！！
                buffer.flip(); //flip后，就可以用buffer.remaining()来获取buffer的长度了
                dist.write(buffer.array(), 0, buffer.remaining());
                buffer.clear();
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        System.out.println("end");
        System.out.println(new String(dist.toByteArray(), "utf-8"));
    }
}
