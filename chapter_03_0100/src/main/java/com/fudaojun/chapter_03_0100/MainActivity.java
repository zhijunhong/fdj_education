package com.fudaojun.chapter_03_0100;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn_reveal_intent, R.id.btn_recluse_intent, R.id.btn_transform_data_next, R.id.btn_transform_data_preview,R.id.tv_webview})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_reveal_intent:  //显示意图
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_recluse_intent://隐士意图
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.addCategory("com.fudaojun.MY_CATEGORY");
                startActivity(intent2);
                break;
            case R.id.btn_transform_data_next://向下一个活动传递数据
                break;
            case R.id.btn_transform_data_preview://返回数据给上一个活动
                break;
            case R.id.tv_webview:  //打开连接-Intent传递参数
                Uri uri = Uri.parse("http://www.baidu.com");
                Intent intent3 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent3);
                break;
        }
    }
}
