package com.pb.joindata.zhihudemo.ui.fragment;

import android.app.ProgressDialog;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
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

public class Fragment extends BaseFragment<ZhiHuFgPresenter> implements FragmentContract.FragmentView, SwipeRefreshLayout.OnRefreshListener, OnLoadMoreListener {
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private ZhiHuFgPresenter mPresenter;
    private ProgressDialog progressDialog;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private View footer;
    private SwipeToLoadLayout mSwipeToLoadLayout;
    private FragmentContract.FragmentView mFragmentView;

    @Override
    protected ZhiHuFgPresenter InitPresenter() {
        return new ZhiHuFgPresenter(this);
    }

    @Override
    public void initView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
//        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.sl_list);
        mSwipeToLoadLayout = (SwipeToLoadLayout) view.findViewById(R.id.sl_list);
        footer=View.inflate(getContext(),R.layout.layout_google_footer,null);
        mSwipeToLoadLayout.setLoadMoreFooterView(footer);
        mSwipeToLoadLayout.setOnLoadMoreListener(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));//设置为listview的布局
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());//设置动画
//        mSwipeRefreshLayout.setOnRefreshListener(this);
//        mSwipeRefreshLayout.setColorScheme(android.R.color.holo_blue_bright, android.R.color.holo_green_light,
//             android.R.color.holo_orange_light, android.R.color.holo_red_light);
        mPresenter = new ZhiHuFgPresenter(this);
        mPresenter.getData();
    }

    @Override
    public int createViewLayoutId() {
        return R.layout.fragment_one;
    }

    @Override
    public void showProgress() {
        progressDialog = ProgressDialog.show(getContext(), "提示", "正在获取中,请稍后...");
    }

    @Override
    public void hideProgress() {
        progressDialog.hide();
    }

    @Override
    public void hideSwipe() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showData(List<NewsTimeLine> mNews) {
        mRecyclerViewAdapter = new RecyclerViewAdapter(getContext(), mNews);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
    }

    @Override
    public void onRefresh() {
        mPresenter.getMoreData();
    }


    @Override
    public void onLoadMore() {
        mSwipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeToLoadLayout.setRefreshing(false);
                mPresenter.getMoreData();
            }
        }, 1000);
    }
}
