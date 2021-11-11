package com.company.custom;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Optional.*;

public class FutureExceptionsTest {

    private static final Executor executor = Executors.newFixedThreadPool(30);


    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        supplyWithStream();
        supplyWithGenerator();
//        supplyManually();
    }

    private static void supplyWithGenerator() {
        List<CompletableFuture<String>> futures = Stream.generate(FutureExceptionsTest::async)
                .limit(30)
                .collect(Collectors.toList());
        String collect = futures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.joining("\n"));
        System.out.println(collect);
    }

    private static void supplyWithStream() throws ExecutionException, InterruptedException {
        CompletableFuture<String> cf1 = async();
        CompletableFuture<String> cf2 = async();
        CompletableFuture<String> cf3 = async();
        CompletableFuture<String> cf4 = async();
        String collect = Stream.of(cf1, cf2, cf3, cf4)
                .map(CompletableFuture::join)
                .collect(Collectors.joining("\n"));
        System.out.println(collect);
    }

    private static void supplyManually() throws ExecutionException, InterruptedException {
        CompletableFuture<String> cf1 = async();
        CompletableFuture<String> cf2 = async();
        CompletableFuture<String> cf3 = async();
        CompletableFuture<String> cf4 = async();
        CompletableFuture<Void> cfAll = CompletableFuture.allOf(cf1, cf2, cf3, cf4);
        System.out.println(cfAll.get());
        System.out.println(cf1.get());
        System.out.println(cf2.get());
        System.out.println(cf3.get());
        System.out.println(cf4.get());

    }

    private static CompletableFuture<String> async() {
        return CompletableFuture
                .supplyAsync(FutureExceptionsTest::generate, executor)
//                .supplyAsync(FutureExceptionsTest::generate)
                .handle(FutureExceptionsTest::defaultOnError);
    }

    private static String defaultOnError(String successResult, Throwable error) {
        logIfError(error);
        return ofNullable(successResult)
                .orElse("Default name");
    }

    private static void logIfError(Throwable error) {
        if (error != null) {
            System.err.println("Exception occurred: " + error);
        }
    }

    private static String generate() {
        System.out.println("Started: " + LocalDateTime.now());
        sleep();
//        throwErrorOnRandomTime();
        return LocalDateTime.now() + " : " + new Random().ints()
                .limit(10)
                .mapToObj(i -> (char) i)
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void throwErrorOnRandomTime() {
        if (System.currentTimeMillis() % 3 == 0) {
            throw new RuntimeException();
        }
    }


}