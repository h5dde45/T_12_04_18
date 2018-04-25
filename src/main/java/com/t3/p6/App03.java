package com.t3.p6;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class App03 {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingDeque<>(16);

        //producer
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            new Thread(() -> {
                int counter = 0;
                while (true) {
                    try {
                        Thread.sleep(300+1000*finalI);
                        String data = "elem:" + finalI + " #" + ++counter;
                        queue.put(data);
                        System.out.println("put: " + data);
                    } catch (InterruptedException ignore) {
                    }
                }
            }).start();
        }

        //consumer
        new Thread(() -> {
            while (true){
                try {
                    String data = queue.take();
                    System.out.println("take: " + data);
                } catch (InterruptedException ignore) {
                }
            }
        }).start();
    }

}
