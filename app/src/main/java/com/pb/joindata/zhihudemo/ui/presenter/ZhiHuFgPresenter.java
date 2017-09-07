package com.pb.joindata.zhihudemo.ui.presenter;

import android.util.Log;

import com.pb.joindata.zhihudemo.bean.zhihu.NewsTimeLine;
import com.pb.joindata.zhihudemo.ui.Contract.IBaseModel;
import com.pb.joindata.zhihudemo.ui.Contract.IBasePresenter;
import com.pb.joindata.zhihudemo.ui.Contract.IBaseView;
import com.pb.joindata.zhihudemo.ui.Contract.OnHttpCallBack;
import com.pb.joindata.zhihudemo.ui.modle.ZhihuModle;

/**
 * Created by wangjiachi on 2017/8/8.
 */

public class ZhiHuFgPresenter implements IBasePresenter {
    private IBaseView.ZhihuView mZhiHuView;
    private IBaseModel.FragmentModel mFragmentModel;
    private String time;

    public ZhiHuFgPresenter(IBaseView.ZhihuView mView) {
        this.mZhiHuView = mView;
        mFragmentModel = new ZhihuModle();
    }



    @Override
    public void getData() {
        mFragmentModel.getMovie(new OnHttpCallBack<NewsTimeLine>() {
            @Override
            public void onSuccessful(NewsTimeLine newsTimeLine) {
                time = newsTimeLine.getDate();
                mZhiHuView.refreshList(newsTimeLine);
                Log.e("------>", newsTimeLine.toString());
            }

            @Override
            public void onFaild(String errorMsg) {
                Log.e("------>", "1111");
            }
        });
    }

    @Override
    public void getMoreData() {
        mFragmentModel.loadMoreNews(time, new OnHttpCallBack<NewsTimeLine>() {
            @Override
            public void onSuccessful(NewsTimeLine newsTimeLine) {
                mZhiHuView.loadMoreList(newsTimeLine);
                Log.d("newsTimeLine",newsTimeLine.toString());
            }

            @Override
            public void onFaild(String errorMsg) {
                Log.d("newsTimeLine",errorMsg);
            }
        });
    }

}
