package com.hrishikeshmishra.jm.waitnnotify;

/**
 * @author hrishikesh.mishra
 */
public class App {

    public static void main(String[] args) throws InterruptedException {
        final Processor producer = new Processor();

        Thread t1 = new Thread(() -> {

            try {
                producer.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread t2 = new Thread(() -> {

            try {
                producer.consumer();
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
