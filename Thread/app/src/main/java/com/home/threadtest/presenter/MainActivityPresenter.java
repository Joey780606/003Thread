package com.home.threadtest.presenter;

import android.content.Context;
import android.util.Log;

import com.home.threadtest.R;
import com.home.threadtest.contract.MainActivityContract;
import com.home.threadtest.thread.ThreadExample3;

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
        view.setSpinnerInfo(spinnerInfo);
    }

    @Override
    public void execSample(String cmd) {
        if (cmd.equals(mContext.getString(R.string.fun_inherit_thread_class))) {
            Log.v(TAG, "fun_inherit_thread_class");
            ThreadDemo3();
        } else if(cmd.equals(mContext.getString(R.string.fun_runnable_interface))) {
            Log.v(TAG, "fun_runnable_interface");
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
}
