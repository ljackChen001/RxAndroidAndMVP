package com.cbl.rxandroidandmvp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.cbl.rxandroidandmvp.R;
import com.cbl.rxandroidandmvp.base.mvp.BasePresenter;
import com.cbl.rxandroidandmvp.util.SnackBarUtils;
import com.cbl.rxandroidandmvp.util.TUtil;
import com.cbl.rxandroidandmvp.view.SwipeBackLayout;
import com.readystatesoftware.systembartint.SystemBarTintManager;

/**
 * Created by BaoLin Chen on 2016/5/3.
 * e-mail 505951628@qq.com
 */
public abstract class AppActivity<T extends BasePresenter, E extends BaseModel> extends AppCompatActivity {
    private static String TAG = AppActivity.class.getSimpleName();
    private SystemBarTintManager tintManager;
    public boolean isNight;
    public T mPresenter;
    public E mModel;
    public Context mContext;
    private SwipeBackLayout swipeBackLayout;
    private ImageView ivShadow;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        isNight = SpUtil.isNight();
//        setTheme(isNight ? R.style.AppThemeNight : R.style.AppThemeDay);
        this.setContentView(this.getLayoutId());
        mContext=this;
        mPresenter= TUtil.getT(this,0);
        mModel=TUtil.getT(this,1);
        this.initView();
        this.initPresenter();
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        if (layoutResID == R.layout.activity_main || layoutResID == R.layout.activity_about)
            super.setContentView(layoutResID);
    }


    public void showSnackbar(View view, String s) {
        SnackBarUtils.makeLong(view, s);
    }

    public void showSnackbar(View view, String s, boolean ture) {
        SnackBarUtils.makeShort(view, s);
    }


    public abstract int getLayoutId();

    public abstract void initView();

    /**
     * 简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
     */
    public abstract void initPresenter();

}
