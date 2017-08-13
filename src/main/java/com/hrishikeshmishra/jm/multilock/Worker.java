package com.hrishikeshmishra.jm.multilock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author hrishikesh.mishra
 */
public class Worker {

    private Random random = new Random();

    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    /**
     * Lock objects
     **/
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();


    public void stageOne() {

        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            /** Is not thread safe **/
            list1.add(random.nextInt(100));
        }


    }

    public void stageTwo() {

        synchronized (lock2) {

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            /** Is not thread safe **/
            list2.add(random.nextInt(100));
        }

    }

    public void process() {
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    public void main() {
        System.out.println("Starting......");

        long start = System.currentTimeMillis();

        /** **/
        Thread t1 = new Thread(() -> {

            process();

        });

        Thread t2 = new Thread(() -> {

            process();

        });


        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        long end = System.currentTimeMillis();


        System.out.println("Time take : " + (end - start));
        System.out.printf("List-1: %d; List-    2: %d\n", list1.size(), list2.size());

    }
}
