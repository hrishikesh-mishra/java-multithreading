package com.hrishikeshmishra.jm.volatilevariable;

/**
 * @author hrishikesh.mishra
 */
public class Processor extends Thread {

    /**
     * Volatile prevent variable caching for a thread
     * It means that variable will always store in main memory rather than CPU cache.
     *  More precisely that means, that every read of a volatile variable will be read
     *  from the computer's main memory, and not from the CPU cache, and that every write
     *  to a volatile variable will be written to main memory, and not just to the CPU cache.
     *
     */
    private volatile boolean running = true;

    @Override
    public void run() {
        while (running){
            System.out.println("Hello ");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown(){
        running = false;
    }
}
