package com.t6.p10;

import java.util.ArrayList;
import java.util.List;

public class Container {
    private /*static*/ final List<String> list = new ArrayList<>();

    synchronized void addEntry(String s) {
        list.add(s);
    }

    public int getSize() {
        return list.size();
    }
}
