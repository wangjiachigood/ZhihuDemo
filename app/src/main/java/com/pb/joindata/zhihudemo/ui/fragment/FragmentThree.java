package com.pb.joindata.zhihudemo.ui.fragment;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.pb.joindata.zhihudemo.R;
import com.pb.joindata.zhihudemo.base.BaseFragment;
import com.pb.joindata.zhihudemo.ui.view.IBasePresenter;
import com.pb.joindata.zhihudemo.ui.presenter.MorePresenter;

/**
 * Created by wangjiachi on 2017/8/7.
 */

public class FragmentThree extends BaseFragment {
    private RecyclerView mRecycleview;
    private MorePresenter mMorepresenter;


    @Override
    protected IBasePresenter InitPresenter() {
        return new MorePresenter(getContext());
    }

    @Override
    public void initView(View rootview) {
        mMorepresenter=new MorePresenter(getContext());
        mMorepresenter.getData();
        mRecycleview= (RecyclerView) rootview.findViewById(R.id.rc_more);
        mRecycleview.setLayoutManager(new LinearLayoutManager(getContext()));//设置为listview的布局
        mRecycleview.setItemAnimator(new DefaultItemAnimator());//设置动画
    }

    @Override
    public int createViewLayoutId() {
        return R.layout.fragment_three;
    }

}
