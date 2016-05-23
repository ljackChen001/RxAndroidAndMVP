package com.cbl.rxandroidandmvp.base;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.cbl.rxandroidandmvp.component.RetrofitSingleton;
import com.github.moduth.blockcanary.BlockCanary;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by BaoLin Chen on 2016/5/3.
 * e-mail 505951628@qq.com
 */
public class BaseApplication extends Application {

    public static String cacheDir = "";
    public static Context mAppContext;


    @Override
    public void onCreate() {
        super.onCreate();
        mAppContext = this;
//        SpUtil.init(this);
        // 初始化 retrofit
        RetrofitSingleton.init(getApplicationContext());
        BlockCanary.install(this, new AppBlockCanaryContext()).start();
        LeakCanary.install(this);

    }
    public static  Context getAppContext(){
        return  mAppContext;
    }
    public static Resources getAppResources(){
        return  mAppContext.getResources();
    }
}