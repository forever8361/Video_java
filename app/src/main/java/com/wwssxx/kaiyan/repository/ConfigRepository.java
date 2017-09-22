package com.wwssxx.kaiyan.repository;

import com.wwssxx.kaiyan.model.CategoryAllEntiry;
import com.wwssxx.kaiyan.model.DiscovertoryCategoryEntiry;
import com.wwssxx.kaiyan.model.DiscovertoryEntiry;
import com.wwssxx.kaiyan.model.DiscovertoryHotEntiry;
import com.wwssxx.kaiyan.model.FollowEntiry;
import com.wwssxx.kaiyan.model.NeedleSorucesEntiry;
import com.wwssxx.kaiyan.model.PgcsEntiry;
import com.wwssxx.kaiyan.model.SelectdEntiry;
import com.wwssxx.kaiyan.repository.config.RetrofitManager;
import com.wwssxx.kaiyan.repository.services.ConfigService;

import io.reactivex.Observable;

public class ConfigRepository {

    private volatile static ConfigRepository instance;

    private ConfigRepository() {
    }

    public static ConfigRepository getInstance() {
        if (instance == null) {
            synchronized (ConfigRepository.class) {
                if (instance == null) {
                    instance = new ConfigRepository();
                }
            }
        }
        return instance;
    }

    public Observable<SelectdEntiry> getTabSelectedData(int page) {
        ConfigService service = RetrofitManager.getRxRetrofit2().create(ConfigService.class);
        return service.getTabSelectedData(2,page,"8253c55be0444bb1a66ed81ea067b2e1a96e9c0b&vc=220");
    }

    public Observable<DiscovertoryEntiry> getDiscovertoryData() {
        ConfigService service = RetrofitManager.getRxRetrofit2().create(ConfigService.class);

        return service.getDiscovertoryData();
    }

    public Observable<DiscovertoryHotEntiry> getDiscovertoryHotData() {
        ConfigService service = RetrofitManager.getRxRetrofit2().create(ConfigService.class);
        return service.getDiscovertoryHotData();
    }

    public Observable<DiscovertoryCategoryEntiry> getDiscovertoryCategoryData() {
        ConfigService service = RetrofitManager.getRxRetrofit2().create(ConfigService.class);
        return service.getDiscovertoryCategoryData();
    }

    public Observable<NeedleSorucesEntiry> getNeedleSorucesData() {
        ConfigService service = RetrofitManager.getRxRetrofit3().create(ConfigService.class);
        return service.getNeedleSorucesData();
    }

    public Observable<String[]> getSearthHotData() {
        ConfigService service = RetrofitManager.getRxRetrofit4().create(ConfigService.class);
        return service.getSearthHotData();
    }

    public Observable<SelectdEntiry> getSearchResultData(String search) {
        ConfigService service = RetrofitManager.getRxRetrofit5().create(ConfigService.class);
        return service.getSearchResultData(search);
    }

    public Observable<CategoryAllEntiry> getCategoryAllData() {
        ConfigService service = RetrofitManager.getRxRetrofit2().create(ConfigService.class);
        return service.getCategoryAllData();
    }
    public Observable<FollowEntiry> getfollowData() {
        ConfigService service = RetrofitManager.getRxRetrofit2().create(ConfigService.class);
        return service.getfollowData();
    }
    public Observable<PgcsEntiry> getPgcsAllData() {
        ConfigService service = RetrofitManager.getRxRetrofit2().create(ConfigService.class);
        return service.getPgcsAllData();
    }
}