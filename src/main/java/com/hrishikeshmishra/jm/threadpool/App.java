package com.hrishikeshmishra.jm.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author hrishikesh.mishra
 */
public class App {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor  = Executors.newFixedThreadPool(2);

        for (int i=0; i <5; i ++){
            executor.submit(new Processor(i));
        }

        executor.shutdown();

        System.out.println("All tasks submitted. ");

        executor.awaitTermination(1, TimeUnit.DAYS);

        System.out.println("All tasks completed. ");
    }
}
