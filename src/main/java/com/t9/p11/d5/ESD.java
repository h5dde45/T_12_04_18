package com.t9.p11.d5;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ESD {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        System.out.println("submit w1");
        Future<String> future1 = executor.submit(new Worker("worker1"));

        System.out.println("submit w2");
        Future<String> future2 = executor.submit(new Worker("worker2"));

        System.out.println("result w1: " + future1.get());
        System.out.println("result w2: " + future2.get());

        System.out.println("==========================");

        List<Future<String>> futures = executor.invokeAll(Arrays.asList(
                new Worker("w3"), new Worker("w4"), new Worker("w5")));

        System.out.println("exited invokeAll");
        for (Future<String> future : futures) {
            System.out.println("result: " + future.get());
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);


    }

    private static class Worker implements Callable<String> {
        private final String name;

        private Worker(String name) {
            this.name = name;
        }

        @Override
        public String call() throws Exception {
            long sleepTime = (long) (Math.random() * 10_000);
            System.out.println(name + " start, sleep for " + sleepTime);
            Thread.sleep(sleepTime);
            System.out.println(name + " finish");
            return name;
        }
    }
}
