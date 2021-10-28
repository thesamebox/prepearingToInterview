package ru.geekbrains.prepearingToInterview.lesson3;

public class PingPong {

    public static void main(String[] args) {
        Object monitor = new Object();
        Thread ping = new Thread(new Turn(monitor, "ping"));
        Thread pong = new Thread(new Turn(monitor, "PONG"));
        ping.start();
        pong.start();
    }
}
