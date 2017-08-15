package com.hrishikeshmishra.jm.customreentrantlock;

/**
 * Re-entrant  Example
 *
 * @author hrishikesh.mishra
 */
public class ReentrantExample {

    private CustomReentrantLock lock = new CustomReentrantLock();

    public void enter() throws InterruptedException {
        System.out.printf("Thread: %s, trying to lock inside enter method.\n", Thread.currentThread().getName());
        lock.lock();

        Thread.sleep(100);

        System.out.printf("Thread: %s, got the  lock inside enter method.\n", Thread.currentThread().getName());
        reEnter();

        System.out.printf("Thread: %s, calling unlock inside enter method.\n", Thread.currentThread().getName());
        lock.unlock();
    }

    private void reEnter() throws InterruptedException {
        System.out.printf("Thread: %s, trying to lock inside reEnter method.\n", Thread.currentThread().getName());
        lock.lock();
        System.out.printf("Thread: %s, got the  lock inside reEnter method.\n", Thread.currentThread().getName());
        System.out.printf("Thread: %s, calling unlock inside reEnter method.\n", Thread.currentThread().getName());
        lock.unlock();
    }
}
