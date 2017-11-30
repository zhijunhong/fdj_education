package com.fudaojun.app.android.hd.frame_rxjava;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * RxJava转换：String->Bitmap
 */
public class ChangeActivity extends AppCompatActivity {
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);

        mImageView = (ImageView) findViewById(R.id.iv_imageView);

        Observable.just("iamges/logo.png").map(new Func1<String, Bitmap>() {
            @Override
            public Bitmap call(String filePath) {
                //从文件中加载bitmap
                return getBitmapFromPath(filePath);
            }
        }).subscribe(new Action1<Bitmap>() {
            @Override
            public void call(Bitmap bitmap) {
                //显示bitmap
                showBitmap(bitmap);
            }
        });

    }

    /**
     * 显示bitmap
     *
     * @param bitmap
     */
    private void showBitmap(Bitmap bitmap) {
        mImageView.setImageBitmap(bitmap);
    }

    /**
     * 从文件中加载bitmap
     *
     * @param filePath
     */
    private Bitmap getBitmapFromPath(String filePath) {
        return BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
    }
}
