package com.fudaojun.frame_dbflow.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.fudaojun.frame_dbflow.R;
import com.fudaojun.frame_dbflow.entity.User;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import utils.LibUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User u = new User();
        u.setName("fudaojun");
        u.save();

        //查询
        User user = SQLite.select().from(User.class).querySingle();
        LibUtils.myLog(user.getName());

    }
}
