package com.pb.joindata.zhihudemo.ui.presenter;

import android.util.Log;

import com.pb.joindata.zhihudemo.bean.zhihu.NewsTimeLine;
import com.pb.joindata.zhihudemo.ui.Contract.IBaseModel;
import com.pb.joindata.zhihudemo.ui.Contract.IBasePresenter;
import com.pb.joindata.zhihudemo.ui.Contract.IBaseView;
import com.pb.joindata.zhihudemo.ui.Contract.OnHttpCallBack;
import com.pb.joindata.zhihudemo.ui.modle.ZhihuModle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjiachi on 2017/8/8.
 */

public class ZhiHuFgPresenter implements IBasePresenter {
    private IBaseView mZhiHuView;
    private IBaseModel.FragmentModel mFragmentModel;
    private List<NewsTimeLine> mNewList=new ArrayList<>();//请求到的电影信息对象集合

    public ZhiHuFgPresenter(IBaseView mView) {
        this.mZhiHuView = mView;
        mFragmentModel = new ZhihuModle();
    }

    @Override
    public void getData() {
        mFragmentModel.getMovie(new OnHttpCallBack<NewsTimeLine>() {
            @Override
            public void onSuccessful(NewsTimeLine newsTimeLine) {
                mZhiHuView.refreshList(newsTimeLine);
                Log.e("------>", newsTimeLine.toString());
            }

            @Override
            public void onFaild(String errorMsg) {
                Log.e("------>","1111");
            }
        });
    }

    @Override
    public void getMoreData() {
        getData();
    }

}
