package com.hrishikeshmishra.jm.customreentrantlock;

/**
 * Custom Re-entrant Lock
 *
 * @author hrishikesh.mishra
 */
public class CustomReentrantLock {

    /**
     * To hold is locked or not
     **/
    private boolean isLocked;

    /**
     * Locked by which thread
     **/
    private Thread lockedBy;

    /**
     * Number of times lock called by same thread when that has already lock
     **/
    private int lockedCount;


    public synchronized void lock() throws InterruptedException {

        /**
         * Check is already locked by someone else
         */
        while (isLocked && lockedBy != Thread.currentThread()) {

            /**
             * If yes, then wait for unlock
             */
            wait();
        }

        /** Update respective lock variables **/
        isLocked = true;
        lockedBy = Thread.currentThread();
        lockedCount++;
    }

    public synchronized void unlock() {

        if (Thread.currentThread() == lockedBy) {
            /** Decrease the lock counter **/
            lockedCount--;

            /** When lock counter reaches to zero then remove lock **/
            if (lockedCount == 0) {
                isLocked = false;
                lockedBy = null;

                /** Notify other threads **/
                notifyAll();
            }
        }
    }
}
