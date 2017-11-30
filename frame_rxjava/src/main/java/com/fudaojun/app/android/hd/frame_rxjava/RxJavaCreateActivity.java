package com.fudaojun.app.android.hd.frame_rxjava;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.fudaojun.fudaojunlib.utils.LibUtils;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ZhijunHong on 2017/11/9.
 */

public class RxJavaCreateActivity extends AppCompatActivity {
    int mDrawableRes = R.mipmap.ic_launcher_round;
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView) findViewById(R.id.iv_imageView);

        //Observable.create
        Observable.create(new Observable.OnSubscribe<Drawable>() {
            @Override
            public void call(Subscriber<? super Drawable> subscriber) {
                Drawable drawable = getResources().getDrawable(mDrawableRes);
                subscriber.onNext(drawable);
                subscriber.onCompleted();
            }
        })
                .subscribeOn(Schedulers.io()) //被观察者线程
                .observeOn(AndroidSchedulers.mainThread()) //观察者线程
                .subscribe(new Observer<Drawable>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LibUtils.showToast(RxJavaCreateActivity.this, "error:" + e.toString());
                    }

                    @Override
                    public void onNext(Drawable drawable) {
                        mImageView.setImageDrawable(drawable);
                    }
                });

    }


}
