package com.jikexueyuan.carfactory;

/**
 * Created by yangx on 2015/12/25.
 2) 抽象产品角色：它一般是具体产品继承的父类或者实现的接口。在java中由接口或者抽象类来实现。*/
public abstract class Vehicle {//机动车生产线 抽象类
    private int _number;
    private String name;//由于此为抽象类，name是抽象的，不具体指某种车
    public int get_number() {
        return _number;
    }

    public Vehicle(int number) {
        this._number = number;
    }

    public abstract void produce();

    public abstract void printValue();


}
