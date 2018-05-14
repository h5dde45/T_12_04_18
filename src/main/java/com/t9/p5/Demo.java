package com.t9.p5;

import java.lang.ref.WeakReference;

public class Demo {
    public static void main(String[] args) {
//        WeakReference<Integer> weakReference = new WeakReference<>(1);
        WeakReference<Integer> weakReference = new WeakReference<>(1000);
        System.out.println(weakReference.get());

        for (int i = 1; weakReference.get() != null; i++) {
            System.gc();
            System.out.println(i + ", " + weakReference.get());
        }
    }
}
