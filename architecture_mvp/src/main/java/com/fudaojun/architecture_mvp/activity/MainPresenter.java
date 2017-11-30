package com.fudaojun.architecture_mvp.activity;

/**
 * Created by ZhijunHong on 2017/11/30.
 */

public class MainPresenter implements MainContract.Presenter {
    private MainContract.Model mModel;
    private MainContract.View mView;

    public MainPresenter(MainContract.View view) {
        mModel = new MainModel();
        mView = view;
    }

    @Override
    public void compareFooData() {
        if (mModel.compareFooData()) {  //结果相同
            mView.showFooDataEqual();
        } else {  //结果不同
            mView.showFooDataUnEqual();
        }
    }
}
