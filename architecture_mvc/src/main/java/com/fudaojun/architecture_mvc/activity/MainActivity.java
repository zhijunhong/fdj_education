package com.fudaojun.architecture_mvc.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.fudaojun.architecture_mvc.R;
import com.fudaojun.architecture_mvc.entity.Foo;
import com.fudaojun.architecture_mvc.model.FooModel;

/**
 * android mvc架构demo
 * 场景：模拟从网络获取数据和数据库获取数据做比较
 * 如果结果一样，显示：已经是最新数据
 * 如果不一样，显示：更新数据
 */
public class MainActivity extends AppCompatActivity {
    private FooModel mFooModel;
    private Foo mNewestFooData;
    private Foo mFooDataFromDB;
    private TextView mTvVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvVersion = (TextView) findViewById(R.id.tv_version);

        mFooModel = new FooModel(this);  //model层

        //1.获取网络数据
        //2.获取本地数据库数据
        //3.比对结果
        //4.显示结果

        //获取最新网络数据
        mNewestFooData = mFooModel.getNewestFooData();
        //从数据库获取数据
        mFooDataFromDB = mFooModel.getFooDataFromDB();
        //比较结果
        compareFooData(mNewestFooData, mFooDataFromDB);

    }

    /**
     * 比较数据结果
     *
     * @param newestFooData
     * @param fooDataFromDB
     */
    private void compareFooData(Foo newestFooData, Foo fooDataFromDB) {
        //显示结果
        showFooDataResult(mFooDataFromDB.equals(fooDataFromDB));
    }

    /**
     * 显示结果
     *
     * @param equals
     */
    private void showFooDataResult(boolean equals) {
        if (equals) {
            mTvVersion.setText("已经是最新数据");
        } else {
            mTvVersion.setText("不是最新数据");
        }
    }
}
