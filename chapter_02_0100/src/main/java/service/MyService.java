package service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import utils.LibUtils;

/**
 * Created by ZhijunHong on 2017/12/13.
 */

public class MyService extends Service {
    private MyBinder mMyBinder = new MyBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mMyBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LibUtils.myLog("onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LibUtils.myLog("onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LibUtils.myLog("onDestroy()");
    }

    class MyBinder extends Binder {
        public void startPushService() {
            //开启推送服务
            LibUtils.myLog("开启推送服务");
        }
    }
}
