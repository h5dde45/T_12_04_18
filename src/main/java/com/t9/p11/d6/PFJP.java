package com.t9.p11.d6;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class PFJP {
    public static void main(String[] args) {
        int[] array = Commons.prepareArray();
        ForkJoinPool pool = new ForkJoinPool();
        long start = System.currentTimeMillis();
//        double sum = pool.invoke(new RecursCalc(array,0,array.length));
//        System.out.println("sum: "+sum);
        System.out.println("time: "+(System.currentTimeMillis()-start)+"ms");
    }

    private static class RecursCalc extends RecursiveTask<Double> {

        @Override
        protected Double compute() {
            return null;
        }
    }
}
