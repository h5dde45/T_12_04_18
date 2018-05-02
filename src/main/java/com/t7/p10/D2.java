package com.t7.p10;

public class D2 {
    public static void main(String[] args) throws InterruptedException {
        WorkerThread workerThread = new WorkerThread();
        SleeperThread sleeperThread = new SleeperThread();
        System.out.println("start");
        workerThread.start();
        sleeperThread.start();

        Thread.sleep(111);

        System.out.println("interrupting");
        workerThread.interrupt();
        sleeperThread.interrupt();

        System.out.println("join");
        workerThread.join();
        sleeperThread.join();

        System.out.println("all down");
    }

    private static class WorkerThread extends Thread {
        @Override
        public void run() {
            long sum = 0;
            for (int i = 0; i < 1000_000_000; i++) {
                sum += i;
                if (i % 100 == 0 && isInterrupted()) {
                    System.out.println("loop interrupted at i = " + i);
                    break;
                }
            }
        }
    }
    private static class SleeperThread extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(11111);
            } catch (InterruptedException e) {
                System.out.println("sleep interrupted");
            }
        }
    }
}
