package com.hrishikeshmishra.jm.demo1;

/**
 * Through Thread Class
 * @author hrishikesh.mishra
 */
public class App {

    public static void main(String[] args) {
        Runner runner1 = new Runner();
        runner1.start();

        Runner runner2 = new Runner();
        runner2.start();

        System.out.println("Main Exit.");



    }
}
