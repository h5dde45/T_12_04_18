package com.t5.p6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.Collections.max;

public class ThreadingPool {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = Arrays.asList(1, 4, 6, 4, 5, 3, 8, 6, 4, 7);
        List<Integer> list2 = Arrays.asList(12, 34, 64, 45, 56, 73, 8, 6, 4, 7);
        ArrayList<Integer> arrayList = new ArrayList<>();
//        Lock lock = new Lock();
        ReentrantLock lock = new ReentrantLock();

        Thread thread = new Thread(() -> {
            Integer max = max(list, Integer::compare);
            lock.lock();
            try {
                arrayList.add(max);
            } finally {
                lock.unlock();
            }
            System.out.println(max);
        });
        thread.start();

        Thread thread2 = new Thread(() -> {
            Integer max = max(list2, Integer::compare);
            lock.lock();
            try {
                arrayList.add(max);
            } finally {
                lock.unlock();
            }
            System.out.println();
        });
        thread2.start();


        thread.join();
        thread2.join();
        System.out.println(arrayList);
    }
}

