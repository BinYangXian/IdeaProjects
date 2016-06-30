package com.jkxy.maxarray;

public class Main {

    public static void main(String[] args) {//String[]字符串类型的数组，args是参数名
        int[] a={2, 4, 6, 8, 3, 6, 8, 4, 12, 60,};
        System.out.println(maxNum(a));//输出数组中最大值。
    }
    public static int maxNum(int[] array) {//申明一个maxNum函数，接收的参数类型为int型的数组，返回一个int值。
        int max=array[0];
        for(int j = 1; j < array.length; j++) {
            if(array[j] > max)
                max = array[j];
        }
        return max;
    }
}
