package com.fudaojun.architecture_mvp.activity;

/**
 * Created by ZhijunHong on 2017/11/30.
 */

public interface MainContract {
    interface View {
        //结果相同
        void showFooDataEqual();

        //结果不同
        void showFooDataUnEqual();
    }

    interface Presenter {
        //提供给view调用
        void compareFooData();
    }

    interface Model {
        //和presenter交互
        boolean compareFooData();
    }

}
