package com.home.threadtest.thread;

public class ThreadExmple5Sum2 implements Runnable {
    public int sum = 0;
    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i <= 100; i++) {
                sum += i;
            }
            notify();
        }
    }
}
