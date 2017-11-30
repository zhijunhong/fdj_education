package com.fudaojun.frame_dbflow;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by ZhijunHong on 2017/11/30.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化dbflow
        FlowManager.init(new FlowConfig.Builder(this).build());
    }
}
