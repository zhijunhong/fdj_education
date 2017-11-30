package com.fudaojun.app.android.hd.frame_rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.fudaojun.fudaojunlib.utils.LibUtils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by ZhijunHong on 2017/11/9.
 */

public class RxJavaJustActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Observable just
        Observable.just(1, 2, 3, 4, 5).subscribeOn(Schedulers.io())//指定 subscribe() 所发生的线程，即 Observable.OnSubscribe 被激活时所处的线程。或者叫做事件产生的线程
                .observeOn(AndroidSchedulers.mainThread())//指定 Subscriber 所运行在的线程。或者叫做事件消费的线程
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        LibUtils.myLog("integer:" + integer + "\n");
                    }
                });
    }


}
