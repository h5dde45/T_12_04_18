package com.t3.p9;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;

public class NewThreadPool implements Executor {
    private final BlockingQueue<Runnable> taskQueue =
            new ArrayBlockingQueue<>(1);

    private final Thread[] pool;

    public NewThreadPool(int threadCount) {
        pool = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            pool[i] = new Thread(() -> {
                while (true) {
                    try {
                        Runnable nestTask = taskQueue.take();
                        nestTask.run();
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            });
            pool[i].start();
        }
    }


    @Override
    public void execute(Runnable command) {
//        if(!taskQueue.offer(command)){
//            System.out.println("rejected");
//        }
        try {
            taskQueue.put(command);
        } catch (InterruptedException e) {
            throw new Error("never",e);
        }
    }
}
