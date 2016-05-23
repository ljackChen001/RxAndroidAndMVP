package com.cbl.rxandroidandmvp.base;

import android.content.Context;

/**
 * Created by BaoLin Chen on 2016/5/23.
 * e-mail 505951628@qq.com
 */
public abstract class BasePresenter<E,T> {
    public Context context;
    public E mModel;
    public T mView;
    public RxManage mRxManage = new RxManage();

    public void setVM(T v, E m) {
        this.mView = v;
        this.mModel = m;
        this.onStart();
    }

    public abstract void onStart();

    public void onDestroy() {
        mRxManage.clear();
    }
}
