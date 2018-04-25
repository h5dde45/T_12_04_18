package com.t3.p6;

public class PCE_3_0 {
    public static void main(String[] args) {
        SingleElementBuffer buffer = new SingleElementBuffer();

        new Thread(new Producer(1,1,1000,buffer)).start();
        new Thread(new Producer(2,1,1000,buffer)).start();
        new Thread(new Producer(3,1,1000,buffer)).start();
    }
}
