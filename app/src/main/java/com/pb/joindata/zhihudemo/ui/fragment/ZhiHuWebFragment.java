package com.pb.joindata.zhihudemo.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pb.joindata.zhihudemo.R;
import com.pb.joindata.zhihudemo.base.BaseFragment;
import com.pb.joindata.zhihudemo.bean.zhihu.News;
import com.pb.joindata.zhihudemo.ui.Contract.IBaseView;
import com.pb.joindata.zhihudemo.ui.presenter.ZhiHuWebPresenter;

/**
 * Created by wangjiachi on 2017/9/8.
 */

public class ZhiHuWebFragment extends BaseFragment implements IBaseView.ZhiHuWebView {
    private String newsId;
    private WebView web_view;
    private ImageView iv_web_img;
    private TextView tv_img_title;
    private TextView tv_img_source;

    @Override
    protected void onInflated(View contentView, Bundle savedInstanceState) {
        initView(contentView);
        initData();

    }

    private void initView(View contentView) {
        web_view= (WebView) contentView.findViewById(R.id.web_view);
        iv_web_img= (ImageView) contentView.findViewById(R.id.iv_web_img);
        tv_img_title= (TextView) contentView.findViewById(R.id.tv_img_title);
        tv_img_source= (TextView) contentView.findViewById(R.id.tv_img_source);
    }

    private void initData() {
        mPresenter.getData();
    }

    @Override
    protected ZhiHuWebPresenter InitPresenter() {
        Bundle bundle = getArguments();//从activity传过来的Bundle
        if (bundle != null) {
            newsId = bundle.getString("NEWSID");
        }
        return new ZhiHuWebPresenter(this, newsId);
    }

    @Override
    public int createViewLayoutId() {
        return R.layout.activity_web_view;
    }

    @Override
    public void skipDetail(News news) {
        WebSettings settings = web_view.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        String head = "<head>\n" +
                "\t<link rel=\"stylesheet\" href=\""+news.getCss()[0]+"\"/>\n" +
                "</head>";
        String img = "<div class=\"headline\">";
        String html =head + news.getBody().replace(img," ");
        web_view.loadDataWithBaseURL(null,html,"text/html","utf-8",null);
        Glide.with(getContext()).load(news.getImage()).centerCrop().into(iv_web_img);

        tv_img_title.setText(news.getTitle());
        tv_img_source.setText(news.getImage_source());
    }
}
