package com.t3.p9;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo_07_submit {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<Integer> future1 = executorService.submit(() -> 44);

        Future<Object> future2 = executorService.submit(() -> {
            while (true) {
            }
        });
        Thread.sleep(1000);
        System.out.println("future1 isDone():" + future1.isDone());
        System.out.println("future2 isDone():" + future2.isDone());

        System.out.println("f1");
        System.out.println(future1.get());
        System.out.println("f2");
        System.out.println(future2.get());
    }
}
