package com.t7.p11.d6;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class PrlForkJoinPool {
    public static void main(String[] args) {
        int[] array = Commons.prepareArray();
        long startTime = System.currentTimeMillis();

        ForkJoinPool pool = new ForkJoinPool();
        Double sum = pool.invoke(new RecursiveCalc(array, 0, array.length));
        System.out.println("sum = " + sum);
        System.out.println("time = " + (System.currentTimeMillis() - startTime) + "ms");
        pool.shutdown();
    }

    private static class RecursiveCalc extends RecursiveTask<Double> {
        private static final int sequential_threshold = 50_000;
        private final int[] array;
        private final int start;
        private final int finish;

        private RecursiveCalc(int[] array, int start, int finish) {
            this.array = array;
            this.start = start;
            this.finish = finish;
        }


        @Override
        protected Double compute() {
            if (finish - start <= sequential_threshold) {
                return Commons.calculate(array, start, finish);
            }else {
                int mid = start + (finish - start) / 2;
                RecursiveCalc left = new RecursiveCalc(array, start, mid);
                RecursiveCalc right = new RecursiveCalc(array, mid, finish);
                invokeAll(left,right);
                return left.join()+right.join();
            }
        }
    }
}
