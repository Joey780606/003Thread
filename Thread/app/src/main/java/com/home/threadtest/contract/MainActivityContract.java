package com.home.threadtest.contract;

import java.util.concurrent.CopyOnWriteArrayList;

public interface MainActivityContract {
    interface View {
        void initV();
        void setSpinnerInfo(CopyOnWriteArrayList<String> spinnerInfo);
    }

    interface Presenter {
        void init();
        void buildSpinnerInfo();
        void execSample(String cmd);
    }
}
