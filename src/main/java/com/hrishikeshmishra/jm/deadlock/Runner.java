package com.hrishikeshmishra.jm.deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hrishikesh.mishra
 */
public class Runner {

    private Account account1 = new Account();
    private Account account2 = new Account();
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();


    /**
     * Method to acquire two lock irrelevant of orders
     *
     * @param fistLock
     * @param secondLock
     */
    private void acquireLocks(Lock fistLock, Lock secondLock) throws InterruptedException {

        while (true) {
            boolean gotFirstLock = false;
            boolean gotSecondLock = false;

            try {
                /** Try to acquire locks **/
                gotFirstLock = fistLock.tryLock();
                gotSecondLock = secondLock.tryLock();
            } finally {

                /** Got both locks **/
                if (gotFirstLock && gotSecondLock) {
                    return;
                }

                /** In case got one or zero lock then, release acquired lock **/

                if (gotFirstLock) {
                    fistLock.unlock();
                }

                if (gotSecondLock) {
                    secondLock.unlock();
                }
            }

            /** Sleep for a while and try again **/
            Thread.sleep(1);
        }
    }


    public void firstThread() throws InterruptedException {
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
//            lock1.lock();
//            lock2.lock();

            acquireLocks(lock1, lock2);

            try {
                Account.transfer(account1, account2, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void secondThread() throws InterruptedException {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {

            /** Change the order to see deadlock **/
            /**
             * Like this.
             *
             * lock2.lock();
             * lock1.lock();

             */
//            lock1.lock();
//            lock2.lock();

            acquireLocks(lock2, lock1);

            try {
                Account.transfer(account2, account1, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void finished() {
        System.out.println("Account 1 balance: " + account1.getBalance());
        System.out.println("Account 2 balance: " + account2.getBalance());
        System.out.println("Total Balance : " + (account1.getBalance() + account2.getBalance()));
    }

}
