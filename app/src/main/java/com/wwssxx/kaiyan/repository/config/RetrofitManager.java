package com.wwssxx.kaiyan.repository.config;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.wwssxx.kaiyan.config.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitManager {

    private static Retrofit.Builder buildBaseRetrofit() {
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .client(OkHttpClientManager.getOkHttpClient())
                .addConverterFactory(ScalarsConverterFactory.create());
        return retrofitBuilder;
    }

    private static Retrofit.Builder buildBaseRetrofit2() {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .client(OkHttpClientManager.getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(gson));
        return retrofitBuilder;
    }

    public static Retrofit getRxRetrofit() {
        return buildBaseRetrofit()
                .baseUrl(Api.sServerApiUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static Retrofit getRxRetrofit2() {
        return buildBaseRetrofit2()
                .baseUrl(Api.sServerApiUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static Retrofit getRxRetrofit3() {
        return buildBaseRetrofit2()
                .baseUrl(Api.sNeedleSourcesUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
    public static Retrofit getRxRetrofit4() {
        return buildBaseRetrofit2()
                .baseUrl(Api.sSearchAllDataUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static Retrofit getRxRetrofit5() {
        return buildBaseRetrofit2()
                .baseUrl(Api.sSearchUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
