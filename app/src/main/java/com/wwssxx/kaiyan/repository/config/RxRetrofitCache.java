package com.wwssxx.kaiyan.repository.config;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.jayfeng.lesscode.core.CacheLess;
import com.wwssxx.kaiyan.config.Constant;

import java.lang.reflect.Type;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RxRetrofitCache {
    public static <T> Observable<T> load(final String cacheKey, final long expireTime, Observable<T> fromNetwork, boolean forceRefresh, final Type type) {

        Observable<T> fromCache = Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> emitter) throws Exception {
                String cache = CacheLess.$get(cacheKey, expireTime);

                if (!TextUtils.isEmpty(cache)) {
                   // EventBus.getDefault().post(new MyDebugEvent(DebugUtils.formatBodyToJson(cache.trim()), true));
                    T result = new Gson().fromJson(cache, type);
                    emitter.onNext(result);
                } else {
                    emitter.onComplete();
                }
            }
        }).subscribeOn(Schedulers.io());

        fromNetwork = fromNetwork.subscribeOn(Schedulers.newThread())
                .map(new Function<T, T>() {
                    @Override
                    public T apply(T mapResult) throws Exception {
                        String cache = new Gson().toJson(mapResult);
                        CacheLess.$set(cacheKey, cache);
                        return mapResult;
                    }
                });

        if (forceRefresh) {
            return fromNetwork;
        } else {
            return Observable.concat(fromCache, fromNetwork);
        }
    }

    public static <T> T loadCacheOnly(String cacheKey, Type type) {
        String cache = CacheLess.$get(cacheKey, Constant.TIME_ONE_HOUR * 10000);
        if (!TextUtils.isEmpty(cache)) {
            T result = new Gson().fromJson(cache, type);
            return result;
        }

        return null;
    }
}
