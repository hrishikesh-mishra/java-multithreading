package com.hrishikeshmishra.jm.threadpool;

/**
 * @author hrishikesh.mishra
 */
public class Processor implements Runnable {
    private int id;

    public Processor(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.printf("Starting(%d) .... \n", id);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.printf("Completed(%d) .... \n", id);
    }
}
