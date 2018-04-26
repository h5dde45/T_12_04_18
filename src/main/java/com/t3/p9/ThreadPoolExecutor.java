package com.t3.p9;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolExecutor {
    public static void main(String[] args) {
        int corePoolSize=4;
        int maxPoolSize=64;
        long keepAliveTime=10;
        TimeUnit unit=TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue=new ArrayBlockingQueue<Runnable>(256);
        ThreadFactory threadFactory=new ThreadFactory() {
            private AtomicInteger counter=new AtomicInteger(0);
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setPriority(Thread.NORM_PRIORITY);
                thread.setName("NewPool-NormPriority-"+counter.incrementAndGet());
                return thread;
            }
        };
    }
}
