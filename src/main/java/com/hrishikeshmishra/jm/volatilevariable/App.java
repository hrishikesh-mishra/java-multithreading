package com.hrishikeshmishra.jm.volatilevariable;

import java.util.Scanner;

/**
 * Example:
 * Stopping a thread from another thread using shared variable.
 *
 * @author hrishikesh.mishra
 */
public class App {

    public static void main(String[] args) {
        Processor proc1 = new Processor();
        proc1.start();

        System.out.println("Press return to stop.");
        Scanner in = new Scanner(System.in);
        in.nextLine();

        proc1.shutdown();
    }
}
