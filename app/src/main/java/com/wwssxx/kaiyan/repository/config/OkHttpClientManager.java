package com.wwssxx.kaiyan.repository.config;

import com.jayfeng.lesscode.debug.DebugHttpLoggingInterceptor;
import com.wwssxx.kaiyan.config.Global;

import java.io.File;
import java.io.IOException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpClientManager {

    /**
     * *******************************************************************
     * singleton
     * *******************************************************************
     */
    private OkHttpClientManager() {
    }

    private static class SingletonHolder {
        private static final OkHttpClient instance = createOkHttpClient();
    }

    private static class SingletonHolderForDebug {
        private static final OkHttpClient instance = createOkHttpClient();
    }

    public static OkHttpClient getOkHttpClient() {
//        if (ProjectConfig.DEBUG) {
//            return SingletonHolderForDebug.instance;
//        } else {
        return SingletonHolder.instance;
//        }
    }

    private static OkHttpClient createOkHttpClient() {

        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        DebugHttpLoggingInterceptor debugHttpLoggingInterceptor = new DebugHttpLoggingInterceptor();
        debugHttpLoggingInterceptor.setDebugHttpLoggingCallback(new DebugHttpLoggingInterceptor.DebugHttpLoggingCallback() {
            @Override
            public void onLog(String log) {
                //EventBus.getDefault().post(new MyDebugEvent(log, false));
            }
        });
        debugHttpLoggingInterceptor.setLevel(DebugHttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .hostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        return true;
                    }
                })
                .addInterceptor(headerInterceptor)
                .addInterceptor(debugHttpLoggingInterceptor)
                .addInterceptor(logInterceptor)
               // .cache(getOkHttpCache())
                .build();
        return okHttpClient;
    }

    /**
     * global http header setting
     */
    private static Interceptor headerInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request originalRequest = chain.request();
            Request.Builder newRequestBuilder = originalRequest.newBuilder();
            newRequestBuilder.header("platform", "Android");
            newRequestBuilder.header("udid", "8253c55be0444bb1a66ed81ea067b2e1a96e9c0b");

            return chain.proceed(newRequestBuilder.build());
        }
    };

    private static Cache getOkHttpCache() {
        File cacheFile = new File(Global.getContext().getCacheDir(), "OkCache");
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
        return cache;
    }
}
