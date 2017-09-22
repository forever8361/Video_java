package com.wwssxx.kaiyan.module.discover;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.jayfeng.lesscode.core.ViewLess;
import com.wwssxx.kaiyan.R;
import com.wwssxx.kaiyan.base.BaseActivity;
import com.wwssxx.kaiyan.model.NeedleSorucesEntiry;
import com.wwssxx.kaiyan.repository.ConfigRepository;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class NeedleSourcesActivity extends BaseActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_needle_sources);
        initView();
        requestData();
    }

    private void initView() {
        mWebView = ViewLess.$(this, R.id.webview);
    }

    private void requestData() {
        ConfigRepository.getInstance().getNeedleSorucesData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NeedleSorucesEntiry>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NeedleSorucesEntiry needleSorucesEntiry) {
                        if (needleSorucesEntiry != null) {
                            WebSettings webSettings = mWebView.getSettings();
                            webSettings.setJavaScriptEnabled(true);
                            mWebView.addJavascriptInterface(new JavaScriptInterface(), "xueleapp");
                            mWebView.loadDataWithBaseURL(null, needleSorucesEntiry.getContent(), "text/html", "utf-8", null);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
    public class JavaScriptInterface {
        @android.webkit.JavascriptInterface
        public void doTrainFinish() {
            finish();
        }
    }

}
