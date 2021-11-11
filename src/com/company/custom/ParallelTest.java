package com.company.custom;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;

public class ParallelTest {

    public static final int PARALLELISM_OUTER = 30;
    public static final int PARALLEL_INNER = 10;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("CPU Core: " + Runtime.getRuntime().availableProcessors());
        System.out.println("CommonPool Parallelism: " + ForkJoinPool.commonPool().getParallelism());
        System.out.println("CommonPool Common Parallelism: " + ForkJoinPool.getCommonPoolParallelism());
        long startTime = System.currentTimeMillis();

//        Object sum = customPool(PARALLELISM_OUTER);
        Object sum = commonPool();
//        Object sum1 = customPool(PARALLELISM_OUTER);
//        Object sum2 = customPool(PARALLELISM_OUTER);
//        Object sum1 = commonPool();
//        Object sum2 = commonPool();

        long stopTime = System.currentTimeMillis();
        System.out.println("SUM: " + sum);
        System.out.println("Parallelism: " + PARALLELISM_OUTER + ", time MS:" + (stopTime - startTime));
    }

    private static Object customPool(int parallelism) throws InterruptedException, ExecutionException {
        ForkJoinPool pool = new ForkJoinPool(parallelism);
        return pool.submit(ParallelTest::commonPool).get();
    }

    private static double commonPool() {
        return Stream.of(1, 2, 3)
                .parallel()
                .mapToDouble(ParallelTest::add)
                .sum();
    }

    private static double add(Integer i) {
        sleep();
        System.out.println(Thread.currentThread().getName() + " Processing outer stream value: " + i);
        double sum = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .parallel()
                .mapToDouble(i1 -> addAgain(i, i1))
                .sum();
        System.out.println(Thread.currentThread().getName() + " Outer finished for value" + i);
        return sum;
    }

//    private static double add(Integer i) {
//        sleep();
//        System.out.println(Thread.currentThread().getName() + " outer stream: " + i);
//        ForkJoinPool pool = new ForkJoinPool(PARALLEL_INNER);
//        try {
//            return pool.submit(() ->  Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
//                    .parallel()
//                    .mapToDouble(i1 -> addAgain(i, i1))
//                    .sum()).get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Thread.currentThread().getName() + " Outer finished for value" + i);
//        return 0;
//    }

    private static double addAgain(Integer i, Integer i1) {
        sleep();
        System.out.println(Thread.currentThread().getName() + " inner stream value1:" + i + ", value2: " + i1);
        return i + i1;
    }

    private static void sleep() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}