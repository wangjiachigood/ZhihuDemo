package com.pb.joindata.zhihudemo.ui.view;

/**
 * Created by wangjiachi on 2017/8/8.
 */

public interface IBasePresenter {
    /**
     * 获取网络数据，更新界面
     */
    void getData();

    /**
     * 加载更多数据
     */
    void getMoreData();
}
