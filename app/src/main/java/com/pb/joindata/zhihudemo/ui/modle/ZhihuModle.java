package com.pb.joindata.zhihudemo.ui.modle;

import com.pb.joindata.zhihudemo.bean.zhihu.News;
import com.pb.joindata.zhihudemo.http.APIservice;
import com.pb.joindata.zhihudemo.http.GlobalField;
import com.pb.joindata.zhihudemo.bean.zhihu.NewsTimeLine;
import com.pb.joindata.zhihudemo.ui.Contract.IBaseModel;
import com.pb.joindata.zhihudemo.ui.Contract.OnHttpCallBack;
import com.pb.joindata.zhihudemo.http.RetrofitUtils;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by wangjiachi on 2017/8/8.
 */

public class ZhihuModle implements IBaseModel.FragmentModel {

    @Override
    public void getMovie(final OnHttpCallBack<NewsTimeLine> callBack) {
        RetrofitUtils.newInstence(GlobalField.ZHIHU_BASE_URL)
                .create(APIservice.class)
                .getLatestNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<NewsTimeLine>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        //失败的时候回调-----一下可以忽略 直接 callBack.onFaild("请求失败");
                        if (e instanceof HttpException) {
                            HttpException httpException = (HttpException) e;
                            //httpException.response().errorBody().string()
                            int code = httpException.code();
                            if (code == 500 || code == 404) {
                                callBack.onFaild("服务器出错");
                            }
                        } else if (e instanceof ConnectException) {
                            callBack.onFaild("网络断开,请打开网络!");
                        } else if (e instanceof SocketTimeoutException) {
                            callBack.onFaild("网络连接超时!!");
                        } else {
                            callBack.onFaild("发生未知错误" + e.getMessage());
//                            KLog.e(e.getMessage());
                        }
                    }

                    @Override
                    public void onNext(NewsTimeLine newsTimeLine) {
                        callBack.onSuccessful(newsTimeLine);//请求成功---回调
                    }
                });
    }

    @Override
    public void loadMoreNews(String time, final OnHttpCallBack<NewsTimeLine> callBack) {
        RetrofitUtils.newInstence(GlobalField.ZHIHU_BASE_URL)
                .create(APIservice.class)
                .getBeforetNews(time)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<NewsTimeLine>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        //失败的时候回调-----一下可以忽略 直接 callBack.onFaild("请求失败");
                        if (e instanceof HttpException) {
                            HttpException httpException = (HttpException) e;
                            //httpException.response().errorBody().string()
                            int code = httpException.code();
                            if (code == 500 || code == 404) {
                                callBack.onFaild("服务器出错");
                            }
                        } else if (e instanceof ConnectException) {
                            callBack.onFaild("网络断开,请打开网络!");
                        } else if (e instanceof SocketTimeoutException) {
                            callBack.onFaild("网络连接超时!!");
                        } else {
                            callBack.onFaild("发生未知错误" + e.getMessage());
//                            KLog.e(e.getMessage());
                        }
                    }

                    @Override
                    public void onNext(NewsTimeLine newsTimeLine) {
                        callBack.onSuccessful(newsTimeLine);//请求成功---回调
                    }
                });
    }

    @Override
    public void getNewsDetail(String id, final OnHttpCallBack<News> callBack) {
        RetrofitUtils.newInstence(GlobalField.ZHIHU_BASE_URL)
                .create(APIservice.class)
                .getDetailNews(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<News>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        //失败的时候回调-----一下可以忽略 直接 callBack.onFaild("请求失败");
                        if (e instanceof HttpException) {
                            HttpException httpException = (HttpException) e;
                            //httpException.response().errorBody().string()
                            int code = httpException.code();
                            if (code == 500 || code == 404) {
                                callBack.onFaild("服务器出错");
                            }
                        } else if (e instanceof ConnectException) {
                            callBack.onFaild("网络断开,请打开网络!");
                        } else if (e instanceof SocketTimeoutException) {
                            callBack.onFaild("网络连接超时!!");
                        } else {
                            callBack.onFaild("发生未知错误" + e.getMessage());
//                            KLog.e(e.getMessage());
                        }
                    }

                    @Override
                    public void onNext(News news) {
                        callBack.onSuccessful(news);//请求成功---回调
                    }
                });
    }
}
