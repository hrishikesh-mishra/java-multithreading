package com.hrishikeshmishra.jm.customthreadpool;

import java.util.concurrent.BlockingQueue;

/**
 * @author hrishikesh.mishra
 */
public class WorkerThread extends Thread {

    private final BlockingQueue<Runnable> queue;
    private boolean isStopped;

    public WorkerThread(BlockingQueue<Runnable> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!isStopped) {
            try {
                Runnable task = queue.take();
                task.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopThread() {
        isStopped = true;
    }
}
