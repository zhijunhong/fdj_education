package com.fudaojun.chapter_03_0100.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.fudaojun.chapter_03_0100.R;
import com.fudaojun.chapter_03_0100.constants.Constants;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ZhijunHong on 2017/11/25.
 */

public class FifthActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_back_main)
    public void onViewClicked() {
        Intent intent = new Intent();
        intent.putExtra(Constants.GOBACK_MAIN,"I com from FifthActivity");
        setResult(RESULT_OK,intent);
        finish();

    }
}
