package com.jikexueyuan.carfactory;

import static java.lang.Math.random;

/**
 * Created by yangx on 2015/12/25.
 */
public class Test {//测试类

    public static void main(String[] args) {
        String[] name = {"跑车", "大客车", "大卡车", "小车"};
        String carName = name[(int) (4 * random())];//模拟用户随机提交订单为carName车。
        int carNumber = (int) (10 * random()+1);      //模拟用户随机提交订购该车数量为[1,10]辆。
        Factory factory = new Factory();  //模拟用户 提交订单到具体工厂（实例化工厂）
        //下边是工厂的动作：
        System.out.printf("收到模拟订单%s%d辆。\n", carName, carNumber);
        Vehicle i = factory.createCar(carName, carNumber);//
        i.produce();
        i.printValue();
    }
}
