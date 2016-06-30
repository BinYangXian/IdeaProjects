package com.company;

/**
 * Created by fangc on 2016/4/16.
 */
public class UsingCustomException {
    public static class MyException extends Exception{
        public MyException(String str) {
            super(str);
        }
    }
    public static void main(String[] args) {

        try {
            throw new MyException("自定义异常类");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
