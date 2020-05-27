package com.home.threadtest.presenter;

import android.content.Context;
import android.util.Log;

import com.home.threadtest.R;
import com.home.threadtest.contract.MainActivityContract;
import com.home.threadtest.thread.ThreadExample3;
import com.home.threadtest.thread.ThreadExample4;
import com.home.threadtest.thread.ThreadExmple5Sum1;
import com.home.threadtest.thread.ThreadExmple5Sum2;

import java.util.concurrent.CopyOnWriteArrayList;

public class MainActivityPresenter implements MainActivityContract.Presenter {
    private static final String TAG = MainActivityPresenter.class.getSimpleName();

    private MainActivityContract.View view;
    private static Context mContext;

    public MainActivityPresenter(MainActivityContract.View view, Context context) {
        this.view = view;
        this.mContext = context;
    }

    @Override
    public void init() {
        view.initV();
    }

    @Override
    public void buildSpinnerInfo() {
        CopyOnWriteArrayList<String> spinnerInfo = new CopyOnWriteArrayList<String>();
        //spinnerInfo.add("3. Inherit thread class");
        spinnerInfo.add(mContext.getString(R.string.fun_inherit_thread_class));
        spinnerInfo.add(mContext.getString(R.string.fun_runnable_interface));
        spinnerInfo.add(mContext.getString(R.string.fun_wait_notify));
        view.setSpinnerInfo(spinnerInfo);
    }

    @Override
    public void execSample(String cmd) {
        if (cmd.equals(mContext.getString(R.string.fun_inherit_thread_class))) {
            Log.v(TAG, "fun_inherit_thread_class");
            ThreadDemo3();
        } else if(cmd.equals(mContext.getString(R.string.fun_runnable_interface))) {
            Log.v(TAG, "fun_runnable_interface");
            ThreadDemo4();
        } else if(cmd.equals(mContext.getString(R.string.fun_wait_notify))) {
            ThreadDemo5();
        }
//        switch(cmd) {
//            case sinherit_thread_class:
//                break;
//
//        }
    }

    private void ThreadDemo3() {
        ThreadExample3 thread1 = new ThreadExample3("message1");
        ThreadExample3 thread2 = new ThreadExample3("message2");
        ThreadExample3 thread3 = new ThreadExample3("message3");
        ThreadExample3 thread4 = new ThreadExample3("message4");
        ThreadExample3 thread5 = new ThreadExample3("message5");
        ThreadExample3 thread6 = new ThreadExample3("message6");
        ThreadExample3 thread7 = new ThreadExample3("message7");
        ThreadExample3 thread8 = new ThreadExample3("message8");
        ThreadExample3 thread9 = new ThreadExample3("message9");
        ThreadExample3 thread10 = new ThreadExample3("message10");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();
    }

    private void ThreadDemo4() {
        Thread thread1 = new Thread(new ThreadExample4("message1"));
        Thread thread2 = new Thread(new ThreadExample4("message2"));
        Thread thread3 = new Thread(new ThreadExample4("message3"));
        Thread thread4 = new Thread(new ThreadExample4("message4"));
        Thread thread5 = new Thread(new ThreadExample4("message5"));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }

    private void ThreadDemo5() {
        int result;

        ThreadExmple5Sum1 sum1 = new ThreadExmple5Sum1();
        Thread thread1 = new Thread(sum1);
        thread1.start();
        result = sum1.sum;
        Log.v(TAG, "Thread demo5 value1:" + result);

        ThreadExmple5Sum2 sum2 = new ThreadExmple5Sum2();
        Thread thread2 = new Thread(sum2);
        thread2.start();
        synchronized (thread2) {
            try {
                thread2.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Log.v(TAG, "Thread demo5 value2 error:" + e.toString());
            }
        }
        result = sum2.sum;
        Log.v(TAG, "Thread demo5 value2:" + result);
    }

}
