package com.t7.p11.d6;

public class Sequential {
    public static void main(String[] args) {
        int[] array = Commons.prepareArray();
        long startTime = System.currentTimeMillis();
        double sum = Commons.calculate(array);
        System.out.println("sum = " + sum);
        System.out.println("time = " + (System.currentTimeMillis() - startTime)+"ms");

    }
}
