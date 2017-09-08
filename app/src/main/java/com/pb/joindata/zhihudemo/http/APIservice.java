package com.pb.joindata.zhihudemo.http;

import com.pb.joindata.zhihudemo.bean.gank.GankData;
import com.pb.joindata.zhihudemo.bean.gank.Meizhi;
import com.pb.joindata.zhihudemo.bean.more.DailyTimeLine;
import com.pb.joindata.zhihudemo.bean.zhihu.News;
import com.pb.joindata.zhihudemo.bean.zhihu.NewsTimeLine;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;


/**
 * Created by wangjiachi on 2017/8/8.
 */

public interface APIservice {
    //知乎最新几条消息
    @GET("news/latest")
    Observable<NewsTimeLine> getLatestNews();

    //加载更多消息
    @GET("news/before/{time}")
    Observable<NewsTimeLine> getBeforetNews(@Path("time") String time);

    //查看知乎item详情
    @GET("news/{id}")
    Observable<News> getDetailNews(@Path("id") String id);

    @GET("data/福利/10/{page}")
    Observable<Meizhi> getMeizhiData(@Path("page") int page);

    @GET("day/{year}/{month}/{day}")
    Observable<GankData> getGankData(@Path("year") int year, @Path("month") int month, @Path("day") int day);

    @GET("homes/index/{num}.json")
    Observable<DailyTimeLine> getDailyTimeLine(@Path("num") String num);

}
