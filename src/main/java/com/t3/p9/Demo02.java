package com.t3.p9;

import java.util.concurrent.Executor;

public class Demo02 {
    public static void main(String[] args) {
        Executor executor0 = getExecutor();
        executor0.execute(getTask());
        executor0.execute(getTask());


        System.out.println(Thread.currentThread());

    }


    private static Executor getExecutor() {
        return new Executor() {
            @Override
            public void execute(Runnable runnable) {
                runnable.run();
            }
        };
    }

    private static Runnable getTask() {
        return () -> System.out.println(Thread.currentThread());
    }

}
