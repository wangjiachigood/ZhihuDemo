package com.pb.joindata.zhihudemo.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pb.joindata.zhihudemo.R;
import com.pb.joindata.zhihudemo.bean.zhihu.NewsTimeLine;
import com.pb.joindata.zhihudemo.widget.TopStoriesViewPager;

import java.util.List;

/**
 * Created by wangjiachi on 2017/9/4.
 */

public class ZhiHuTopViewAdapter extends RecyclerView.Adapter<ZhiHuTopViewAdapter.ViewHolder> {
    private List<NewsTimeLine> mList;
    private Context mContext;

    public ZhiHuTopViewAdapter(Context mContext, List<NewsTimeLine> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_zhihu_top_stories, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (mList.size() != 0) {
            return mList.get(0).getTop_stories().size();
        } else {
            return 0;
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TopStoriesViewPager vp_top_stories;
        private TextView tv_top_title;
        private TextView tv_tag;

        public ViewHolder(View itemView) {
            super(itemView);
            vp_top_stories = (TopStoriesViewPager) itemView.findViewById(R.id.card_stories);
            tv_top_title = (TextView) itemView.findViewById(R.id.tv_stories_title);
            tv_tag = (TextView) itemView.findViewById(R.id.iv_stories_img);
        }
    }
}
