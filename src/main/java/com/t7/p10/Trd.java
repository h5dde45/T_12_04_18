package com.t7.p10;

import java.util.Arrays;

public class Trd {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("444"));
        System.out.println(thread.getName());
        System.out.println(thread.getId());
        System.out.println(thread.isDaemon());
        System.out.println(Arrays.toString(thread.getStackTrace()));
        System.out.println(thread.getThreadGroup());


    }
}
