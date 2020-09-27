package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(4);
        CountDownLatch countDownLatch = new CountDownLatch(100+1);
        for (int i = 1; i < 101; i++) {
            new PassengerThread(countDownLatch, semaphore, i).start();
        }
        try {
            while (countDownLatch.getCount() > 1) {
                Thread.sleep(100);
            }
            Thread.sleep(1000);
            System.out.println("Автобус заполнен и готов к отъезду!");
            countDownLatch.countDown();
        } catch (InterruptedException ie) {
        }
    }
}

