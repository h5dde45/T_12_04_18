package com.t8.p1;

public class NewThread extends Thread{
    @Override
    public void run() {
        System.out.println("++++++++");
    }

    public static void main(String[] args) {

        new NewThread().start();
    }
}
