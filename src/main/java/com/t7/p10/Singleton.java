package com.t7.p10;

public class Singleton {
    private int foo;
    private String bar;

    public Singleton() {
        this.foo = 4;
        this.bar = "asd";
    }

    private static Singleton instance;

    public synchronized static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
