package com.t5.p4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> collect = Stream.of("as", "ereg", "edcdes", "dv")
                .filter(s -> s.length()>3)
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());
        List<Integer> collect2 = Stream.of("as", "ereg", "edcdes", "dv")
                .flatMap(s -> s.chars().boxed())
                .collect(Collectors.toList());
        Map<Integer, List<String>> collect1 = Stream.of("as", "ereg", "edcdes", "dv")
                .map(s -> s.toUpperCase())
                .collect(Collectors.groupingBy(o -> o.length()));
        System.out.println(collect);
        System.out.println(collect1);
        System.out.println(collect2);
//        for (Map.Entry<Integer, List<String>> entry:collect1.entrySet()){
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }
    }
}
