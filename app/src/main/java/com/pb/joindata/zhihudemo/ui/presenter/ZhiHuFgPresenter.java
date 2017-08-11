package com.pb.joindata.zhihudemo.ui.presenter;

import android.util.Log;

import com.pb.joindata.zhihudemo.bean.zhihu.NewsTimeLine;
import com.pb.joindata.zhihudemo.ui.modle.ZhihuModle;
import com.pb.joindata.zhihudemo.ui.view.FragmentContract;
import com.pb.joindata.zhihudemo.ui.view.IBasePresenter;
import com.pb.joindata.zhihudemo.ui.view.OnHttpCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjiachi on 2017/8/8.
 */

public class ZhiHuFgPresenter implements IBasePresenter {
    private FragmentContract.FragmentView mFragmentView;
    private FragmentContract.FragmentModel mFragmentModel;
    private boolean isFirst = true;
    private List<NewsTimeLine> mNews = new ArrayList<>();//请求到的电影信息对象集合

    public ZhiHuFgPresenter(FragmentContract.FragmentView mView) {
        this.mFragmentView = mView;
        mFragmentModel = new ZhihuModle();
    }

    @Override
    public void getData() {
        if (isFirst) {
            mFragmentView.showProgress();
            isFirst = !isFirst;
        } else {
            mFragmentView.hideProgress();
        }
        mFragmentModel.getMovie(new OnHttpCallBack<NewsTimeLine>() {
            @Override
            public void onSuccessful(NewsTimeLine newsTimeLine) {
                mNews.add(newsTimeLine);
                mFragmentView.showData(mNews);
                mFragmentView.hideSwipe();
                mFragmentView.hideProgress();
                Log.e("------>", newsTimeLine.toString());
            }

            @Override
            public void onFaild(String errorMsg) {
            }
        });
    }

    @Override
    public void getMoreData() {
        getData();
    }

}
