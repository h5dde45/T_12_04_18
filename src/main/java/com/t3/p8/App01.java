package com.t3.p8;

public class App01 {
    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                while (true) {
                    f();
                }
            }).start();
        }
    }

    public static synchronized void f() {
        System.out.println(Thread.currentThread().getName());
    }
}
