package com.t9.p10.d1;

public class D1 {
    public static void main(String[] args) {
        NewRunnable2 newRunnable2 = new NewRunnable2();

        for (int i = 0; i < 10; i++) {
//            new NewThread2().start();
            new Thread(newRunnable2).start();
//            new Thread(() ->   System.out.println("name thread: " + Thread.currentThread())).start();
        }
        System.out.println("name thread: " + Thread.currentThread());
    }

    private static class NewThread2 extends Thread {
        @Override
        public void run() {
            System.out.println("name thread: " + getName());
        }
    }

    private static class NewRunnable2 implements Runnable {
        @Override
        public void run() {
            System.out.println("name thread: " + Thread.currentThread());
        }
    }
}
