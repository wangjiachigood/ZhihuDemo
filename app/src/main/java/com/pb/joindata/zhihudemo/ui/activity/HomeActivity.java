package com.pb.joindata.zhihudemo.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.pb.joindata.zhihudemo.R;
import com.pb.joindata.zhihudemo.base.BaseActivity;
import com.pb.joindata.zhihudemo.ui.adapter.ViewPageAdapter;
import com.pb.joindata.zhihudemo.ui.fragment.Fragment;
import com.pb.joindata.zhihudemo.ui.fragment.FragmentThree;
import com.pb.joindata.zhihudemo.ui.fragment.FragmentTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjiachi on 2017/8/4.
 */

public class HomeActivity extends BaseActivity{
    private Toolbar mToolbar;
    private TabLayout mTablayout;
    private ViewPager mViewpage;
    private AppBarLayout mAppBar;
    private List mList = new ArrayList();

    public static void launch(Context context){
        Intent intent = new Intent(context, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }


    @Override
    protected void initData() {
        mToolbar.setTitle("知乎");
        mList.add(new Fragment());
        mList.add(new FragmentTwo());
        mList.add(new FragmentThree());
        mViewpage.setOffscreenPageLimit(3);
        mViewpage.setAdapter(new ViewPageAdapter(getSupportFragmentManager(),mList,"main_view_pager"));
        mTablayout.setupWithViewPager(mViewpage);
    }

    @Override
    protected void initView() {
        mTablayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewpage = (ViewPager) findViewById(R.id.content_viewPager);
        mToolbar= (Toolbar) findViewById(R.id.toolbar);
        mAppBar= (AppBarLayout) findViewById(R.id.app_bar_layout);
    }

    @Override
    protected int initContentView() {
        return R.layout.activity_main;
    }
}
