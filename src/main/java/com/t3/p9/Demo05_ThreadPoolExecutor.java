package com.t3.p9;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo05_ThreadPoolExecutor {
    public static void main(String[] args) {

        int corePoolSize = 4;
        int maxPoolSize = 64;
        long keepAliveTime = 10;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(256);
        ThreadFactory threadFactory = new ThreadFactory() {
            private AtomicInteger counter = new AtomicInteger(0);

            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setPriority(Thread.NORM_PRIORITY);
                thread.setName("NewPool-NormPriority-" + counter.incrementAndGet());
                return thread;
            }
        };

        RejectedExecutionHandler rejectedHandler = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, java.util.concurrent.ThreadPoolExecutor executor) {
                System.out.println("All thread busy + task queue is full");
            }
        };


        Executor executor = new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                keepAliveTime,
                unit,workQueue,
                threadFactory,
                rejectedHandler
        );
        executor.execute(getTask());
        executor.execute(getTask());
        executor.execute(getTask());
    }

    private static Runnable getTask() {
        return () -> System.out.println("==> "+Thread.currentThread());
    }


//    public Demo05_ThreadPoolExecutor(int corePoolSize, int maxPoolSize,
//                                     long keepAliveTime, TimeUnit unit,
//                                     BlockingQueue<Runnable> workQueue,
//                                     ThreadFactory threadFactory,
//                                     RejectedExecutionHandler executionHandler) {
//        this.corePoolSize=corePoolSize;
//        this.maxPoolSize=maxPoolSize;
//        this.keepAliveTime=keepAliveTime;
//        this.unit=unit;
//        this.workQueue=workQueue;
//        this.threadFactory=threadFactory;
//        this.executionHandler=executionHandler;
//    }
}
