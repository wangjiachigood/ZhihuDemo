package com.pb.joindata.zhihudemo.ui.activity;

import android.content.Context;
import android.content.Intent;

import com.pb.joindata.zhihudemo.base.BaseActivity;

/**
 * Created by wangjiachi on 2017/9/6.
 */

public class ZhiHuWebActivity extends BaseActivity {
    public static void launch(Context context) {
        Intent intent = new Intent(context, ZhiHuWebActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }
}
