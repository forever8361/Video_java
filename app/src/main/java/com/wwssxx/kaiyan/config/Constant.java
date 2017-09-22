package com.wwssxx.kaiyan.config;

import android.support.annotation.Keep;

@Keep
public class Constant {

    public static final long SYSTEM_UID = 10000L;

    /*
     * ========================================================================
     * user
     * ========================================================================
     */
    public static String PREFERENCE_KEY_USER_SESSION_ID = "user_session_id";
    public static String PREFERENCE_KEY_DEVICE_SESSION_ID = "device_session_id";
    public static String PREFERENCE_KEY_USER_PHONE = "phone";
    public static String PREFERENCE_KEY_USER_DEVICE_PASSWORD = "device_password";
    public static String PREFERENCE_KEY_LOCALE = "locale";

    /**
     * api status code
     */
    public static final int WEB_SUCCESS = 200;

    /**
     * third login type
     */
    public static final String LOGIN_TYPE_QQ = "qq";
    public static final String LOGIN_TYPE_WECHAT = "wx";
    public static final String LOGIN_TYPE_WEIBO = "wb";

    /**
     * long time
     */
    public static final long TIME_ONE_SECOND = 1000;
    public static final long TIME_ONE_MINITUE = 60000;
    public static final long TIME_ONE_HOUR = 3600000;

    /**
     * pay type
     */
    public static final String PAY_TYPE_H5 = "h5";
    public static final String PAY_TYPE_ANDROID = "Android";
    public static final String PAY_TYPE_IOS = "iOS";

    /**
     * user project type
     */
    public static final String USER_PROJECT_TYPE_FREE = "0";
    public static final String USER_PROJECT_TYPE_VIP = "1";

    /**
     * empty type
     */
    public static final int EMPTY_TYPE_NONE = 0;
    public static final int EMPTY_TYPE_EMPTY = 1;
    public static final int EMPTY_TYPE_NETWORK = 2;
    public static final int EMPTY_TYPE_ERROR = 3;

    /**
     * ad jump type
     */
    public static final String AD_TYPE_URL = "url";
    public static final String AD_TYPE_INAPP = "inApp";
    public static final String AD_TYPE_OUTAPP = "outApp";
    public static final String AD_TYPE_BROWSER = "browser";

    /**
     * notice detail type
     */
    public static final String NOTICE_TYPE_TEXT = "text";
    public static final String NOTICE_TYPE_URL = "url";
    public static final String NOTICE_TYPE_BROWSER = "browser";

    /**
     * ip regex
     */
    public static final String IP_REGEX = "^(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])$";

}