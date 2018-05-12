package com.t9.p11.d6;

import java.util.concurrent.*;

public class ES {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] array = Commons.prepareArray();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        long start = System.currentTimeMillis();

        Future<Double> future1 = executorService.submit(new PartialCalc(array, 0, array.length / 2));
        Future<Double> future2 = executorService.submit(new PartialCalc(array, array.length / 2, array.length));

        double sum = future1.get() + future2.get();
        System.out.println("sum: " + sum);
        System.out.println("time: " + (System.currentTimeMillis() - start) + "ms");

        executorService.shutdown();
    }

    private static class PartialCalc implements Callable<Double> {
        private final int[] array;
        private final int start;
        private final int finish;

        private PartialCalc(int[] array, int start, int finish) {
            this.array = array;
            this.start = start;
            this.finish = finish;
        }


        @Override
        public Double call() throws Exception {
            return Commons.calculate(array, start, finish);
        }
    }
}
