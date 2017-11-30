package com.fudaojun.fdj_education;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import utils.LibUtils;

public class BrocastReceiverActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.btn_normal_br)
    Button btnNormalBr;
    @BindView(R.id.btn_ordered_br)
    Button btnOrderedBr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brocast_receiver);
        ButterKnife.bind(this);

        MyBroadcastReceiver oReceiver = new MyBroadcastReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.app.bc.test");
        this.registerReceiver(oReceiver, filter);
        init();
    }

    public void init() {
        btnNormalBr.setOnClickListener(this);
        btnOrderedBr.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_normal_br:
                Intent intent2 = new Intent("com.app.nbc.test");
                sendOrderedBroadcast(intent2, null);
                break;
            case R.id.btn_ordered_br:
                Intent intent = new Intent("com.app.bc.test");
                LibUtils.myLog("receiver", "start");
                sendBroadcast(intent);
                break;
        }
    }
}