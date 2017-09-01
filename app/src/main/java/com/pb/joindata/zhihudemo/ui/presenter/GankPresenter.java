package com.pb.joindata.zhihudemo.ui.presenter;

import android.content.Context;
import android.util.Log;

import com.pb.joindata.zhihudemo.bean.gank.Meizhi;
import com.pb.joindata.zhihudemo.ui.Contract.IbaseModel;
import com.pb.joindata.zhihudemo.ui.modle.GankModle;
import com.pb.joindata.zhihudemo.ui.Contract.IBasePresenter;
import com.pb.joindata.zhihudemo.ui.view.OnHttpCallBack;

/**
 * Created by wangjiachi on 2017/8/8.
 */

public class GankPresenter implements IBasePresenter {
    private Context mContext;
    private IbaseModel.GankFragmentModel mGankModel;
    private int page=1;

    public GankPresenter(Context mContext) {
        this.mContext = mContext;
        mGankModel=new GankModle();
    }

    @Override
    public void getData() {
        mGankModel.getGank(page,new OnHttpCallBack<Meizhi>() {
            @Override
            public void onSuccessful(Meizhi meizhi) {
                Log.e("--------->", meizhi.toString());
            }

            @Override
            public void onFaild(String errorMsg) {
                Log.e("--------->",errorMsg);
            }
        });
    }

    @Override
    public void getMoreData() {

    }
}
