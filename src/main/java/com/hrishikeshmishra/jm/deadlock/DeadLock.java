package com.hrishikeshmishra.jm.deadlock;

/**
 *
 * Thread.sleep unlikely doesn't release lock as wait does.
 *
 * @author hrishikesh.mishra
 * @link https://stackoverflow.com/questions/10663920/calling-thread-sleep-from-synchronized-context-in-java/10663939#10663939
 */
public class DeadLock {

    public static void main(String[] args) throws InterruptedException {

        Object resource1 = new Object();
        Object resource2 = new Object();


        Thread thread1  = new Thread(() -> {
            synchronized (resource1){
                System.out.println("Thread 1: Got resource 1.");
                System.out.println("Thread 1: Trying to resource 2.");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (resource2){
                    System.out.println("Thread 1: Got resource 2.");
                }
            }

        });


        Thread thread2 = new Thread(() -> {

            synchronized (resource2){
                System.out.println("Thread 2: Got resource 2.");
                System.out.println("Thread 2: Trying to get resource 1.");


                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (resource1){
                    System.out.println("Thread 2: Got resource 1.");
                }
            }
        });


        thread1.start();
        thread2.start();


        thread1.join();
        thread2.join();
    }
}
