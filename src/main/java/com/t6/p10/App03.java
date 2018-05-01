package com.t6.p10;

public class App03 {
    public static void main(String[] args) throws InterruptedException {
        class Foo {
            int x = 0;
            volatile int y = 0;
        }

        for (int i = 0; i < 100_000; i++) {
            Foo foo = new Foo();
            Thread thread_1 = new Thread(() -> {
                foo.x = 1;
                foo.y = 1;
            });
            Thread thread_2 = new Thread(() -> {
                while (foo.y != 1) {
                }
                System.out.println(foo.x);
            });

            thread_1.start();
            thread_2.start();
            thread_1.join();
            thread_2.join();
        }
    }
}
