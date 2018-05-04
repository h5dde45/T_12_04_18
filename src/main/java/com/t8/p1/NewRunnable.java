package com.t8.p1;

public class NewRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("============");
    }

    public static void main(String[] args) {
        new Thread(new NewRunnable()).start();
    }
}
