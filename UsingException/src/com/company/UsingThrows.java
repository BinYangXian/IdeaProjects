package com.company;

public class UsingThrows {

    public static void main(String[] args) {
        try {
            Caculation caculation=new Caculation();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static class Caculation{
        int a=5;
        int b=0;
        int result;
        public Caculation()throws Exception{//throws用于方法签名中，以防止程序崩溃；throw用于具体代码段手动抛出
            result=a/b;
            System.out.println(result);
        }
    }
}
