package com.t3.p5;

public class Main02 {
    public static void main(String[] args) {
        Object monitor = new Object();
        Object monitor2 = new Object();
        new Thread(() -> {
            System.out.println("a begin");
            synchronized (monitor){
                while (true){
                    System.out.println("a");
                    try {
                        Thread.sleep(111);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            System.out.println("b begin");
            synchronized (monitor2){
                while (true){
                    System.out.println("b");
                    try {
                        Thread.sleep(111);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
