package com.cbl.rxandroidandmvp.base.mvp;

/**
 * Created by BaoLin Chen on 2016/5/3.
 * e-mail 505951628@qq.com
 */
public interface BasePresenter {
    /**
     * 规定Presenter必须要实现start方法。
     * 页面初始化的时候做的事情，根据业务决定是否需要
     */
    void start();

    void stop();
}
