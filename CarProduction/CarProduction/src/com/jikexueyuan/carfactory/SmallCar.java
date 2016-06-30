package com.jikexueyuan.carfactory;

/**
 * Created by yangx on 2015/12/20.
 */
public class SmallCar extends Vehicle {//小车生产车线
    private static int value = 20;
    private String name = "小车";

    public SmallCar(int number) {
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
}
