package com.home.threadtest.presenter;

import android.content.Context;
import android.util.Log;

import com.home.threadtest.R;
import com.home.threadtest.contract.MainActivityContract;

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
        } else if(cmd.equals(mContext.getString(R.string.fun_runnable_interface))) {
            Log.v(TAG, "fun_runnable_interface");
        }
//        switch(cmd) {
//            case sinherit_thread_class:
//                break;
//
//        }
    }
}
