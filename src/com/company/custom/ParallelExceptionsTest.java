package com.company.custom;

import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;

public class ParallelExceptionsTest {

    public static final int PARALLELISM_OUTER = 30;
    public static final int PARALLEL_INNER = 10;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //TODO: check exceptions
        long startTime = System.currentTimeMillis();

        Object sum = commonPool();

        long stopTime = System.currentTimeMillis();
        System.out.println("SUM: " + sum);
        System.out.println("Parallelism: " + PARALLELISM_OUTER + ", time MS:" + (stopTime - startTime));
    }

    private static double commonPool() {
        return IntStream.range(1, 10)
                .parallel()
                .mapToDouble(i -> catchException(i))
                .sum();
    }

    private static double catchException(int i) {
        try {
            return add(i);
        } catch (Exception e) {
            System.err.println("Exception: " + e);
            return 0;
        }
    }

    private static double add(Integer i) {
        sleep();
        System.out.println(Thread.currentThread().getName() + " Processing outer stream value: " + i);
        if (i == 3) {
            throw new RuntimeException();
        }
        double sum = IntStream.range(1, 10)
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