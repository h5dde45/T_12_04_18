package com.t3.p5;

public class Main01 {
    public static void main(String[] args) {
        Object monitor = new Object();
        new Thread(() -> {
            while (true){
                synchronized (monitor){
                    System.out.println("+a");
                    System.out.println("-a");
                    try {
                        Thread.sleep(1112);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (true){
                synchronized (monitor){
                    System.out.println("+b");
                    System.out.println("-b");
                    try {
                        Thread.sleep(1112);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
