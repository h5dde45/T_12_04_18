package com.t3.p9;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Demo_07_submit {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Callable<Integer> task1 = () -> 44;
        Callable<Integer> task11 = () -> 22;
        Future<Integer> future1 = executorService.submit(task1);

        Callable<Object> task2 = () -> {
            while (true) {
                if(Thread.interrupted()){
                    throw new InterruptedException();
                }
            }
        };
        Future<Object> future2 = executorService.submit(task2);
        Thread.sleep(1000);
        System.out.println("future1 isDone():" + future1.isDone());
        System.out.println("future2 isDone():" + future2.isDone());

        System.out.println("f1");
        System.out.println(future1.get());
        System.out.println("f2");
//        System.out.println(future2.get());

        List<Future<Integer>> futures=executorService.invokeAll(Arrays.asList(task1,task11));
        System.out.println(futures);
        executorService.shutdownNow();
    }
}
