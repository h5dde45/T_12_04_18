package com.t3.p9;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Demo6_Executors {
    public static void main(String[] args) {
//        Executor executor = Executors.newSingleThreadExecutor();
//        Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Executor executor = Executors.newCachedThreadPool();
        executor.execute(getTask());
        executor.execute(getTask());
        executor.execute(getTask());
    }

    private static Runnable getTask() {
        return () -> System.out.println("==> " + Thread.currentThread());
    }
}
