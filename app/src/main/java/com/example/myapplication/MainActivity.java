package com.example.myapplication;


import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 加入这时候我的mainactivitu继承自BaseSkinActivity
 */
public class MainActivity extends BaseSkinActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //反射创建对象
        try {
            Constructor constructor = TestBean.class.getDeclaredConstructor(String.class);
            constructor.setAccessible(true);
            TestBean testBean = (TestBean) constructor.newInstance("小目标");
            Method method = TestBean.class.getDeclaredMethod("SystemoutName");
            method.setAccessible(true);
            method.invoke(testBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        方法调用
        try {
            AssetManager assetManager = AssetManager.class.newInstance();
            Method method = AssetManager.class.getDeclaredMethod("addAssetPath",String.class);
            method.setAccessible(true);
            method.invoke(assetManager,"sdcard/dds/red.skin");
        } catch (Exception e) {
            Log.d("DEBUGSS", "onCreate: "+e);
            e.printStackTrace();
        }
//        获取属性
        try {
            Constructor constructor = TestBean.class.getDeclaredConstructor(String.class);
            constructor.setAccessible(true);
            TestBean testBean = (TestBean) constructor.newInstance("小目标111");
            Field name1 = TestBean.class.getDeclaredField("name");
            name1.setAccessible(true);
            String name = (String) name1.get(testBean);
            Log.e("DEBUGSS", "onCreate: "+name);
        } catch (Exception e) {
            e.printStackTrace();
        }


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