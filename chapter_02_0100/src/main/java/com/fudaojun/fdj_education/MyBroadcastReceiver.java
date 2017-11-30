package com.fudaojun.fdj_education;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import utils.LibUtils;

/**
 * Created by luffy on 2016/7/29.
 */
public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        LibUtils.showToast(context, "这是个普通的广播,我是动态注册的");
        LibUtils.myLog("receiver", "normal");
    }
}