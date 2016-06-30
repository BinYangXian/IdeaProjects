package com.company;

/**
 * Created by fangc on 2016/4/16.
 */
public class UsingThrow {
    public static void main(String[] args) {
        try {
//            People people=new People();
            throw new Exception("实例化Exception");//手动抛出异常,防止程序崩溃，同时若下述还有代码，则不会执行到
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static class People{
        int a=5;
        int b=0;
        int result;
        public People(){
            result=a/b;
            System.out.println(result);
        }
    }
}
