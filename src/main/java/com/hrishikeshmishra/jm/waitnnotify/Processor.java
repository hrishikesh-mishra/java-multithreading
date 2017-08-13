package com.hrishikeshmishra.jm.waitnnotify;

import java.util.Scanner;

/**
 * @author hrishikesh.mishra
 */
public class Processor {

    public void produce() throws InterruptedException {

        synchronized (this){
            System.out.println("Producer thread running.");
            wait();
            System.out.println("Resumed..");
        }
    }

    public void consumer() throws InterruptedException {
        Scanner in = new Scanner(System.in);

        Thread.sleep(2000);

        synchronized (this){
            System.out.println("Waiting for return key..");
            in.nextLine();
            System.out.println("Return key pressed.");
            notify();
            Thread.sleep(5000);
        }
    }
}
