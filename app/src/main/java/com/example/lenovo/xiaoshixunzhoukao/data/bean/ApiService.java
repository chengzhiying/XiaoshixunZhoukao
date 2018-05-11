package com.example.lenovo.xiaoshixunzhoukao.data.bean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Lenovo on 2018/5/11.
 */

public interface ApiService {
    @GET("first_page .json")
    Observable<Bean> getData();

    @GET("second_page.json")
    Observable<Entry> getData2();

}
