package com.pb.joindata.zhihudemo.ui.fragment;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.pb.joindata.zhihudemo.R;
import com.pb.joindata.zhihudemo.base.BaseFragment;
import com.pb.joindata.zhihudemo.ui.presenter.GankPresenter;

/**
 * Created by wangjiachi on 2017/8/7.
 */

public class FragmentTwo extends BaseFragment<GankPresenter> {
    private RecyclerView mRecyclerView;
    private GankPresenter mGankPresenter;
    @Override
    protected GankPresenter InitPresenter() {
        return new GankPresenter(getContext());
    }

    @Override
    public void initView(View view) {
        mGankPresenter=new GankPresenter(getContext());
        mGankPresenter.getData();
        mRecyclerView= (RecyclerView) view.findViewById(R.id.gank_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));//设置为listview的布局
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());//设置动画
    }

    @Override
    public int createViewLayoutId() {
        return R.layout.fragment_two;
    }

}
