package com.cbl.rxandroidandmvp.base.mvp;

/**
 * Created by BaoLin Chen on 2016/5/3.
 * e-mail 505951628@qq.com
 */
public interface BaseView<T> {
    public android.content.Context getContext();
    /**
     * 规定View必须要实现setPresenter方法，则View中保持对Presenter的引用。
     * 使用fragment作为view时，将activity中的presenter传递给fragment
     * @param presenter
     */
    void setPresenter(T presenter);

    /**
     * 发生错误
     * @param e e
     */
    void onFailure(Throwable e);
}
