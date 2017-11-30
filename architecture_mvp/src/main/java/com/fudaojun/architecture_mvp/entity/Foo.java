package com.fudaojun.architecture_mvp.entity;

/**
 * Created by ZhijunHong on 2017/11/30.
 */

public class Foo {
    public Foo() {
    }

    public Foo(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    private String version;
}
