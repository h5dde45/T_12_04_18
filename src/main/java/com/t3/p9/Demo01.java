package com.t3.p9;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;

public class Demo01 {
    public static void main(String[] args) {
        Executor executor0 = getExecutor();
        executor0.execute(getTask());
        executor0.execute(getTask());

        Executor executor1 = getExecutor();
        executor1.execute(getTask());
        executor1.execute(getTask());
        executor1.execute(getTask());

        System.out.println(Thread.currentThread());

    }

    private static Runnable getTask() {
        return () -> System.out.println(Thread.currentThread());
    }

    private static Executor getExecutor() {
        return new Executor() {
            private final AtomicLong index = new AtomicLong(0);
            private final ThreadGroup group = new ThreadGroup("NewGroup");

            @Override
            public void execute(Runnable command) {
                Thread thread = new Thread(group, command);
                thread.setPriority(Thread.NORM_PRIORITY + 1);
                thread.setDaemon(true);
                thread.setName("Thread#" + index.getAndIncrement());
                thread.start();
            }
        };
    }
}
