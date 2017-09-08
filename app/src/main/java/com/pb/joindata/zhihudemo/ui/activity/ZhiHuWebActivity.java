package com.pb.joindata.zhihudemo.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.pb.joindata.zhihudemo.base.BaseActivity;
import com.pb.joindata.zhihudemo.base.BaseFragment;
import com.pb.joindata.zhihudemo.ui.fragment.ZhiHuWebFragment;

/**
 * Created by wangjiachi on 2017/9/6.
 */

public class ZhiHuWebActivity extends BaseActivity {
    private static final String ID = "id";
    private String id;
    private Bundle bundle;

    public static void launch(Context context, String id) {
        Intent intent = new Intent(context, ZhiHuWebActivity.class);
        intent.putExtra(ID,id);
        context.startActivity(intent);
    }

    @Override
    protected void initView() {
        mFragment = (BaseFragment) Fragment.instantiate(this, ZhiHuWebFragment.class.getName(), getIntent().getExtras());
        replaceFragment(mFragment);
        bundle=new Bundle();
        id=getIntent().getStringExtra(ID);
        bundle.putString("NEWSID",id);
        mFragment.setArguments(bundle);
    }
}
