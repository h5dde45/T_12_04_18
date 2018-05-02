package com.t6.p11;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class App01 {
    private final AtomicBoolean flag = new AtomicBoolean(false);

    void doOnce(Runnable runnable) {
        if (flag.compareAndSet(false, true)) {
            runnable.run();
        }
    }

    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("333333333");

        App01 app01 = new App01();
        app01.doOnce(runnable);
        app01.doOnce(runnable);

        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.getAndUpdate(operand -> operand + 5);
        System.out.println(atomicInteger);
    }
}
