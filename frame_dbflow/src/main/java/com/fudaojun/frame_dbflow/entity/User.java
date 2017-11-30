package com.fudaojun.frame_dbflow.entity;

import com.fudaojun.frame_dbflow.dbflow.AppDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = AppDatabase.class)
public class User extends BaseModel {
    @Column
    @PrimaryKey
    int id;

    @Column
    String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}