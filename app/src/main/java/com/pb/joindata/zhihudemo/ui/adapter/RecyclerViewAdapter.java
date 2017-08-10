package com.pb.joindata.zhihudemo.ui.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pb.joindata.zhihudemo.R;
import com.pb.joindata.zhihudemo.bean.zhihu.NewsTimeLine;

import java.util.List;

/**
 * Created by wangjiachi on 2017/8/7.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<NewsTimeLine> mList;
    private Context mContext;
    private View mFooterView;

    public RecyclerViewAdapter(Context mContext, List<NewsTimeLine> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_zhihu_stories, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_stories_title.setText(mList.get(position).getStories().get(position).getTitle());
        String[] images = mList.get(position).getStories().get(position).getImages();
        Glide.with(mContext).load(images[0]).centerCrop().into(holder.iv_stories_img);
//        Log.d("------->",mList.get(3).toString());
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_stories_title;
        public CardView mCardview;
        public ImageView iv_stories_img;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_stories_title = (TextView) itemView.findViewById(R.id.tv_stories_title);
            mCardview = (CardView) itemView.findViewById(R.id.card_stories);
            iv_stories_img = (ImageView) itemView.findViewById(R.id.iv_stories_img);
        }
    }
}
