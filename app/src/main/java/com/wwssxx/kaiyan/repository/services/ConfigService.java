package com.wwssxx.kaiyan.repository.services;

import com.wwssxx.kaiyan.model.CategoryAllEntiry;
import com.wwssxx.kaiyan.model.DiscovertoryCategoryEntiry;
import com.wwssxx.kaiyan.model.DiscovertoryEntiry;
import com.wwssxx.kaiyan.model.DiscovertoryHotEntiry;
import com.wwssxx.kaiyan.model.FollowEntiry;
import com.wwssxx.kaiyan.model.NeedleSorucesEntiry;
import com.wwssxx.kaiyan.model.PgcsEntiry;
import com.wwssxx.kaiyan.model.SelectdEntiry;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ConfigService {
    String selectTabUrl="http://baobab.kaiyanapp.com/api/v4/tabs/selected?num=2&page=4&udid=8253c55be0444bb1a66ed81ea067b2e1a96e9c0b&vc=220&vn=3.10.0&deviceModel=HUAWEI%20GRA-CL10&first_channel=eyepetizer_zhihuiyun_market&last_channel=eyepetizer_zhihuiyun_market&system_version_code=23";
    @GET("tabs/selected")
    Observable<SelectdEntiry> getTabSelectedData(@Query("num") int num,
                                                 @Query("page") int page,
                                                 @Query("udid") String udid
                                                 );

    @GET("discovery")
    Observable<DiscovertoryEntiry> getDiscovertoryData();

    @GET("discovery/hot")
    Observable<DiscovertoryHotEntiry> getDiscovertoryHotData();

    @GET("discovery/category")
    Observable<DiscovertoryCategoryEntiry> getDiscovertoryCategoryData();

    @GET("1061/getJSON")
    Observable<NeedleSorucesEntiry> getNeedleSorucesData();

    @GET("queries/hot")
    Observable<String[]> getSearthHotData();


    @GET("search")
    Observable<SelectdEntiry> getSearchResultData(@Query("query") String search);

    @GET("categories/all")
    Observable<CategoryAllEntiry> getCategoryAllData();

    @GET("tabs/follow")
    Observable<FollowEntiry> getfollowData();
    @GET("pgcs/all")
    Observable<PgcsEntiry> getPgcsAllData();
}