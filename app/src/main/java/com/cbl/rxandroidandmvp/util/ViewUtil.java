package com.cbl.rxandroidandmvp.util;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.view.View;

/**
 * Created by BaoLin Chen on 2016/5/23.
 * e-mail 505951628@qq.com
 */
public final class ViewUtil {
    public static <T extends View> T findViewById(Activity activity, @IdRes int resId){
        return (T) activity.findViewById(resId);
    }
    public static <T extends View> T findViewById(View view, @IdRes int resId){
        return (T) view.findViewById(resId);
    }
}
