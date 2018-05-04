package com.t8.p3;

public class SleepMessage2 {
    public static void main(String[] args) {
        String[] strings={"qwe","asd","zxc"};

        for (int i = 0; i < strings.length; i++) {
            try {
                Thread.sleep(4444);
            } catch (InterruptedException e) {
                System.err.println("7777777777");
            }
            System.out.println(strings[i]);
        }
    }
}
