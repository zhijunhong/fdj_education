package com.fudaojun.architecture_mvc.model;

import android.content.Context;

import com.fudaojun.architecture_mvc.entity.Foo;

/**
 * Created by ZhijunHong on 2017/11/30.
 */

public class FooModel {
    private Context mContext;

    public FooModel(Context context) {
        this.mContext = context;
    }

    /**
     * 获取最新的foo数据
     *
     * @return
     */
    public Foo getNewestFooData() {
        return new Foo("1.0.1");
    }

    /**
     * 冲数据库获取foo数据
     *
     * @return
     */
    public Foo getFooDataFromDB() {
        return new Foo("1.0.0");
    }
}
