package com.jikexueyuan.nio.aioexample;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

/**
 * Created by fangc on 2016/7/12.
 */
public class AIOReview {
    public static void main(String[] args) {
        new AIOReview();

        try {
            Thread.sleep(500);
            System.out.println("other thing is done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public AIOReview() {
//        write();
        read();
    }

    private void read() {
        try {
            AsynchronousFileChannel channel = AsynchronousFileChannel.open(new File("data.txt").toPath(), StandardOpenOption.READ);
            ByteBuffer buffer = ByteBuffer.allocate(10);
            ByteArrayOutputStream dist=new ByteArrayOutputStream();
            final int[] i = {1};
            channel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {

                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    attachment.flip();
                    dist.write(attachment.array(),0,attachment.remaining());
                    if (attachment.remaining() == 10) {
                        attachment.clear();
                        channel.read(attachment, i[0] *10,attachment,this);
                        i[0]++;
                    }else {
                        try {
                            System.out.println(new String(dist.toByteArray(),"utf-8"));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {

                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void write() {
        try {
            AsynchronousFileChannel channel = AsynchronousFileChannel.open(new File("aioTest.txt").toPath(), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
            channel.write(ByteBuffer.wrap("this is a AIO test.".getBytes("utf-8")), 0, null, new CompletionHandler<Integer, Object>() {
                @Override
                public void completed(Integer result, Object attachment) {
                    try {
                        channel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("writing is ok");
                }

                @Override
                public void failed(Throwable exc, Object attachment) {
                    try {
                        channel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("writing was failed");
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
