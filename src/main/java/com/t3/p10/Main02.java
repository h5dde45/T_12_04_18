package com.t3.p10;

import java.util.stream.Stream;

public class Main02 {
    public static void main(String[] args) {
//        Stream<Long> stream = Stream.iterate(3L, t -> t + 1).filter(a -> a % 3 == 2);
        Stream
                .iterate(3L, t -> t + 1)
                .filter(a -> a % 3 == 2)
                .map(i->"=> "+i)
                .limit(7)
                .forEach(System.out::println);

    }
}
