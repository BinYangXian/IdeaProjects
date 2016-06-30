package com.company;

public class UsingThreadSyn extends Thread {
    private Object obj;
    private String threadNo;

    public UsingThreadSyn(Object _obj, String _threadNo) {
        this.threadNo = _threadNo;
        this.obj = _obj;
    }

    @Override
    public void run() {
        synchronized (obj) {
            for (int i = 1; i <= 1000; i++) {
                System.out.println("线程" + threadNo + "执行了第" + i + "次");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        for (int i = 1; i < 6; i++) {
            new UsingThreadSyn(obj, i + "").start();
            Thread.sleep(1);
        }
    }
}