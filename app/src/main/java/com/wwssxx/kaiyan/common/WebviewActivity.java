package com.wwssxx.kaiyan.common;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.jayfeng.lesscode.core.LogLess;
import com.jayfeng.lesscode.core.ViewLess;
import com.wwssxx.kaiyan.R;
import com.wwssxx.kaiyan.base.BaseActivity;
import com.wwssxx.kaiyan.config.Api;


public class WebviewActivity extends BaseActivity {
    public static final String WEBVIEW_URL = "webview_url";
    public static final String WEBVIEW_TITLE = "webview_title";
    private String mUrl;
    protected WebView mWebView;
    private String mInitTitle;

    private WebChromeClient mWebChromeClient = new WebChromeClient() {
        private String mTitle;

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            this.mTitle = title;
        }

        public void onProgressChanged(WebView view, int progress) {
            if (progress < 99) {
                mHeaderBar.setTitle("正在加载...");
            } else {
                mHeaderBar.setTitle(mTitle);
            }
        }
    };

    private WebViewClient mWebViewClient = new WebViewClient() {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            LogLess.$d("shouldOverrideUrlLoading-url:" + url);
//            if (url.startsWith("https://action")) {
//                doShare();
//                return true;
//            }
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            mWebView.setVisibility(View.GONE);
            mHeaderBar.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mHeaderBar.setTitle(mInitTitle);
                }
            }, 200);
        }


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        translateStatusBar();
        mUrl = getIntent().getStringExtra(WEBVIEW_URL);
        mInitTitle = getIntent().getStringExtra(WEBVIEW_TITLE);
        initHeaderBar("正在加载", true);
        if (!TextUtils.isEmpty(mUrl) && mUrl.equals(Api.sShareUrl)) {
            mHeaderBar.addRightImageItem(R.drawable.app_share, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    doShare();
                }
            });
        }

        mWebView = ViewLess.$(this, R.id.webview);
        mWebView.setWebChromeClient(mWebChromeClient);
        mWebView.setWebViewClient(mWebViewClient);

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setUseWideViewPort(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);


        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {
                                          mWebView.loadUrl(mUrl);
                                      }
                                  }

                , 100);

    }


    private void doShare() {
    }

    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
