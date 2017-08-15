package com.hrishikeshmishra.jm.customlock;

/**
 * Custom Lock
 *
 * Note: This lock will not re-entrant case
 *
 * @author hrishikesh.mishra
 */
public class CustomLock {

    private boolean isLocked = false;

    /**
     * Lock
     */
    public synchronized void lock() {

        /** Check is already locked or not **/
        while (isLocked) {

            try {
                /** If already locked then wait for unlock. **/

                wait();
            } catch (InterruptedException e) {

                /** Need to handle this case properly **/
                System.out.println("Got Interrupted Exception  : " + e);
            }

        }

        /** Now lock it, so other thread wouldn't process shared code. **/
        isLocked = true;

    }

    /**
     * Unlock
     */
    public synchronized void unlock() {

        /** Need to handle such case when, some thread calls unlock without calling lock first **/
        /** And only locked thread can call unlock, otherwise it will mess **/
        /** Unlock it **/
        isLocked = false;

        /** Notify waiting thread to process further **/
        notifyAll();

    }
}
