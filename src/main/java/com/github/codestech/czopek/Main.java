package com.github.codestech.czopek;

public class Main {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(Worker::stopWork));

        new Thread(() -> {
            System.out.println("-------------------------------");
            System.out.println("STARTING THE WORK IN 5 SECONDS!");
            System.out.println("-------------------------------");
            System.out.println("YOU USE THIS APP AT YOUR OWN RISK");
            System.out.println("DON'T ASK FOR SUPPORT, YOU WON'T GET ANY");
            System.out.println("-------------------------------");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.exit(0);
                return;
            }

            Worker.startWork();
        }, "Preparation").start();
    }
}