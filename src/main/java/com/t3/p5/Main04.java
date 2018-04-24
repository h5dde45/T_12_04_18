package com.t3.p5;

public class Main04 {
    static volatile boolean in = false;

    public static void main(String[] args) {
        Object monitor = new Object();
        new Thread(() -> {
            synchronized (monitor) {
                in = true;
                try {
                    Thread.sleep(Long.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        System.out.println("a");
        while (!in) ;
        System.out.println("b");
        synchronized (monitor) {
            System.out.println("c");
        }
    }
}
