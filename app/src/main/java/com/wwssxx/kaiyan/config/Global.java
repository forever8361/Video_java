package com.wwssxx.kaiyan.config;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;

import com.jayfeng.lesscode.core.SharedPreferenceLess;

import java.util.Locale;

public class Global {
    private static Context sContext;
    private static String sUserSessionId;
    private static String sDeviceSessionId;
    private static String sPhone;
    private static String sDevicePassword;
    private static String sLocale;

    public static Context getContext() {
        return sContext;
    }

    public static void setContext(Context context) {
        sContext = context;
    }


    // user session id
    public static String getUserSessionId() {
        if (TextUtils.isEmpty(sUserSessionId)) {
            sUserSessionId = SharedPreferenceLess.$get(Constant.PREFERENCE_KEY_USER_SESSION_ID, "");
        }
        return sUserSessionId;
    }

    public static void setUserSessionId(String userSessionId) {
        SharedPreferenceLess.$put(Constant.PREFERENCE_KEY_USER_SESSION_ID, userSessionId);
        sUserSessionId = userSessionId;
    }

    public static void clearUserSessionId() {
        SharedPreferenceLess.$remove(Constant.PREFERENCE_KEY_USER_SESSION_ID);
        sUserSessionId = null;
    }

    // device session id
    public static String getDeviceSessionId() {
        if (TextUtils.isEmpty(sDeviceSessionId)) {
            sDeviceSessionId = SharedPreferenceLess.$get(Constant.PREFERENCE_KEY_DEVICE_SESSION_ID, "");
        }
        return sDeviceSessionId;
    }

    public static void setDeviceSessionId(String deviceSessionId) {
        SharedPreferenceLess.$put(Constant.PREFERENCE_KEY_DEVICE_SESSION_ID, deviceSessionId);
        sDeviceSessionId = deviceSessionId;
    }

    public static void clearDeviceSessionId() {
        SharedPreferenceLess.$remove(Constant.PREFERENCE_KEY_DEVICE_SESSION_ID);
        sDeviceSessionId = null;
    }

    // phone
    public static String getPhone() {
        if (TextUtils.isEmpty(sPhone)) {
            sPhone = SharedPreferenceLess.$get(Constant.PREFERENCE_KEY_USER_PHONE, "");
        }
        return sPhone;
    }

    public static void setPhone(String phone) {
        SharedPreferenceLess.$put(Constant.PREFERENCE_KEY_USER_PHONE, phone);
        sPhone = phone;
    }

    public static void clearPhone() {
        SharedPreferenceLess.$remove(Constant.PREFERENCE_KEY_USER_PHONE);
        sPhone = null;
    }

    // get android id
    public static String getAndroidID() {
        return Settings.Secure.getString(sContext.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    // get virtual android id, or the really android id
    public static String getVIDOrAndroidID() {
        if (!TextUtils.isEmpty(Global.getDeviceSessionId())) {
            return getDeviceSessionId();
        } else {
            return getAndroidID();
        }
    }

    // generate a random password
    public static String generatePassword() {
        return "111";
    }

    // device password
    public static String getDevicePassword() {
        if (TextUtils.isEmpty(sDevicePassword)) {
            sDevicePassword = SharedPreferenceLess.$get(Constant.PREFERENCE_KEY_USER_DEVICE_PASSWORD, "");
        }
        return sDevicePassword;
    }

    public static void setDevicePassword(String devicePassword) {
        SharedPreferenceLess.$put(Constant.PREFERENCE_KEY_USER_DEVICE_PASSWORD, devicePassword);
        sDevicePassword = devicePassword;
    }

    public static void clearDevicePassword() {
        SharedPreferenceLess.$remove(Constant.PREFERENCE_KEY_USER_DEVICE_PASSWORD);
        sDevicePassword = null;
    }

    // locale
    public static Locale getLocale() {
        if (TextUtils.isEmpty(sLocale)) {
            sLocale = SharedPreferenceLess.$get(Constant.PREFERENCE_KEY_LOCALE, "");
        }

        if (Locale.ENGLISH.getLanguage().equals(sLocale)) {
            return Locale.ENGLISH;
        } else if (Locale.CHINESE.getLanguage().equals(sLocale)) {
            return Locale.CHINESE;
        } else {
            return Locale.CHINESE;
        }
    }

    public static void setLocale(Locale locale) {
        SharedPreferenceLess.$put(Constant.PREFERENCE_KEY_LOCALE, locale.getLanguage());
        sLocale = locale.getLanguage();
    }

    public static void clearLocale() {
        SharedPreferenceLess.$remove(Constant.PREFERENCE_KEY_LOCALE);
        sLocale = null;
    }

}
