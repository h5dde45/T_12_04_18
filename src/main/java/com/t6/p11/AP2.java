package com.t6.p11;

import java.util.concurrent.atomic.AtomicReference;

public class AP2 {
    public static void main(String[] args) {
        AP ap = new AP();
        System.out.println(ap.getPt());
        ap.rotCW();
        System.out.println(ap.getPt());
    }
}
class AP{
    private final AtomicReference<Point> pt=new AtomicReference<>(new Point(0,1));
    public void rotCW(){
        pt.updateAndGet(Point::rotateCW);
    }
     static class Point{
        final int x;
        final int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        Point rotateCW(){
            return new Point(y,-x);
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public AtomicReference<Point> getPt() {
        return pt;
    }
}
