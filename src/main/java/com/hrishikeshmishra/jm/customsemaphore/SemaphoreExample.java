package com.hrishikeshmishra.jm.customsemaphore;

import java.util.Random;

/**
 * @author hrishikesh.mishra
 */
public class SemaphoreExample implements Runnable {

    private CustomSemaphore semaphore;

    public SemaphoreExample(CustomSemaphore semaphore) {
        this.semaphore = semaphore;
    }


    @Override
    public void run() {
        Random random = new Random();
        while (true) {

            try {
                semaphore.acquire();
                System.out.printf("Thread: %s, got the lock. \n" , Thread.currentThread().getName());

                Thread.sleep(random.nextInt(2000));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.printf("Thread: %s, releasing lock. \n" , Thread.currentThread().getName());
            semaphore.release();
        }
    }
}
