package com.t3.p6;

public class PCE_1_0 {
    public static void main(String[] args) {
        SingleElementBuffer buffer = new SingleElementBuffer();

        new Thread(new Producer(1,1,1000,buffer)).start();
    }
}
