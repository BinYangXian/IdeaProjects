package com.jikexueyuan.carfactory;

import com.jikexueyuan.carfactory.factory.PublicFactory;

import static java.lang.Math.random;

/**
 * Created by yangx on 2015/12/25.
 */
public class Test {//测试类

    public static void main(String[] args) {
        String[] names = {"跑车", "大客车", "大卡车", "小车"};
        String carName = names[(int) (4 * random())];//模拟用户随机提交订单为carName车。
        int carNumber = (int) (10 * random()+1);      //模拟用户随机提交订购该车数量为[1,10]辆。
        VehicleFactory factory = new PublicFactory(carName,carNumber);  //模拟用户 提交订单到具体工厂（实例化工厂）
        //下边是工厂的动作：

        Vehicle i = factory.createCar();//
        i.produce();
        i.printValue();
    }
}
