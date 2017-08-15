package com.hrishikeshmishra.jm.customlock;

/**
 * @author hrishikesh.mishra
 */
public class App {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(9);

        Thread incrementCounterThread = new Thread(() -> {
            counter.increaseAndGetCount();
        });

        Thread decrementCounterThread = new Thread(() -> {

            counter.decrementAndGetCount();
        });


        incrementCounterThread.setName("Increment-Counter");
        decrementCounterThread.setName("Decrement-Counter");

        incrementCounterThread.start();
        decrementCounterThread.start();

        incrementCounterThread.join();
        decrementCounterThread.join();

    }
}
