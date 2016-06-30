package com.jikexueyuan.carfactory;

/**
 * Created by yangx on 2015/12/25.
 1)抽象工厂角色： 这是工厂方法模式的核心，它与应用程序无关。是具体工厂角色必须实现的接口或者必须继承的父类。
 在java中它由抽象类或者接口来实现。
 */
public abstract class VehicleFactory {
    private String orderCarType;
    private int carNumber;
    public abstract Vehicle createCar();

    public VehicleFactory() {//????需要么

    }
}
