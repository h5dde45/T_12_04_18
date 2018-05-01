package com.t6.p10;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App02 {

    public static void main(String[] args) throws InterruptedException {
        class Counter {
//            int x = 0;
            AtomicInteger y=new AtomicInteger(0);
        }
        Counter counter = new Counter();
        Runnable runnable = () -> {
            for (int i = 0; i < 1000_000; i++) {
//                counter.x++;
                counter.y.getAndIncrement();
            }
        };

        List<Thread> threads = Stream.generate(() -> new Thread(runnable))
                .limit(10)
                .peek(Thread::start)
                .collect(Collectors.toList());

        for (Thread thread : threads) {
            thread.join();
        }

//        System.out.println(counter.x);
        System.out.println(counter.y);

    }
}
