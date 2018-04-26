package com.t3.p9;

public class Demo00 {
    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("===");
            }
        };
        new Thread(task).start();
    }
}
