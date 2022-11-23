package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 加入这时候我的mainactivitu继承自BaseSkinActivity
 */
public class MainActivity extends BaseSkinActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @CheckNet
    public void click(View view){
        Toast.makeText(this, "hhhhhh", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void changeSkin() {

    }
}