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

/**
 * Created by wangjiachi on 2017/8/7.
 */

public class ZhiHuFragment extends BaseFragment<IBasePresenter> implements IBaseView {
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private SwipeToLoadLayout mSwipeToLoadLayout;
    private ArrayList<NewsTimeLine> zhihulist = new ArrayList<>();

    @Override
    protected void onInflated(View contentView, Bundle savedInstanceState) {
        initView(contentView);
        initListener();
//        mSwipeToLoadLayout.setRefreshing(true);
//        mPresenter.getData();
    }
    @Override
    protected ZhiHuFgPresenter InitPresenter() {
        return new ZhiHuFgPresenter(this);
    }

    private void initListener() {
        mSwipeToLoadLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                mRecyclerViewAdapter.notifyDataSetChanged();
                mSwipeToLoadLayout.setRefreshing(false);
            }
        });
        mSwipeToLoadLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
            }
        });
    }


    public void initView(View contentView) {
        mPresenter.getData();
        mRecyclerView = (RecyclerView) contentView.findViewById(R.id.swipe_target);
        mSwipeToLoadLayout = (SwipeToLoadLayout) contentView.findViewById(R.id.swipeToLoadLayout);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));//设置为listview的布局
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());//设置动画
        mRecyclerViewAdapter = new RecyclerViewAdapter(getContext(), zhihulist);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
    }

    @Override
    public int createViewLayoutId() {
        return R.layout.fragment_one;
    }


    @Override
    public void refreshList(NewsTimeLine mList) {
        zhihulist.add(mList);
        mRecyclerViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void hideSwipe() {
        mSwipeToLoadLayout.setRefreshing(false);
    }


}
