package com.cbl.rxandroidandmvp.base;

import java.io.Serializable;
import java.util.Map;

import rx.Observable;

/**
 * Created by BaoLin Chen on 2016/5/23.
 * e-mail 505951628@qq.com
 */
public interface BaseEntity {
    class BaseBean implements Serializable {
        public long id;
        public String objectId;
        public Map<String, String> param;
    }

    interface IListBean {
        Observable getPageAt(int page);

        void setParam(Map<String, String> param);
    }

    abstract class ListBean extends BaseBean implements IListBean {
        @Override
        public void setParam(Map<String, String> param) {
            this.param=param;
        }
    }
}
