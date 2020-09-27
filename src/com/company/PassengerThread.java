package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class PassengerThread extends Thread {
    private CountDownLatch countDownLatch;
    private Semaphore semaphore;
    private int passengerNum;

    public PassengerThread(CountDownLatch countDownLatch, Semaphore semaphore, int passengerNum) {
        this.countDownLatch = countDownLatch;
        this.semaphore = semaphore;
        this.passengerNum = passengerNum;
    }


    public synchronized void run() {
        try {
            semaphore.acquire();
            countDownLatch.countDown();
            System.out.println("Пассажир " + passengerNum + " купил билет");
            sleep(2000);
            System.out.println("Пассажир " + passengerNum + " сел в автобус");
            semaphore.release();
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}



