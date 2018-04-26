package com.t3.p9;

import java.util.concurrent.Executor;

public class Demo03 {
    public static void main(String[] args) {
        Executor executor = new NewThreadPool(2);
        executor.execute(getTask());
        executor.execute(getTask());
        executor.execute(getTask());
        executor.execute(getTask());


        System.out.println(Thread.currentThread());

    }

    private static Runnable getTask() {
        return () -> {
            System.out.println(Thread.currentThread());
            while (true) ;
        };
    }

}
