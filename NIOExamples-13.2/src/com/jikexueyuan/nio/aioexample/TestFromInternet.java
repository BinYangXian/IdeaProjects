package com.jikexueyuan.nio.aioexample;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
//网上摘抄，ScheduledThreadPoolExecutor的引入貌似阻塞主线程，如ReadLargeFileByRecursionMethod去掉后，用固定时间等待异步读取完成则没有发现阻塞！
public class TestFromInternet {

    public static void main(String args[]) throws Exception {
        ExecutorService pool = new ScheduledThreadPoolExecutor(3);
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(
                Paths.get("data.txt"), EnumSet.of(StandardOpenOption.READ),
                pool);
        CompletionHandler<Integer, ByteBuffer> handler = new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public synchronized void completed(Integer result, ByteBuffer attachment) {
                for (int i = 0; i < attachment.limit(); i++) {
                    System.out.println((char) attachment.get(i));
                }
            }
            @Override
            public void failed(Throwable e, ByteBuffer attachment) {
            }
        };
        final int bufferCount = 5;
        ByteBuffer buffers[] = new ByteBuffer[bufferCount];
        for (int i = 0; i < bufferCount; i++) {
            buffers[i] = ByteBuffer.allocate(10);
            fileChannel.read(buffers[i], i * 10, buffers[i], handler);
        }
        pool.awaitTermination(1, TimeUnit.SECONDS);
        for (ByteBuffer byteBuffer : buffers) {
            for (int i = 0; i < byteBuffer.limit(); i++) {
                System.out.print((char) byteBuffer.get(i));
            }
        }
    }
}