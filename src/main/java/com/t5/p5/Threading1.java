package com.t5.p5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import static java.util.Collections.max;

public class Threading1 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<List<Integer>> listList = Arrays.asList(
                Arrays.asList(6, 8, 43, 6, 764),
                Arrays.asList(65, 8, 43, 6, 764),
                Arrays.asList(6, 866, 43, 6, 764),
                Arrays.asList(6, 8, 473, 6, 764),
                Arrays.asList(6, 85, 43, 6, 764),
                Arrays.asList(6, 8768, 43, 6, 764)
        );

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Future<Integer>> futures = new ArrayList<>();

        for (List<Integer> list : listList) {
            Future<Integer> future = executorService.submit(() ->
                    max(list, Integer::compareTo));
            futures.add(future);
        }

        for (Future<Integer> future : futures) {
            System.out.println(future.get());
        }

        List<Integer> collect = futures.stream().map(integerFuture -> {
            try {
                return integerFuture.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException();
            }
        }).collect(Collectors.toList());

        System.out.println(collect);
        System.exit(0);
    }
}

