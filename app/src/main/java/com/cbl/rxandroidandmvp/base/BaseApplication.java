package com.cbl.rxandroidandmvp.base;

import android.app.Application;
import android.content.Context;

import com.cbl.rxandroidandmvp.component.RetrofitSingleton;
import com.github.moduth.blockcanary.BlockCanary;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by BaoLin Chen on 2016/5/3.
 * e-mail 505951628@qq.com
 */
public class BaseApplication extends Application {

    public static String cacheDir = "";
    public static Context mAppContext = null;


    @Override
    public void onCreate() {
        super.onCreate();
        mAppContext = getApplicationContext();
        // 初始化 retrofit
        RetrofitSingleton.init(getApplicationContext());
        //捕获程序崩溃信息
//        CrashHandler.init(new CrashHandler(getApplicationContext()));
//        CrashReport.initCrashReport(getApplicationContext(), "900028220", false);
        BlockCanary.install(this, new AppBlockCanaryContext()).start();
        LeakCanary.install(this);

//        Thread.setDefaultUncaughtExceptionHandler(new MyUnCaughtExceptionHandler());

        /**
         * 如果存在SD卡则将缓存写入SD卡,否则写入手机内存
         */

        if (getApplicationContext().getExternalCacheDir() != null && ExistSDCard()) {
            cacheDir = getApplicationContext().getExternalCacheDir().toString();

        } else {
            cacheDir = getApplicationContext().getCacheDir().toString();
        }
    }

    private boolean ExistSDCard() {
        return android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
    }
}