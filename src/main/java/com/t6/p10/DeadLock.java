package com.t6.p10;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class DeadLock {

    public static void main(String[] args) throws InterruptedException {
        Queue<String> in = new ArrayDeque<>(Arrays.asList("asd", "zxc", "qwe"));
        Queue<String> out = new ArrayDeque<>(Arrays.asList("asd", "zxc", "qwe"));
        Thread thread_1 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                transfer(in, out);
            }
        });
        Thread thread_2 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                transfer(out, in);
            }
        });
        System.out.println("start");
        thread_1.start();
        thread_2.start();
        thread_1.join();
        thread_2.join();
        System.out.println("finish");
    }

    private static void transfer(Queue<String> in, Queue<String> out) {
        synchronized (in) {
            synchronized (out) {
                String result = in.poll();
                if (result != null) {
                    out.add(result);
                }
            }
        }
    }

}
