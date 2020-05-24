package com.home.threadtest.presenter;

import android.content.Context;

import com.home.threadtest.contract.MainActivityContract;

import java.util.concurrent.CopyOnWriteArrayList;

public class MainActivityPresenter implements MainActivityContract.Presenter {
    private MainActivityContract.View view;
    private Context mContext;

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
        spinnerInfo.add("3. Inherit thread class");
        spinnerInfo.add("4. Runnable interface");
        view.setSpinnerInfo(spinnerInfo);
    }
}
