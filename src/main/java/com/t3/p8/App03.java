package com.t3.p8;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class App03 {
    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        Lock r = readWriteLock.readLock();
        Lock w = readWriteLock.writeLock();

        new Thread(() -> {
//            r.lock();
            w.lock();
            System.out.println("2");
            while (true) {
            }
        }).start();

        new Thread(() -> {
            r.lock();
//            w.lock();
            System.out.println("0");
            while (true) {
            }
        }).start();

        new Thread(() -> {
            r.lock();
//            w.lock();
            System.out.println("1");
            while (true) {
            }
        }).start();


    }
}
