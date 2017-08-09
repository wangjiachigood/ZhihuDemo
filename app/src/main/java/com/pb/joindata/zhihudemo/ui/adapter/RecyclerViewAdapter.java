package com.pb.joindata.zhihudemo.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pb.joindata.zhihudemo.R;
import com.pb.joindata.zhihudemo.bean.zhihu.NewsTimeLine;

import java.util.List;

/**
 * Created by wangjiachi on 2017/8/7.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<NewsTimeLine> mList;
    private Context mContext;

    public RecyclerViewAdapter(Context mContext, List<NewsTimeLine> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_page, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvList.setText(mList.get(position).toString());
//        Log.d("------->",mList.get(3).toString());
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvList;

        public ViewHolder(View itemView) {
            super(itemView);
            tvList = (TextView) itemView.findViewById(R.id.tvv_list);
        }
    }
}
