package com.hrishikeshmishra.jm.customsemaphore;

/**
 * @author hrishikesh.mishra
 */
public class App {

    public static void main(String[] args) {

        CustomSemaphore semaphore = new CustomSemaphore(3);

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new SemaphoreExample(semaphore), "Thread-"+i);
            t.start();
        }

    }
}
