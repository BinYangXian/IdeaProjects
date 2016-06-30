package com.jikexueyuan.carfactory.products;

import com.jikexueyuan.carfactory.Vehicle;

/**
 * Created by yangx on 2015/12/20.
 * 3) 具体产品角色：工厂类所创建的对象就是此角色的实例。在java中由一个具体类实现。
 */

public class Bus extends Vehicle {//大客车生产线

    private static int value = 40;
    private String name = "大客车";

    public Bus(int number) {
        super(number);
    }

    @Override
    public void produce() {
        System.out.printf("工厂生产了%s%d辆。\n", name, get_number());
    }

    @Override
    public void printValue() {
        System.out.printf("该车的单价是%d万元。", value);
    }

    public static class MyException extends Exception {

        public MyException(String str) {
            super(str);
        }
    }

    public static void main(String[] args) {
        try {
            throw new MyException("自定义异常类");
        } catch (MyException e) {
            System.out.println(e);
        }

    }
}
