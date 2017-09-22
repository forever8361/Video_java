package com.wwssxx.kaiyan.config;

import com.jayfeng.lesscode.core.LogLess;
import com.wwssxx.kaiyan.widget.NewToast;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class WebDataUtils {

    /**
     * 错误异常处理
     *
     * @param throwable
     * @param showToast
     */
    public static boolean errorThrowable(Throwable throwable, boolean showToast) {
        boolean isNetworkError = false;
        if (throwable instanceof ConnectException
                || throwable instanceof SocketTimeoutException
                || throwable instanceof UnknownHostException) {
            isNetworkError = true;
            if (showToast) {
                NewToast.show(Global.getContext(), "网络不佳，请稍后重试");
            }
        } else {
            if (showToast) {
                NewToast.show(Global.getContext(), "出错了，请稍后重试");
            }
        }
        LogLess.$d("error throwable:" + throwable.getMessage());
        return isNetworkError;
    }
}
