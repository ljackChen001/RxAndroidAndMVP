package com.cbl.rxandroidandmvp.base;

import android.content.Context;
import android.os.Build;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.cbl.rxandroidandmvp.R;
import com.cbl.rxandroidandmvp.base.mvp.BasePresenter;
import com.cbl.rxandroidandmvp.util.SnackBarUtils;
import com.cbl.rxandroidandmvp.util.StatusBarUtil;
import com.cbl.rxandroidandmvp.view.SwipeBackLayout;
import com.readystatesoftware.systembartint.SystemBarTintManager;

/**
 * Created by BaoLin Chen on 2016/5/3.
 * e-mail 505951628@qq.com
 */
public abstract class BaseActivity<T extends BasePresenter, E extends BaseModel> extends AppCompatActivity {
    private static String TAG = BaseActivity.class.getSimpleName();
    private SystemBarTintManager tintManager;
    public boolean isNight;
    public T mPresenter;
    public E mModel;
    public Context mContext;
    private SwipeBackLayout swipeBackLayout;
    private ImageView ivShadow;
    //    public ACache aCache;
    //    public Setting mSetting = null;

    protected void setStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
        }
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        setStatusBar();
    }


    public void showSnackbar(View view, String s) {
        SnackBarUtils.makeLong(view,s);
    }

    public void showSnackbar(View view, String s, boolean ture) {
        SnackBarUtils.makeShort(view,s);
    }

    public <T extends View> T findView(@IdRes int ResId) {
        return (T) findViewById(ResId);
    }
}
