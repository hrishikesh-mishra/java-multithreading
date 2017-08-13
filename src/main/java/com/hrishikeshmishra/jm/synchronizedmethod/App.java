package com.hrishikeshmishra.jm.synchronizedmethod;

/**
 * @author hrishikesh.mishra
 */
public class App {


    private int count;

    private synchronized void incrementCounter() {
        count++;

    }

    public static void main(String[] args) throws InterruptedException {

        App app = new App();
        app.doWork();

    }

    public void doWork() throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                incrementCounter();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                incrementCounter();
            }
        });

        t1.start();
        t2.start();


        t1.join();
        t2.join();

        System.out.printf("Count = %d \n", count);
    }
}
