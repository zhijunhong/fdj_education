package com.fudaojun.architecture_mvp.activity;

import com.fudaojun.architecture_mvp.entity.Foo;

/**
 * Created by ZhijunHong on 2017/11/30.
 */

public class MainModel implements MainContract.Model {
    @Override
    public boolean compareFooData() {
        return getNewestFooData().equals(getFooDataFromDB());
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
