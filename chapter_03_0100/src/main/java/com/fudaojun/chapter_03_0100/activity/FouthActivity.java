package com.fudaojun.chapter_03_0100.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.fudaojun.chapter_03_0100.R;
import com.fudaojun.chapter_03_0100.constants.Constants;
import com.fudaojun.chapter_03_0100.entity.User;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ZhijunHong on 2017/11/25.
 */

public class FouthActivity extends AppCompatActivity {
    @BindView(R.id.tv_text)
    TextView mTvText;
    @BindView(R.id.tv_text_object)
    TextView mTvTextObject;

    private User mUser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fouth);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String extra = intent.getStringExtra(Constants.TRANSFORM);
        Bundle bundle = intent.getBundleExtra(Constants.BUNDLE);

        if (intent != null) {
            mTvText.setText("我是第四个页面：" + extra);
        }

        if (bundle != null && bundle.containsKey(Constants.TRANSFORM_OBJECT)) {
            mUser = bundle.getParcelable(Constants.TRANSFORM_OBJECT);
        }

        initView();
    }

    /**
     * 初始化界面
     */
    private void initView() {
        mTvTextObject.setText("username: " + mUser.getUsername() + " ,pwd: " + mUser.getPwd());
    }
}
