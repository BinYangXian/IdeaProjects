package com.wangyi.clock;

/**
 * Created by fangc on 2016/1/11.
 */
public class  Clock {
    Display hour=new Display(24);
    Display minite=new Display(60);
    Display second=new Display(60);
    public Clock(int hour, int minute, int second){
        this.hour.setValue(hour);
        this.minite.setValue(minute);
        this.second.setValue(second);
    }
    public void start(){
        while (true){
            second.increase();
            if (second.getValue()==0){
                minite.increase();
                if (minite.getValue()==0){
                    hour.increase();
                }
            }
            System.out.printf("%02d:%02d:%02d\n",hour.getValue(),minite.getValue(),second.getValue());

        }
    }
//    public void showTime(){
//        System.out.println(String.format("%02d:%02d:%02d",hour.getValue(),minite.getValue(),second.getValue()));
//    }
}
