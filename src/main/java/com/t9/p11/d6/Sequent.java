package com.t9.p11.d6;

public class Sequent {
    public static void main(String[] args) {
        int[] array = Commons.prepareArray();
        long start = System.currentTimeMillis();
        double sum = Commons.calculate(array);
        System.out.println("sum: "+sum);
        System.out.println("time: "+(System.currentTimeMillis()-start)+"ms");
    }
}
