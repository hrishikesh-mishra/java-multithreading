package com.hrishikeshmishra.jm.customsemaphore;

/**
 * Custom Semaphore Implementation
 *
 * @author hrishikesh.mishra
 */
public class CustomSemaphore {

    private int numberOfResources;

    public CustomSemaphore() {
        this(1);
    }

    public CustomSemaphore(int numberOfResources) {
        /** Number of resources must not be less than one **/
        this.numberOfResources = (numberOfResources < 1) ? 1 : numberOfResources;
    }

    public synchronized void acquire() throws InterruptedException {

        /** In case no resource available **/
        while (numberOfResources == 0) {
            /** Then wait for someone to release resource **/
            wait();
        }

        /** Decrement resource counter **/
        numberOfResources--;
    }

    public synchronized void release() {
        numberOfResources++;

        /** Notify all waiting thread for resource availability **/
        notifyAll();
    }
}
