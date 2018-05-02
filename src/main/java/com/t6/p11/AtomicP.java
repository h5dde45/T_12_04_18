package com.t6.p11;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicP {
    public static void main(String[] args) {
        AtomicPoint atomicPoint = new AtomicPoint();
        System.out.println(atomicPoint.getX());
        System.out.println(atomicPoint.getY());
        atomicPoint.rotateClockwise();
        System.out.println(atomicPoint.getX());
        System.out.println(atomicPoint.getY());
    }

}

class AtomicPoint {
    private final AtomicInteger x = new AtomicInteger(0);
    private final AtomicInteger y = new AtomicInteger(1);

    public void rotateClockwise() {
        int oldX = x.getAndSet(y.get());
        y.set(-oldX);
    }

    public AtomicInteger getX() {
        return x;
    }

    public AtomicInteger getY() {
        return y;
    }
}