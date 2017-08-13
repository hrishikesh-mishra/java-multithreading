package com.hrishikeshmishra.jm.callableandfuture;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author hrishikesh.mishra
 */
public class App {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<Integer> future = executorService.submit(() -> {
            Random random = new Random();
            System.out.println("Starting....");
            int duration = random.nextInt(4000);

            if (duration > 2000) {
                throw new IOException("Sleeping too long duration: " + duration);
            }

            Thread.sleep(duration);
            System.out.println("Finished.");
            return duration;
        });

        executorService.shutdown();
        Integer result = future.get();
        System.out.println("Result is : " + result);

        executorService.awaitTermination(1, TimeUnit.DAYS);

    }
}
