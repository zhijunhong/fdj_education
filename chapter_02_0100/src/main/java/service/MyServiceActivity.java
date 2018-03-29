package service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.fudaojun.fdj_education.R;

import utils.LibUtils;

/**
 * Created by ZhijunHong on 2017/12/13.
 */

public class MyServiceActivity extends AppCompatActivity implements View.OnClickListener {
    private MyService.MyBinder mMyBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myservice);
        //初始化view
        initView();
    }

    /**
     * 初始化view
     */
    private void initView() {
        findViewById(R.id.btn_start_myservice).setOnClickListener(this);
        findViewById(R.id.btn_stop_myservice).setOnClickListener(this);

        findViewById(R.id.btn_bind_myservice).setOnClickListener(this);
        findViewById(R.id.btn_unbind_myservice).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_myservice:
                //启动服务
                Intent startIntent = new Intent(this, MyService.class);
                startService(startIntent);
                break;
            case R.id.btn_stop_myservice:
                //关闭服务
                Intent stopIntent = new Intent(this, MyService.class);
                stopService(stopIntent);
                break;

            case R.id.btn_bind_myservice:
                //绑定服务
                Intent bindIntent = new Intent(this, MyService.class);
                bindService(bindIntent, mConnetion, BIND_AUTO_CREATE);
                break;
            case R.id.btn_unbind_myservice:
                //解绑服务
                unbindService(mConnetion);
                break;
        }
    }

    private ServiceConnection mConnetion = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            LibUtils.myLog("链接成功");

            mMyBinder = (MyService.MyBinder) service;
            mMyBinder.startPushService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
}
