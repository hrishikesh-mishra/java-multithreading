package com.hrishikeshmishra.jm.interruptingthread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author hrishikesh.mishra
 */
public class App {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Starting..");

//        Thread t = new Thread(() -> {
//            Random random = new Random();
//
//            for (int  i =0 ;i < 1E8; i++){
////                try {
////                    Thread.sleep(1);
////
////                } catch (InterruptedException e) {
////                    System.out.println("We've been interrupted.");
////                    break;
////                }
//
//                if (Thread.currentThread().isInterrupted()){
//                    System.out.println("We've been interrupted.");
//                    break;
//                }
//                Math.sin(random.nextDouble());
//            }
//        });
//
//        t.start();
//
//        Thread.sleep(500);
//
//        t.interrupt();
//
//        t.join();

        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<Void> future = executorService.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                Random random = new Random();

                for (int i = 0; i < 1E8; i++) {

                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("We've been interrupted.");
                        break;
                    }
                    Math.sin(random.nextDouble());
                }

                return null;
            }
        });

        executorService.shutdown();

        Thread.sleep(500);
//        future.cancel(false);
//        future.cancel(true);

//        executorService.shutdownNow();

        executorService.awaitTermination(1 , TimeUnit.DAYS);

        System.out.println("Finished..");

    }
}
