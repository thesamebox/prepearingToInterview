package ru.geekbrains.prepearingToInterview.lesson3;

import java.util.concurrent.locks.ReentrantLock;

public class Counter implements Runnable {
    private int counter;

    ReentrantLock lock = new ReentrantLock(true);
    public void increaseCounter() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " - " + counter);
            counter++;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        while (counter < 10) {
            increaseCounter();
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread thread1 = new Thread(counter);
        Thread thread2 = new Thread(counter);
        thread1.start();
        thread2.start();
    }
}
