package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * 处理切点
 */
@Aspect
public class SectionAspect {
    /**
     * 找到处理的切点
     * 代表 * *(..) 可以处理所有的方法
     */
    @Pointcut("execution(@com.example.myapplication.CheckNet * *(..))")
    public void checkNetBehavior() {

    }

    /**
     * 处理切面
     */
    @Around("checkNetBehavior()")
    public Object checkNet(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Log.e("CUT", "checkNet: 进入切面");
//        1.获取CheckNet注解
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();//拿方法的签名
        CheckNet checkNet = signature.getMethod().getAnnotation(CheckNet.class);
        if (checkNet != null) {
            Object obj = proceedingJoinPoint.getThis();//有可能是View anctivity fragment
            //1.判断有没有网络
            Context context = getContext(obj);
            if (context != null) {
                if (isNetworkAvailable(context)) {
                    Toast.makeText(context, "no network", Toast.LENGTH_SHORT).show();
                    return null;
                }
                //2.没有网络不要往下执行
            }
        }
//        2.判断有没有网络

//        3.没有网络就不要往下执行

        return proceedingJoinPoint.proceed();
    }

    private Context getContext(Object obj) {
        if (obj instanceof Activity) {
            return (Activity) obj;
        } else if (obj instanceof Fragment) {
            Fragment fragment = (Fragment) obj;
            return fragment.getActivity();
        } else if (obj instanceof View) {
            View view = (View) obj;
            return view.getContext();
        }
        return null;
    }


    /**
     * 检查当前网络是否可用
     *
     * @return
     */
    private static boolean isNetworkAvailable(Context context) {
        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            // 获取NetworkInfo对象
            NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();

            if (networkInfo != null && networkInfo.length > 0) {
                for (int i = 0; i < networkInfo.length; i++) {
                    // 判断当前网络状态是否为连接状态
                    if (networkInfo[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
