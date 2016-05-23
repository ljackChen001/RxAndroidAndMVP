package com.cbl.rxandroidandmvp;

import android.widget.Button;

import com.cbl.rxandroidandmvp.base.BaseActivity;

/**
 * Created by BaoLin Chen on 2016/5/6.
 * e-mail 505951628@qq.com
 */
public class hello extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_about;
    }

    @Override
    public void initView() {
      Button b=$(R.id.btn);
    }

    @Override
    public void initPresenter() {

    }
}


