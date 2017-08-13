package com.hrishikeshmishra.jm.semaphores;

import java.util.concurrent.Semaphore;

/**
 * @author hrishikesh.mishra
 */
public class Connection {

    private Semaphore semaphore = new Semaphore(10);

    private static Connection instance = new Connection();
    private int connections  = 0;

    private Connection() {

    }

    public static Connection getInstance() {
        return instance;
    }

    public void connect() throws InterruptedException {

        try{
            semaphore.acquire();

            doConnect();

        }finally {
            semaphore.release();
        }
    }
    public void doConnect() throws InterruptedException {

        synchronized (this){
            connections++;
            System.out.printf("Current connections : %d \n" ,  connections);
        }

        Thread.sleep(2000);

        synchronized (this){
            connections--;
        }

    }
}
