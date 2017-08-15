package com.hrishikeshmishra.jm.customreentrantlock;

/**
 * Custom Re-entrant Lock  Implementation Example
 *
 * @author hrishikesh.mishra
 */
public class App {

    public static void main(String[] args) throws InterruptedException {
        ReentrantExample reentrantExample = new ReentrantExample();

        Thread t1 = new Thread(() -> {
            try {
                reentrantExample.enter();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                reentrantExample.enter();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
