package com.example.myapplication;

import android.util.Log;

public class TestBean {
    private String name ="yjh";
    private final static String TAG = "DEBUGSS";

    private TestBean(String name) {
        this.name = name;
    }
    private void SystemoutName(){
        Log.e(TAG, "SystemoutName: "+name );
    }
}
