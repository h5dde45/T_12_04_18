package com.t3.p5;

public class Main06 {
    static /*volatile*/ int counter = 0;
    static volatile boolean finish0 = false;
    static volatile boolean finish1 = false;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                inc();
            }
            finish0 = true;
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                inc();
            }
            finish1 = true;
        }).start();

        while (!finish0 && !finish1) ;

        Thread.sleep(111);

        System.out.println(counter);

    }

    private static synchronized void inc() {
//        int tmp = counter;
//        tmp = tmp + 1;
//        counter = tmp;
        counter++;
    }

}
