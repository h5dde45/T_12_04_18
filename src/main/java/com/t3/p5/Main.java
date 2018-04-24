package com.t3.p5;

public class Main {
    public static void main(String[] args) {
        Object monitor = new Object();
        new Thread(() -> {
            System.out.println("a begin");
            synchronized (monitor){
                while (true){
                    System.out.println("a");
                    try {
                        Thread.sleep(1111);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            System.out.println("b begin");
            synchronized (monitor){
                while (true){
                    System.out.println("b");
                    try {
                        Thread.sleep(1111);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
