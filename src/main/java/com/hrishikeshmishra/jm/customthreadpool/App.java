package com.hrishikeshmishra.jm.customthreadpool;

import java.util.Random;

/**
 * @author hrishikesh.mishra
 */
public class App {

    public static void main(String[] args) {
        CustomThreadPool customThreadPool = new CustomThreadPool(2, 2);

        for (int i=0 ; i < 4; i ++){
            final int index = i;
            customThreadPool.execute(() -> {
                Random random = new Random();
                System.out.printf("Running Task %d .... \n", index);
                try {
                    Thread.sleep(random.nextInt(2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.printf("Finished Task %d.\n", index);
            });

        }
    }
}
