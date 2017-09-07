package com.pb.joindata.zhihudemo.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.pb.joindata.zhihudemo.R;
import com.pb.joindata.zhihudemo.base.BaseFragment;
import com.pb.joindata.zhihudemo.bean.zhihu.NewsTimeLine;
import com.pb.joindata.zhihudemo.ui.Contract.IBasePresenter;
import com.pb.joindata.zhihudemo.ui.Contract.IBaseView;
import com.pb.joindata.zhihudemo.ui.adapter.RecyclerViewAdapter;
import com.pb.joindata.zhihudemo.ui.presenter.ZhiHuFgPresenter;

import java.util.ArrayList;

import static com.pb.joindata.zhihudemo.R.id.swipeToLoadLayout;

/**
 * Created by wangjiachi on 2017/8/7.
 */

public class ZhiHuFragment extends BaseFragment<IBasePresenter> implements IBaseView.ZhihuView {
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private SwipeToLoadLayout mSwipeToLoadLayout;
    private ArrayList<NewsTimeLine> zhihulist = new ArrayList<>();

    @Override
    protected void onInflated(View contentView, Bundle savedInstanceState) {
        initView(contentView);
        initData();
        initListener();
    }

    @Override
    protected ZhiHuFgPresenter InitPresenter() {
        return new ZhiHuFgPresenter(this);
    }

    private void initListener() {
        mSwipeToLoadLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getData();
            }
        });
        mSwipeToLoadLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                mSwipeToLoadLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPresenter.getMoreData();
                    }
                }, 0);
            }
        });
    }


    public void initView(View contentView) {
        mRecyclerView = (RecyclerView) contentView.findViewById(R.id.swipe_target);
        mSwipeToLoadLayout = (SwipeToLoadLayout) contentView.findViewById(swipeToLoadLayout);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));//设置为listview的布局
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());//设置动画
    }

    private void initData() {
        mSwipeToLoadLayout.setRefreshing(true);
        mPresenter.getData();
        mRecyclerViewAdapter = new RecyclerViewAdapter(getContext(), zhihulist);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
    }

    @Override
    public int createViewLayoutId() {
        return R.layout.fragment_one;
    }


    @Override
    public void refreshList(NewsTimeLine mList) {
        mRecyclerViewAdapter.notifyDataSetChanged();
        zhihulist.add(mList);
        mSwipeToLoadLayout.setRefreshing(false);
    }

    @Override
    public void loadMoreList(NewsTimeLine mList) {
        zhihulist.add(mList);
        mRecyclerViewAdapter.notifyDataSetChanged();
        mSwipeToLoadLayout.setRefreshing(false);
    }


}
