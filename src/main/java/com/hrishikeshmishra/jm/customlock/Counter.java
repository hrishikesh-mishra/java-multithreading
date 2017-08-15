package com.hrishikeshmishra.jm.customlock;

/**
 * @author hrishikesh.mishra
 */
public class Counter {

    private final CustomLock lock = new CustomLock();
    private int count;

    public Counter(int initialValue) {
        this.count = initialValue;
    }

    public int increaseAndGetCount() {
        System.out.printf("Thread: %s - trying to get lock.\n", Thread.currentThread().getName());

        lock.lock();

        System.out.printf("Thread: %s - got lock.\n", Thread.currentThread().getName());
        System.out.printf("Thread: %s - incrementing count.\n", Thread.currentThread().getName());

        int tempCount = ++count;

        System.out.printf("Thread: %s - incremented count: %d .\n", Thread.currentThread().getName(), tempCount);
        System.out.printf("Thread: %s - trying to unlock.\n", Thread.currentThread().getName());

        lock.unlock();

        return tempCount;
    }

    public int decrementAndGetCount() {

        System.out.printf("Thread: %s - trying to get lock.\n", Thread.currentThread().getName());

        lock.lock();

        System.out.printf("Thread: %s - got lock.\n", Thread.currentThread().getName());
        System.out.printf("Thread: %s - decrementing count.\n", Thread.currentThread().getName());

        int tempCount = --count;

        System.out.printf("Thread: %s - decremented count : %d .\n", Thread.currentThread().getName(), tempCount);
        System.out.printf("Thread: %s - trying to unlock.\n", Thread.currentThread().getName());

        lock.unlock();

        return tempCount;
    }


}
