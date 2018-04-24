package com.t3.p5;

public class Main05 {
    static volatile int counter=0;
    static volatile boolean finish0=false;
    static volatile boolean finish1=false;
    public static void main(String[] args) {

        new Thread(() -> {
                for (int i = 0; i < 10_000_000; i++) {
                    counter++;
            }
            finish0=true;
        }).start();

        new Thread(() -> {
                for (int i = 0; i < 10_000_000; i++) {
                    counter++;
            }
            finish1=true;
        }).start();

       while (!finish0&& !finish1);

           System.out.println(counter);

    }
}
