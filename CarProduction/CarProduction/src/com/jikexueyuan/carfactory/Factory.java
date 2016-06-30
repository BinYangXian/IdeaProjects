package com.jikexueyuan.carfactory;

/**
 * Created by yangx on 2015/12/25.
 1) 工厂类角色：这是本模式的核心，含有一定的商业逻辑和判断逻辑。在java中它往往由一个具体类实现。
 */
public class Factory {//工厂类，主要功能是根据订单类型 调用具体类型的机动车生产线，并控制生产数量。
    // （在简单工厂模式中,一个工厂类处于对产品类实例化调用的中心位置上,它决定那一个产品类应当被实例化,
    // 如同一个交通警察站在来往的车辆流中,决定放行那一个方向的车辆向那一个方向流动一样。）
    Vehicle createCar(String type, int carNumber) {
        if (type.equals("小车")) {
            return new SmallCar(carNumber);
        } else if (type.equals("大客车")) {
            return new Bus(carNumber);
        } else if (type.equals("大卡车")) {
            return new Truck(carNumber);
        } else if (type.equals("跑车")) {
            return new SportCar(carNumber);
        } else {
            return null;
        }
    }
}
