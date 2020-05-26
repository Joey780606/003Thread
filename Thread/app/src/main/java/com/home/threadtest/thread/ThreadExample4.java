package com.home.threadtest.thread;

import android.util.Log;

public class ThreadExample4 implements Runnable {
    private static final String TAG = ThreadExample4.class.getSimpleName();
    private String message;

    public ThreadExample4(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        Log.v(TAG, "Thread message is:" + this.message);
    }
}
