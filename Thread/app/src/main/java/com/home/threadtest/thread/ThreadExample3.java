package com.home.threadtest.thread;

import android.util.Log;

public class ThreadExample3 extends Thread {
    private static final String TAG = ThreadExample3.class.getSimpleName();
    private String message;
    public ThreadExample3(String message) {
        this.message = message;
    }
    public void run() {
        Log.v(TAG, "Thread message is:" + this.message);
    }
}
