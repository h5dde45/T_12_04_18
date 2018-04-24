package com.t2.p20.g1;

import java.util.ArrayList;
import java.util.List;

public class App01 {
    public static void main(String[] args) {
        List<Point> list = new ArrayList<>();
        list.add(new Point(0,0));
        list.add(new Point(1,1));
        System.out.println(list.contains(new Point(1,1)));

    }
}

class Point implements Comparable{
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Object o) {

        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
