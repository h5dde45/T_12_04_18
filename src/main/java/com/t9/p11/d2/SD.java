package com.t9.p11.d2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class SD {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(2,true);

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 11; i++) {
            DThread dThread = new DThread(semaphore);
            threads.add(dThread);
            dThread.start();
        }
        Thread.sleep(20_000);

        for (Thread thread : threads) {
            thread.interrupt();
        }
    }

    private static class DThread extends Thread {
        private final Semaphore semaphore;

        private DThread(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                runUnSafe();
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted");
            }
        }

        private void runUnSafe() throws InterruptedException {
            while (true) {
                semaphore.acquire();
                try {
                    System.out.println(getName() + " acquired semaphore");
                    Thread.sleep(5000);
                } finally {
                    System.out.println(getName() + " releasing semaphore");
                    semaphore.release();
                }
            }

        }
    }
}
