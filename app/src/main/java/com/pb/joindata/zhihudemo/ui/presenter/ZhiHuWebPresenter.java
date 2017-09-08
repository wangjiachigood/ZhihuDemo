package com.pb.joindata.zhihudemo.ui.presenter;

import android.util.Log;

import com.pb.joindata.zhihudemo.bean.zhihu.News;
import com.pb.joindata.zhihudemo.ui.Contract.IBaseModel;
import com.pb.joindata.zhihudemo.ui.Contract.IBasePresenter;
import com.pb.joindata.zhihudemo.ui.Contract.IBaseView;
import com.pb.joindata.zhihudemo.ui.Contract.OnHttpCallBack;
import com.pb.joindata.zhihudemo.ui.modle.ZhihuModle;

/**
 * Created by wangjiachi on 2017/9/7.
 */

public class ZhiHuWebPresenter implements IBasePresenter {
    private IBaseModel.FragmentModel mFragmentModel;
    private IBaseView.ZhiHuWebView mZhiHuWebView;
    private String id;

    public ZhiHuWebPresenter(IBaseView.ZhiHuWebView zhihuwebview, String newsId) {
        this.mZhiHuWebView = zhihuwebview;
        mFragmentModel = new ZhihuModle();
        this.id = newsId;
    }

    @Override
    public void getData() {
        mFragmentModel.getNewsDetail(id, new OnHttpCallBack<News>() {
            @Override
            public void onSuccessful(News news) {
                mZhiHuWebView.skipDetail(news);
                Log.d("news", news.toString());
            }

            @Override
            public void onFaild(String errorMsg) {
                Log.d("news", errorMsg);
            }
        });
    }

    @Override
    public void getMoreData() {

    }
}
