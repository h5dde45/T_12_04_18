package com.t7.p10;

public class T1 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> System.out.println(Thread.currentThread())).start();
        }
        NewThread newThread = new NewThread();
        newThread.start();
        System.out.println(newThread.isAlive());
        System.out.println("main");
    }
}
class NewThread extends Thread{
    @Override
    public void run() {
        System.out.println("new"+getName());
    }
}
