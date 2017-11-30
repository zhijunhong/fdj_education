package com.fudaojun.chapter_04_0100.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fudaojun.chapter_04_0100.R;
import com.fudaojun.chapter_04_0100.constants.Constants;
import com.fudaojun.chapter_04_0100.utils.SPUtils;

import utils.LibUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}
