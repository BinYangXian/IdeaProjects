package com.wangyi.coinform;

import java.util.ArrayList;

public class CoinForm {


    public static void main(String[] args) {
//        String s="+20";
////        String s1="30";
////        s="20";
//        int a=Integer.parseInt(s);
//        System.out.println(a);
        ArrayList<Double> registor=new ArrayList<>();
        registor.add(1.2);
        registor.add(2.3);
        registor.add(registor.size()-1,3.4);
        System.out.println(registor);
    }
}
