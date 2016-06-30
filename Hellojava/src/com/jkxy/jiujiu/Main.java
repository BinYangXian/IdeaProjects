package com.jkxy.jiujiu;

public class Main {

    public static void main(String[] args) {
        for (int j = 1; j <= 9; j++) {     //九九乘法表{
            for (int i = 1; i <= j; i++) {
                System.out.printf("%d*%d=%d \t", i, j, i * j);
//                if(i*j/10==0)
//                    System.out.print(' ');
            }
            System.out.println();
        }
    }
}