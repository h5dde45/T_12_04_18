package com.t7.p11.d6;

import java.util.Arrays;

public class PrlStrm {
    public static void main(String[] args) {
        int[] array = Commons.prepareArray();
        long startTime = System.currentTimeMillis();
        double sum = Arrays.
                stream(array)
                .parallel()
                .mapToDouble(Commons::function)
                .sum();
        System.out.println("sum = " + sum);
        System.out.println("time = " + (System.currentTimeMillis() - startTime)+"ms");
    }
}
