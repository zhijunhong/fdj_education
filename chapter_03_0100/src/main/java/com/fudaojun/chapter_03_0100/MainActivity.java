package com.fudaojun.chapter_03_0100;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.fudaojun.chapter_03_0100.constants.Constants;

import java.io.File;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn_reveal_intent, R.id.btn_recluse_intent, R.id.btn_transform_data_next, R.id.btn_transform_data_preview, R.id.tv_webview})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_reveal_intent:  //显示意图
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_recluse_intent://隐士意图
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.addCategory("com.fudaojun.MY_CATEGORY");
                startActivity(intent2);
                break;
            case R.id.btn_transform_data_next://向下一个活动传递数据
                break;
            case R.id.btn_transform_data_preview://返回数据给上一个活动
                break;
            case R.id.tv_webview:  //打开连接-Intent传递参数
                Uri uri = Uri.parse("http://www.baidu.com");
                Intent intent3 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent3);
                break;
        }
    }

    /**
     * 分享文件到微信
     */
    private void shareFileToWexin(String filePath) {
        try {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(filePath)));
            intent.setType("text/plain");
            // 分享出去的内容
            intent.putExtra(Intent.EXTRA_TEXT, "分享内容" + this.getPackageName());
            // 分享出去的标题
            intent.putExtra(Intent.EXTRA_SUBJECT, "辅导君老师版");
            intent.setPackage(Constants.TencentConstant.WECHAT_PACKAGE_NANE);
            intent.setClassName(Constants.TencentConstant.WECHAT_PACKAGE_NANE, Constants.TencentConstant.WECHAT_CLASS_NANE);
            startActivity(intent);
        } catch (android.content.ActivityNotFoundException ex) {
            //没有安装微信提示
            Toast.makeText(this, R.string.install_weichat_client, Toast.LENGTH_SHORT).show();
        }

    }


    /**
     * 分享文件到QQ
     */
    private void shareFileToQQ(String filePath) {
        try {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(filePath)));
            intent.setType("text/plain");
            // 分享出去的内容
            intent.putExtra(Intent.EXTRA_TEXT, "分享内容" + this.getPackageName());
            // 分享出去的标题
            intent.putExtra(Intent.EXTRA_SUBJECT, "辅导君老师版");
            intent.setPackage(Constants.TencentConstant.QQ_PACKAGE_NANE);
            intent.setClassName(Constants.TencentConstant.QQ_PACKAGE_NANE, Constants.TencentConstant.QQ_CLASS_NANE);
            startActivity(intent);
        } catch (android.content.ActivityNotFoundException ex) {
            //没有安装QQ提示
            Toast.makeText(this, R.string.install_qq_client, Toast.LENGTH_SHORT).show();
        }
    }

}
