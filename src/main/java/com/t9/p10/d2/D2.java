package com.t9.p10.d2;

public class D2 {
    public static void main(String[] args) throws InterruptedException {
        WorkerThread workerThread = new WorkerThread();
        SleeperThread sleeperThread = new SleeperThread();

        System.out.println("start");
        sleeperThread.start();
        workerThread.start();

        Thread.sleep(111);

        System.out.println("interrupter");
        sleeperThread.interrupt();
        workerThread.interrupt();

        System.out.println("join");
        sleeperThread.join();
        workerThread.join();

        System.out.println("all done");
    }

    private static class WorkerThread extends Thread{
        @Override
        public void run() {
            long sum=0;
            for (int i = 0; i < 1000_000_000; i++) {
                sum+=i;
                if(i%100==0 && isInterrupted()){
                    System.out.println("loop interrupted at i = "+i);
                    break;
                }
            }
        }
    }

    private static class SleeperThread extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("sleep interrupted");
            }
        }
    }
}
