package com.t5.p6;

public class DeadLock2 {
    public static void main(String[] args) {
        Browser browser = new Browser();

//        for (int i = 0; i < 10; i++) {
//            Page page = browser.openPage();
//            System.out.println("page " + i);
//            new Thread(() -> {
//
//                page.close();
//            }).start();
//            System.out.println("close " + i);
//        }
//
//        browser.close();
    }
}
