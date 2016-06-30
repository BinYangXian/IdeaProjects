package com.wangyi.clock;

/**
 * Created by fangc on 2016/1/11.
 */
public class Display {
    private int value;
    private int upLimit;
    Display(int upLimit){
        this.upLimit=upLimit;
    }
    public boolean increase(){
        value++;
        if (value==upLimit){
            value=0;
            return true;
        }
        else return false;
    }
    public int getValue(){
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
