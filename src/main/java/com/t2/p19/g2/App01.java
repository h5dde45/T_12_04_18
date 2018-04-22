package com.t2.p19.g2;

import java.util.*;

public class App01 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("1", "e2", "2","343","r"));
        System.out.println(list);
        System.out.println(new HashSet<>(list));
        TreeSet<String> set = new TreeSet<>(Collections.reverseOrder());
        System.out.println(set.addAll(list));
        System.out.println(set);
    }
}
