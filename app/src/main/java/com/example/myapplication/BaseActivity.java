package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;


/**
 * 活动基类
 * 属于代码架构
 */
public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    protected abstract void initView();
    protected abstract void  initData();
}
