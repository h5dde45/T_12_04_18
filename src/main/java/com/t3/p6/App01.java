package com.t3.p6;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App01 {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(16);

        //producer
        new Thread(() -> {
            int counter = 0;
            while (true) {
                try {
                    Thread.sleep(333);
                    queue.put(counter++);
                    System.out.println("put: " + counter);
                } catch (InterruptedException ignore) {
                }
            }
        }).start();

        //consumer
        new Thread(() -> {
            while (true) {
                try {
                  int  data = queue.take();
                    System.out.println("take: " + data);
                } catch (InterruptedException ignore) {
                }
            }
        }).start();
    }

}
