package com.t6.p10;

import java.util.ArrayList;
import java.util.List;

public class App01 {
    public static void main(String[] args) throws InterruptedException {
        Container container=new Container();

        Runnable runnable=() -> {
            for (int i = 0; i < 100_000; i++) {
                container.addEntry("foo");
            }
        };

        List<Thread> threads=new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
            threads.add(thread);
        }

        for (Thread thread:threads){
            thread.join();
        }

        System.out.println(container.getSize());
    }
}
