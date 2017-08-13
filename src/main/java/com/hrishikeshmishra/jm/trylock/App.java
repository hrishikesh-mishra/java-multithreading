package com.hrishikeshmishra.jm.trylock;

/**
 * @author hrishikesh.mishra
 */
public class App {

    public static void main(String[] args) throws InterruptedException {

        final Runner runner = new Runner();

        Thread t1 = new Thread(() -> {
            try {
                runner.firstThread();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                runner.secondThread();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        t1.start();
        t2.start();

        t1.join();
        System.out.println("T1 finished.");
        t2.join();
        System.out.println("T2 finished.");

        runner.finished();
        System.out.println("Runner finished. ");

    }
}
