package com.pb.joindata.zhihudemo.ui.Contract;

import com.pb.joindata.zhihudemo.bean.zhihu.NewsTimeLine;

/**
 * Created by wangjiachi on 2017/8/31.
 */

public interface IBaseView {
    void refreshList(NewsTimeLine mList);

    void hideSwipe();//隐藏刷新

}
