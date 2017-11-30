package com.fudaojun.architecture_mvp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.fudaojun.architecture_mvp.R;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    //presenter
    private MainContract.Presenter mMainPresenter;
    private TextView mTvVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvVersion = (TextView) findViewById(R.id.tv_version);

        //注入presenter
        mMainPresenter = new MainPresenter(this);
        //比较数据不同
        mMainPresenter.compareFooData();
    }

    /**
     * 数据形同
     */
    @Override
    public void showFooDataEqual() {
        mTvVersion.setText("已经是最新数据");
    }

    /**
     * 数据不同
     */
    @Override
    public void showFooDataUnEqual() {
        mTvVersion.setText("不是最新数据");
    }
}
