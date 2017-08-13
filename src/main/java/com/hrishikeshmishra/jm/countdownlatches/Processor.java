package com.hrishikeshmishra.jm.countdownlatches;

import java.util.concurrent.CountDownLatch;

/**
 * @author hrishikesh.mishra
 */
public class Processor implements Runnable {

    private CountDownLatch latch;

    public Processor(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Started ... ");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        latch.countDown();
    }
}
