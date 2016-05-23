package com.cbl.rxandroidandmvp.base;

import android.support.annotation.IdRes;
import android.view.View;

import com.cbl.rxandroidandmvp.util.ViewUtil;

/**
 * Created by BaoLin Chen on 2016/5/23.
 * e-mail 505951628@qq.com
 */
public abstract class BaseActivity extends AppActivity{
    public  <T extends View> T $(@IdRes int resId){
        return ViewUtil.findViewById(this,resId);
    }
}
