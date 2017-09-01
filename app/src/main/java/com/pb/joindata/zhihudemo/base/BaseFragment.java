package com.pb.joindata.zhihudemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pb.joindata.zhihudemo.ui.Contract.IBasePresenter;

/**
 * Created by wangjiachi on 2017/8/4.
 */

public abstract class BaseFragment<T extends IBasePresenter> extends Fragment {
    protected T mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = InitPresenter();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(createViewLayoutId(), null);
        return rootview;
    }

    protected abstract void onInflated(View contentView, Bundle savedInstanceState);

    protected abstract T InitPresenter();

    public abstract int createViewLayoutId();

}
