package com.pb.joindata.zhihudemo.ui.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pb.joindata.zhihudemo.R;
import com.pb.joindata.zhihudemo.bean.zhihu.NewsTimeLine;
import com.pb.joindata.zhihudemo.bean.zhihu.TopStories;
import com.pb.joindata.zhihudemo.ui.activity.ZhiHuWebActivity;
import com.pb.joindata.zhihudemo.widget.TopStoriesViewPager;

/**
 * Created by wangjiachi on 2017/8/7.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private NewsTimeLine newsTimeLine;
    private Context mContext;
    private static final int TYPE_TOP = -1;

    public RecyclerViewAdapter(Context mContext, NewsTimeLine mList) {
        this.mContext = mContext;
        this.newsTimeLine = mList;
    }

    @Override
    public int getItemViewType(int position) {
        if (newsTimeLine.getTop_stories() != null) {
            if (position == 0) {
                return TYPE_TOP;
            } else {
                return position;
            }

        } else {
            return position;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_TOP) {
            View view = View.inflate(parent.getContext(), R.layout.item_zhihu_top_stories, null);
            return new ViewPagerViewHolder(view);
        } else {
            View view = View.inflate(parent.getContext(), R.layout.item_zhihu_stories, null);
            return new ItemViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            itemViewHolder.tv_stories_title.setText(newsTimeLine.getStories().get(position).getTitle());
            String[] images = newsTimeLine.getStories().get(position).getImages();
            Glide.with(mContext).load(images[0]).centerCrop().into(itemViewHolder.iv_stories_img);
        } else if (holder instanceof ViewPagerViewHolder) {
            ViewPagerViewHolder viewPagerViewHolder = (ViewPagerViewHolder) holder;
            viewPagerViewHolder.tv_top_title.setText(newsTimeLine.getTop_stories().get(position).getTitle());
            viewPagerViewHolder.vp_top_stories.init(newsTimeLine.getTop_stories(), viewPagerViewHolder.tv_top_title, new TopStoriesViewPager.ViewPagerClickListenner() {
                @Override
                public void onClick(TopStories item) {
                    ZhiHuWebActivity.launch(mContext);
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        if (newsTimeLine.getStories() != null && newsTimeLine.getStories().size() != 0) {
            return newsTimeLine.getStories().size();
        } else if (newsTimeLine.getTop_stories() != null && newsTimeLine.getTop_stories().size() != 0) {
            return newsTimeLine.getTop_stories().size();
        } else {
            return 0;
        }
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_stories_title;
        public CardView mCardview;
        public ImageView iv_stories_img;

        public ItemViewHolder(View itemView) {
            super(itemView);
            tv_stories_title = (TextView) itemView.findViewById(R.id.tv_stories_title);
            mCardview = (CardView) itemView.findViewById(R.id.card_stories);
            iv_stories_img = (ImageView) itemView.findViewById(R.id.iv_stories_img);
        }
    }

    static class ViewPagerViewHolder extends RecyclerView.ViewHolder {
        private TopStoriesViewPager vp_top_stories;
        TextView tv_top_title;

        public ViewPagerViewHolder(View itemView) {
            super(itemView);
            vp_top_stories = (TopStoriesViewPager) itemView.findViewById(R.id.vp_top_stories);
            tv_top_title = (TextView) itemView.findViewById(R.id.tv_top_title);
        }
    }
}
