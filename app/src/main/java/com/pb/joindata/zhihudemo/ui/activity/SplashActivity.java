package com.pb.joindata.zhihudemo.ui.activity;

import android.os.Handler;

import com.pb.joindata.zhihudemo.R;
import com.pb.joindata.zhihudemo.base.BaseActivity;

/**
 * Created by wangjiachi on 2017/8/4.
 */

public class SplashActivity extends BaseActivity {
    private static final int mSleepTime = 800; // 闪屏停留的时间
    private Handler handler=new Handler();
    @Override
    protected void initData() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                HomeActivity.launch(SplashActivity.this);
                SplashActivity.this.finish();
            }
        },mSleepTime);
    }

    @Override
    protected void initView() {
//        initData();
    }
    @Override
    protected int initContentView() {
        return R.layout.splash_page;
    }
}
