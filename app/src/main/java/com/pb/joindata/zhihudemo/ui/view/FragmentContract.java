package com.pb.joindata.zhihudemo.ui.view;

import com.pb.joindata.zhihudemo.bean.gank.Meizhi;
import com.pb.joindata.zhihudemo.bean.more.DailyTimeLine;
import com.pb.joindata.zhihudemo.bean.zhihu.NewsTimeLine;

import java.util.List;

/**
 * Created by wangjiachi on 2017/8/7.
 */

public interface FragmentContract {
    interface FragmentView {
        void showProgress();//显示进度条

        void hideProgress();//隐藏进度条

        void hideSwipe();//隐藏刷新

        void showData(List<NewsTimeLine> mNews);//显示数据到View上
    }

    interface FragmentPresenter {
        void getMovie();//获取数据

        void loadMoreMovie();//加载更多
    }

    interface FragmentModel {
        void getMovie(OnHttpCallBack<NewsTimeLine> callBack);//获取知乎信息

    }

    interface GankFragmentModel {
        void getGank(int page,OnHttpCallBack<Meizhi> callBack);//获取干货消息
    }
    interface  MoreFragmentModel{
        void getMore(String num, OnHttpCallBack<DailyTimeLine> callBack);//获取更多信息
    }
}
