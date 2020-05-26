package com.home.threadtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.home.threadtest.contract.MainActivityContract;
import com.home.threadtest.presenter.MainActivityPresenter;

import java.util.concurrent.CopyOnWriteArrayList;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {
    private static final String TAG = MainActivity.class.getSimpleName();
    private MainActivityContract.Presenter presenter;

    private ListView mlog_ListView;
    private Spinner mSpinnerContent;
    private TextView mtvExplain;
    private Button mbtnExecute;

    private ClickListener mClickListener;
    private String mSelectSpinnerString = "";

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
        mtvExplain = (TextView) findViewById(R.id.tvExplain);
        mbtnExecute = (Button) findViewById(R.id.btnExecute);

        mClickListener = new ClickListener();
        mbtnExecute.setOnClickListener(mClickListener);

        mSpinnerContent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(mSpinnerContent.getSelectedItem() != null) {
                    mSelectSpinnerString = mSpinnerContent.getSelectedItem().toString();

                    //Log.v(TAG, "Receive command:" + selectString);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    public void setSpinnerInfo(CopyOnWriteArrayList<String> spinnerInfo) {
        CopyOnWriteArrayList<String> SpinnerInfo = spinnerInfo;
        ArrayAdapter<String> spinnerAdapter;
        spinnerAdapter = new ArrayAdapter<String>(this, R.layout.spinner_dropdown_item, SpinnerInfo);
        mSpinnerContent.setAdapter(spinnerAdapter);
    }

    private class ClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (v == mbtnExecute) {
                presenter.execSample(mSelectSpinnerString);
            }

        }
    }




}
