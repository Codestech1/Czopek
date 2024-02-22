package com.github.codestech.czopek;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;

public final class Worker implements Runnable {

    private static final ReentrantLock lock = new ReentrantLock();

    private static final int MAX_GRADE = 2;
    private static final int MIN_GRADE = 1;

    private static volatile boolean enabled;

    public static void startWork() {
        enabled = true;
        new Thread(new Worker(), "Worker").start();
    }

    public static void stopWork() {
        lock.lock();
        try {
            System.out.println("Shutting down the work...");
            enabled = false;
            System.out.println("Successfully shut down the work!");
        } finally {
            lock.unlock();
        }
    }

    private Worker() {}

    @Override
    public void run() {
        while (enabled) {
            if (lock.isLocked())
                continue;
            Random random = ThreadLocalRandom.current();
            System.out.println("Next grade is: "  + random.nextInt(MIN_GRADE, MAX_GRADE + 1)); // Bound is always exclusive
        }
    }
}