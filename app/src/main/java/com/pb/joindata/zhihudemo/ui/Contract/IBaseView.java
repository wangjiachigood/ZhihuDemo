package com.pb.joindata.zhihudemo.ui.Contract;

import com.pb.joindata.zhihudemo.bean.zhihu.NewsTimeLine;

/**
 * Created by wangjiachi on 2017/8/31.
 */

public interface IBaseView {
    interface ZhihuView{
        void refreshList(NewsTimeLine mList);
        void loadMoreList(NewsTimeLine mList);
    }

}
