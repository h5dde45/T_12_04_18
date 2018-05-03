package com.t7.p11.d5;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExServD {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        System.out.println("submit worker 1");
        Future<String> future1 = executorService.submit(new Worker("worker1"));
        System.out.println("submit worker 2");
        Future<String> future2 = executorService.submit(new Worker("worker2"));
        System.out.println("result w1: " + future1.get());
        System.out.println("result w2: " + future2.get());

        System.out.println("====================");

        System.out.println("invokeAll");
        List<Future<String>> futureList = executorService.invokeAll(Arrays.asList(new Worker("w3"),
                new Worker("w4"),
                new Worker("w5")
        ));
        System.out.println("exited invokeAll");
        for (Future<String> future:futureList){
            System.out.println("=> "+future.get()
            );
        }

        executorService.shutdown();
        System.out.println("====================");

        executorService.awaitTermination(10,TimeUnit.SECONDS);
    }

    private static class Worker implements Callable<String> {
        private final String name;

        private Worker(String name) {
            this.name = name;
        }

        @Override
        public String call() throws Exception {
            long sleepTime = (long) (Math.random() * 1000);
            System.out.println(name + " start, going to sleep for " + Thread.currentThread());
            Thread.sleep(sleepTime);
            System.out.println(name + " finish");
            return name;
        }
    }
}
