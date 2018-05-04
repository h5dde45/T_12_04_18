package com.t8.p2;

public class SleepMessage {
    public static void main(String[] args) throws InterruptedException {
        String[] strings={"qwe","asd","zxc"};

        for (int i = 0; i < strings.length; i++) {
            Thread.sleep(4444);
            System.out.println(strings[i]);
        }
    }
}
