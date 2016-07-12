package com.jikexueyuan.nio.aioexample;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.StandardOpenOption;
//采用递归方法异步读取大文件：
public class ReadLargeFileByRecursionMethod {

    private static ByteArrayOutputStream dist;
    private static int i = 1;

    public static void main(String args[]) throws Exception {
//        ExecutorService pool = new ScheduledThreadPoolExecutor(3);//这种等待异步线程的方法，会造成主线程阻塞？（程序输出结束后，仍然正在运行）
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(
                new File("data.txt").toPath()
                , StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocate(10);//10是指buffer的分配空间10字节，与29行关联。
        CompletionHandler<Integer, ByteBuffer> handler = new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public synchronized void completed(Integer result, ByteBuffer attachment) {
                attachment.flip();
                dist.write(attachment.array(), 0, attachment.remaining());
//                System.out.println(attachment.remaining());
                if (attachment.remaining() == 10) {
                    buffer.clear();
                    fileChannel.read(buffer, 10 * i, buffer, this);//注意第二个参数的手动配置！！10是指buffer的分配空间10字节，
                    // 10*i表示第二次读取从fileChannel的第十个字节后开始读，依次类推。
                    i++;
                } else {
                    System.out.println("End:");
                }
            }

            @Override
            public void failed(Throwable e, ByteBuffer attachment) {
            }
        };

        dist = new ByteArrayOutputStream();

        fileChannel.read(buffer, 0, buffer, handler);

//        pool.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println("doing other thing，instead of  sleep 500ms ");
        Thread.sleep(500);
        System.out.println(new String(dist.toByteArray(), "UTF-8"));
    }

}