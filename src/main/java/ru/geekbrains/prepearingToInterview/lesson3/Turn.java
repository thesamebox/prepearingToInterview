package ru.geekbrains.prepearingToInterview.lesson3;

public class Turn implements Runnable{
    private Object monitor;
    private String turn;

    public Turn(Object monitor, String turn) {
        this.monitor = monitor;
        this.turn = turn;
    }

    @Override
    public void run() {
        synchronized (monitor) {
            for (int i = 0; i < 5; i++) {
                System.out.println(turn);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                monitor.notify();
                try {
                    monitor.wait(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
