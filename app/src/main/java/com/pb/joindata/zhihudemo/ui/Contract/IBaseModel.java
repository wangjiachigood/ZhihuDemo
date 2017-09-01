package com.pb.joindata.zhihudemo.ui.Contract;

import com.pb.joindata.zhihudemo.bean.gank.Meizhi;
import com.pb.joindata.zhihudemo.bean.more.DailyTimeLine;
import com.pb.joindata.zhihudemo.bean.zhihu.NewsTimeLine;

/**
 * Created by wangjiachi on 2017/8/31.
 */

public interface IBaseModel {

    interface FragmentModel {
        void getMovie(OnHttpCallBack<NewsTimeLine> callBack);//获取知乎信息

    }

    interface GankFragmentModel {
        void getGank(int page, OnHttpCallBack<Meizhi> callBack);//获取干货消息
    }

    interface MoreFragmentModel {
        void getMore(String num, OnHttpCallBack<DailyTimeLine> callBack);//获取更多信息
    }
}
