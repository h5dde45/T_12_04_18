package com.t9.p11.d6;

import java.util.Arrays;

public class PS {
    public static void main(String[] args) {
            int[] array = Commons.prepareArray();
            long start = System.currentTimeMillis();
            double sum = Arrays.stream(array)
                    .parallel()
                    .mapToDouble(Commons::function)
                    .sum();
            System.out.println("sum: "+sum);
            System.out.println("time: "+(System.currentTimeMillis()-start)+"ms");
    }
}
