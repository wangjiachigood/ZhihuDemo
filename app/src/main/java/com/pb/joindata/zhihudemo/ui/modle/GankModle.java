package com.pb.joindata.zhihudemo.ui.modle;


import android.util.Log;

import com.pb.joindata.zhihudemo.http.APIservice;
import com.pb.joindata.zhihudemo.http.GlobalField;
import com.pb.joindata.zhihudemo.bean.gank.Meizhi;
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

public class GankModle implements IBaseModel.GankFragmentModel {


    @Override
    public void getGank(int page, final OnHttpCallBack<Meizhi> callBack) {
        RetrofitUtils.newInstence(GlobalField.GANK_BASE_URL)
                .create(APIservice.class)
                .getMeizhiData(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<Meizhi>() {
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
                            Log.d("111",e.getMessage());
                        }
                    }

                    @Override
                    public void onNext(Meizhi meizhi) {
                        callBack.onSuccessful(meizhi);//请求成功---回调
                    }
                });

    }
}