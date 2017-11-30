package com.fudaojun.chapter_04_0100.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.fudaojun.chapter_04_0100.R;
import com.fudaojun.chapter_04_0100.constants.Constants;
import com.fudaojun.chapter_04_0100.eventbus.MessageEvent;
import com.fudaojun.chapter_04_0100.utils.SPUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import utils.LibUtils;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btn_text)
    Button mBtnText;
    @BindView(R.id.iv_icon)
    ImageView mIvIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //测试SpUtils存储和获取
        unitTestSpUtils();
    }

    /**
     * 测试SpUtils存储和获取
     */
    private void unitTestSpUtils() {
        //存储数据
        SPUtils.setString(Constants.SP_KEY, "fudaojun");
        //取出数据
        LibUtils.myLog(SPUtils.getString(Constants.SP_KEY, ""));
    }

    @OnClick(R.id.btn_text)
    public void onViewClicked() {
        LibUtils.showToast(this, "点击了按钮-改变按钮的值");
        mBtnText.setText("你好，世界！");

        //发送eventbus事件
        EventBus.getDefault().post(new MessageEvent());
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        mIvIcon.setVisibility(View.VISIBLE);
    }
}
