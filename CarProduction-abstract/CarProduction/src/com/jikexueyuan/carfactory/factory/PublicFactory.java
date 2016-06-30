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
public class PublicFactory extends VehicleFactory {//具体工厂类，主要功能是根据订单类型 调用具体类型的机动车生产线，并控制生产数量。
    // （在简单工厂模式中,一个工厂类处于对产品类实例化调用的中心位置上,它决定那一个产品类应当被实例化,
    // 如同一个交通警察站在来往的车辆流中,决定放行那一个方向的车辆向那一个方向流动一样。）

    private String factoryName="大众汽车工厂";
    private String orderCarType;
    private int carNumber;


    public PublicFactory(String orderCarType, int carNumber) {
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
