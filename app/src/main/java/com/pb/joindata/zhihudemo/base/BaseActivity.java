package com.pb.joindata.zhihudemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.pb.joindata.zhihudemo.R;

/**
 * Created by wangjiachi on 2017/8/4.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private boolean mIsDestroyed = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        setContentView(initContentView());
        initView();
        initData();
    }

    protected abstract void initData();

    /**
     * 绑定布局文件
     *
     * @return 布局文件ID
     */
    protected int initContentView() {
        return R.layout.base_fragment_activity;
    }
    /**
     * 初始化视图控件
     */
    protected abstract void initView();
    public void replaceFragment(Fragment newFragment) {
        replaceFragment(newFragment, null, false);
    }

    public void replaceFragment(Fragment newFragment, Bundle arguments, boolean isAddStack) {
        if (isFinishing()) {
            return;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (arguments != null) {
            newFragment.setArguments(arguments);
        }
        transaction.replace(R.id.fragment_container, newFragment);
        if (isAddStack) {
            transaction.addToBackStack(null);
        }
        if (!isDestroyed()) {
            transaction.commitAllowingStateLoss();
        }
    }
    public boolean isDestroyed() {
        try {
            return super.isDestroyed();
        } catch (NoSuchMethodError e) {
            return mIsDestroyed;
        }
    }
}
