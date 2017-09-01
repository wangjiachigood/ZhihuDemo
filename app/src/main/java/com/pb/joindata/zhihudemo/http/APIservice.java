package com.pb.joindata.zhihudemo.http;

import com.pb.joindata.zhihudemo.bean.gank.GankData;
import com.pb.joindata.zhihudemo.bean.gank.Meizhi;
import com.pb.joindata.zhihudemo.bean.more.DailyTimeLine;
import com.pb.joindata.zhihudemo.bean.zhihu.NewsTimeLine;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;



/**
 * Created by wangjiachi on 2017/8/8.
 */

public interface APIservice {
    @GET("news/latest")
    Observable<NewsTimeLine> getLatestNews();

    @GET("data/福利/10/{page}")
    Observable<Meizhi> getMeizhiData(@Path("page") int page);

    @GET("day/{year}/{month}/{day}")
    Observable<GankData> getGankData(@Path("year") int year, @Path("month") int month, @Path("day") int day);

    @GET("homes/index/{num}.json")
    Observable<DailyTimeLine> getDailyTimeLine(@Path("num") String num);

}
