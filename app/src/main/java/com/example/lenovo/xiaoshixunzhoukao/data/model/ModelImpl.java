package com.example.lenovo.xiaoshixunzhoukao.data.model;

import android.util.Log;

import com.example.lenovo.xiaoshixunzhoukao.data.Model;
import com.example.lenovo.xiaoshixunzhoukao.data.bean.ApiService;
import com.example.lenovo.xiaoshixunzhoukao.data.bean.Bean;
import com.example.lenovo.xiaoshixunzhoukao.data.bean.Entry;
import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Lenovo on 2018/5/11.
 */

public class ModelImpl implements Model {
    @Override
    public void setOnDataChangeListener(final OnDataChangedListener listener) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://169.254.151.174")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                        listener.onShowData(bean);
                    }
                });
    }

    @Override
    public void setOnDataChangeListener2(final OnDataChangedListener2 listener2) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://169.254.151.174")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getData2()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Entry>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
Log.e("======",e.toString());
                    }

                    @Override
                    public void onNext(Entry entry) {
                        Log.e("---------",entry.toString());
                      listener2.onShowData(entry);
                    }
                });
    }
}
