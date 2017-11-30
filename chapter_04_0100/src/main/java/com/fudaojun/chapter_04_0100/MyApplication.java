package com.fudaojun.chapter_04_0100;

import android.app.Application;

import com.fudaojun.chapter_04_0100.utils.SPUtils;

/**
 * Created by ZhijunHong on 2017/11/30.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化
        SPUtils.init(this);
    }
}
