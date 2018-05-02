package com.t7.p11.d2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Smphr {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(2,true);
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoThread demoThread = new DemoThread(semaphore);
            threads.add(demoThread);
            demoThread.start();
        }
        Thread.sleep(20_000);

        for (Thread thread : threads) {
            thread.interrupt();
        }

    }

    private static class DemoThread extends Thread {

        private final Semaphore semaphore;

        public DemoThread(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                runUnSafe();
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupter");
            }
        }

        private void runUnSafe() throws InterruptedException {
            while (true) {
                semaphore.acquire();
                try {
                    System.out.println(getName() + " acquired s");
                    Thread.sleep(4444);
                } finally {
                    System.out.println(getName() + " releasing s");
                    semaphore.release();
                }
            }
        }
    }
}
