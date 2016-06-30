package com.jikexueyuan.carfactory.factory;

import com.jikexueyuan.carfactory.VehicleFactory;
import com.jikexueyuan.carfactory.Vehicle;
import com.jikexueyuan.carfactory.products.Bus;
import com.jikexueyuan.carfactory.products.SmallCar;
import com.jikexueyuan.carfactory.products.SportCar;
import com.jikexueyuan.carfactory.products.Truck;

/**
 * Created by fangc on 2016/4/24.
 */
public class ChevroletFactory extends VehicleFactory {
    private String factoryName="雪弗莱汽车工厂";
    private String orderCarType;
    private int carNumber;

    public ChevroletFactory(String orderCarType, int carNumber) {
        this.orderCarType = orderCarType;
        this.carNumber = carNumber;
        System.out.printf("这里是%s,收到模拟订单%s%d辆。\n", factoryName,orderCarType, carNumber);
    }


    @Override
    public Vehicle createCar() {
        if (orderCarType.equals("小车")) {
            return new SmallCar(carNumber);
        } else if (orderCarType.equals("大客车")) {
            return new Bus(carNumber);
        } else if (orderCarType.equals("大卡车")) {
            return new Truck(carNumber);
        } else if (orderCarType.equals("跑车")) {
            return new SportCar(carNumber);
        } else {
            return null;
        }
    }

}
