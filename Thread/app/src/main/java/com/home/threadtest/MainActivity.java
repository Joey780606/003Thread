package com.home.threadtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.home.threadtest.contract.MainActivityContract;
import com.home.threadtest.presenter.MainActivityPresenter;

import java.util.concurrent.CopyOnWriteArrayList;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {
    private static final String TAG = MainActivity.class.getSimpleName();
    private MainActivityContract.Presenter presenter;

    private ListView mlog_ListView;
    private Spinner mSpinnerContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainActivityPresenter(this, this);
        presenter.init();
        presenter.buildSpinnerInfo();
    }

    @Override
    public void initV() {
        mlog_ListView = (ListView) findViewById(R.id.log_ListView);
        mSpinnerContent = (Spinner) findViewById(R.id.spinnerContent);
    }

    @Override
    public void setSpinnerInfo(CopyOnWriteArrayList<String> spinnerInfo) {
        CopyOnWriteArrayList<String> SpinnerInfo = spinnerInfo;
        ArrayAdapter<String> spinnerAdapter;
        spinnerAdapter = new ArrayAdapter<String>(this, R.layout.spinner_dropdown_item, SpinnerInfo);
        mSpinnerContent.setAdapter(spinnerAdapter);
    }
}
