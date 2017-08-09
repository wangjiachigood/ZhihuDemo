package com.pb.joindata.zhihudemo.ui.fragment;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.pb.joindata.zhihudemo.R;
import com.pb.joindata.zhihudemo.base.BaseFragment;
import com.pb.joindata.zhihudemo.bean.zhihu.NewsTimeLine;
import com.pb.joindata.zhihudemo.ui.adapter.RecyclerViewAdapter;
import com.pb.joindata.zhihudemo.ui.presenter.ZhiHuFgPresenter;
import com.pb.joindata.zhihudemo.ui.view.FragmentContract;

import java.util.List;

/**
 * Created by wangjiachi on 2017/8/7.
 */

public class Fragment extends BaseFragment<ZhiHuFgPresenter> implements FragmentContract.FragmentView{
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private ZhiHuFgPresenter mPresenter;
    private FragmentContract.FragmentView mFragmentView;
    @Override
    protected ZhiHuFgPresenter InitPresenter() {
        return new ZhiHuFgPresenter(getContext(),mFragmentView);
    }

    @Override
    public void initView(View view) {
        mPresenter=new ZhiHuFgPresenter(getContext(),mFragmentView);
        mPresenter.getData();
        mRecyclerView= (RecyclerView) view.findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));//设置为listview的布局
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());//设置动画
    }

    @Override
    public int createViewLayoutId() {
        return R.layout.fragment_one;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void hideSwipe() {
//        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showData(List<NewsTimeLine> mNews) {
        mRecyclerViewAdapter=new RecyclerViewAdapter(getContext(),mNews);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
    }


}
