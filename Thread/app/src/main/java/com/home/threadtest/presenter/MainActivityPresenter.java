package com.home.threadtest.presenter;

import android.content.Context;

import com.home.threadtest.contract.MainActivityContract;

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
}
