package com.jikexueyuan.carfactory.products;

import com.jikexueyuan.carfactory.Vehicle;

/**
 * Created by yangx on 2015/12/20.
 */
public class Truck extends Vehicle {//大卡车生产线
    private static int value = 50;
    private String name = "大卡车";

    public Truck(int number) {
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

