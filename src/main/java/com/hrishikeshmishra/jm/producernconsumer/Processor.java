package com.hrishikeshmishra.jm.producernconsumer;

import java.util.LinkedList;
import java.util.Random;

/**
 * @author hrishikesh.mishra
 */
public class Processor {

    private LinkedList<Integer> queue = new LinkedList<>();
    private final int LIMIT = 10;
    private Object lock = new Object();

    public void produce() throws InterruptedException {
        int value = 0 ;

        while (true){

            synchronized (lock) {
                /** Wait till queue is full **/
                while (queue.size() == LIMIT) {
                    lock.wait();
                }

                queue.add(value++);

                lock.notifyAll();
            }
        }
    }

    public void consumer() throws InterruptedException {

        Random random = new Random();

        while (true){
            synchronized (lock) {

                /** When queue is empty  **/
                while (queue.isEmpty()){
                    lock.wait();
                }
                System.out.println("Queue : " + queue);
                int value = queue.removeFirst();
                System.out.println("; value is: " + value);

                lock.notifyAll();
            }
            Thread.sleep(random.nextInt(1000));
        }
    }



}
