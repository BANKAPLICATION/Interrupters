package com.company;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main starts");
        InterruptedThread thread = new InterruptedThread();
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
        thread.join();
        System.out.println("main ends");
    }
}
class InterruptedThread extends Thread {
    double sqrtSum = 0;
    public void run() {
        for (int i = 0; i < 100000000; i++) {
            if(isInterrupted()) {
                System.out.println("Somebody wants to break a thread");
                System.out.println("We specified that the state of all thread are normal so decided to end of work the thread");
                return;
            }
            sqrtSum += Math.sqrt(i);
        }
        System.out.println(sqrtSum);
    }
}