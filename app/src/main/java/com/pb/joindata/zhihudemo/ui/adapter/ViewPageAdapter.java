package com.pb.joindata.zhihudemo.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by wangjiachi on 2017/8/7.
 */

public class ViewPageAdapter extends FragmentPagerAdapter {
    private List mList;
    private String tag;
    public ViewPageAdapter(FragmentManager fm,List mList,String tag) {
        super(fm);
        this.mList=mList;
        this.tag=tag;
    }

    @Override
    public Fragment getItem(int position) {
        return (Fragment) mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        if (tag.equals("main_view_pager")) {
            switch (position) {
                case 0:
                    return "知乎";
                case 1:
                    return "干货";
                case 2:
                    return "满足你的好奇心";
            }
        }
        return null;
    }
}
