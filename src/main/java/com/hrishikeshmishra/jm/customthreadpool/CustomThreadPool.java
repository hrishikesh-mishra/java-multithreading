package com.hrishikeshmishra.jm.customthreadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author hrishikesh.mishra
 */
public class CustomThreadPool {

    private final BlockingQueue<Runnable> queue;
    private final List<WorkerThread> workers;
    private boolean isStopped;


    public CustomThreadPool(int numberOfThreads, int maxNumberOfThreads) {
        queue = new ArrayBlockingQueue<>(maxNumberOfThreads);
        workers = new ArrayList<>();
        createWorkerThreads(numberOfThreads);
    }

    private void createWorkerThreads(int numberOfThreads) {
        for (int i = 0; i < numberOfThreads; i++) {
            workers.add(new WorkerThread(queue));
        }

        for (WorkerThread workerThread : workers) {
            workerThread.start();
        }
    }

    public synchronized void execute(Runnable task)  {
        if (isStopped) {
            throw new IllegalStateException("Threadpool is stopped.");
        }

        try {
            queue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void stop() {
        isStopped = true;
        for (WorkerThread workerThread : workers) {
            workerThread.stopThread();
        }
    }
}
