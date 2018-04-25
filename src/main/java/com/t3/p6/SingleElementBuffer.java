package com.t3.p6;

public class SingleElementBuffer {
    private Integer elem;

    public synchronized void put(int newElem) throws InterruptedException {
        while (elem != null) {
            wait();
        }
        elem = newElem;
        notifyAll();
    }

    public synchronized int get() throws InterruptedException {
        while (elem == null) {
            wait();
        }
        Integer result = this.elem;
        elem = null;
        notifyAll();
        return result;
    }
}
