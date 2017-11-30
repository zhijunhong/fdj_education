package com.fudaojun.app.android.hd.frame_rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.fudaojun.fudaojunlib.utils.LibUtils;

import rx.Observable;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {
    String[] mNames = new String[]{"hello", "world", "nihao", "niyehao"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Observable.from
        Observable.from(mNames).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                LibUtils.myLog("name:" + s + "\n");
            }
        });
    }
}
