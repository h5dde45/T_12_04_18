package com.t3.p10;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main01 {
    public static void main(String[] args) {
        new Thread(Main01::print).start();

        Arrays.asList("a", "bb", "ccc")
                .parallelStream()
//                .stream()
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return s.length();
                    }
                })
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) {
                        return integer % 2 == 1;
                    }
                })
                .forEach(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer x) {
                        System.out.println(x);
                    }
                });
    }

    public static void print() {
        System.out.println("+++++");
    }
}
