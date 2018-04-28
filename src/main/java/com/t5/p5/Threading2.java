package com.t5.p5;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.max;

public class Threading2 {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = Arrays.asList(1, 4, 6, 4, 5, 3, 8, 6, 4, 7);
        List<String> list2 = Arrays.asList("2ee4ее3", "ergheedr", "hye4е5re6");

        Thread thread = new Thread(() ->
                System.out.println(max(list2, (o1, o2) ->
                        (int) (o2.chars().filter(value -> value == 'e').count()
                                - o1.chars().filter(value -> value == 'e').count()))
                ));
        thread.start();

        Thread thread1 = new Thread(() ->
                System.out.println(max(list, Integer::compare))
        );
        thread1.start();

        thread.join();
        thread1.join();

        System.exit(0);
    }
}
