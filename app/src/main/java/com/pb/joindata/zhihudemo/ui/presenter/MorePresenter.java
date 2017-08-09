package com.pb.joindata.zhihudemo.ui.presenter;

import android.content.Context;
import android.util.Log;

import com.pb.joindata.zhihudemo.bean.more.DailyTimeLine;
import com.pb.joindata.zhihudemo.ui.view.IBasePresenter;
import com.pb.joindata.zhihudemo.ui.modle.MoreModle;
import com.pb.joindata.zhihudemo.ui.view.FragmentContract;
import com.pb.joindata.zhihudemo.ui.view.OnHttpCallBack;

/**
 * Created by wangjiachi on 2017/8/9.
 */

public class MorePresenter implements IBasePresenter {
    private Context mContext;
    private FragmentContract.MoreFragmentModel moreFragmentModel;
    public String num="0";

    public MorePresenter(Context context) {
        this.mContext = context;
        moreFragmentModel = new MoreModle();
    }

    @Override
    public void getData() {
        moreFragmentModel.getMore(num, new OnHttpCallBack<DailyTimeLine>() {
            @Override
            public void onSuccessful(DailyTimeLine dailyTimeLine) {
                Log.e("DailyTimeLine", dailyTimeLine.toString());
            }

            @Override
            public void onFaild(String errorMsg) {
                Log.d("DailyTimeLine", errorMsg);
            }
        });
    }

    @Override
    public void getMoreData() {

    }
}
