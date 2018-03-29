package service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.fudaojun.fdj_education.R;

import utils.LibUtils;

/**
 * Created by ZhijunHong on 2017/11/25.
 */

public class ServiceActivirty extends AppCompatActivity implements View.OnClickListener {
    Button btnStartDemoService,btnStopDemoService,btnBindDemoService,btnUnbindDemoService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        init();
    }

    private void init(){
        btnStartDemoService=(Button)findViewById(R.id.btn_start_demoservice);
        btnStopDemoService=(Button)findViewById(R.id.btn_stop_demoservice);
        btnBindDemoService=(Button)findViewById(R.id.btn_bind_demoservice);
        btnUnbindDemoService=(Button)findViewById(R.id.btn_unbind_demoservice);

        btnStartDemoService.setOnClickListener(this);
        btnStopDemoService.setOnClickListener(this);
        btnBindDemoService.setOnClickListener(this);
        btnUnbindDemoService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        intent.setClass(this,DemoService.class);
        switch(v.getId()){
            case R.id.btn_start_demoservice:
                startService(intent);
                break;
            case R.id.btn_stop_demoservice:
                stopService(intent);
                break;
            case R.id.btn_bind_demoservice:
                bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE);
                break;
            case R.id.btn_unbind_demoservice:
                unbindService(serviceConnection);
                break;
        }
    }
    DemoService demoservice;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            demoservice = ((DemoService.LocalBinder) service).getService();

            LibUtils.myLog("service！~~");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            demoservice = null;
        }
    };
}
