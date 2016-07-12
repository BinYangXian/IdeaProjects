package com.jikexueyuan;

public class JiuJiuChengFaBiao {

    public static void main(String[] args) {
        double[] arr = new double[10];
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d*%d=%d\t", j, i, i * j);
                arr[i - 1] = i * j;
            }
            System.out.println();
        }
        double max = getMaxNumber(arr);
        System.out.println(max);
    }

    private static double getMaxNumber(double[] arr) {
        double maxNumber = arr[0];
        if (arr.length >= 1) {
            for (int i = 1; i < arr.length; i++) {
                if (maxNumber < arr[i]) {
                    maxNumber = arr[i];
                }
            }
        }
        return maxNumber;
    }
}
