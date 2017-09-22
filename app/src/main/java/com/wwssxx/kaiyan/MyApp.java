package com.wwssxx.kaiyan;

import android.app.Application;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.facebook.stetho.Stetho;
import com.jayfeng.lesscode.core.DisplayLess;
import com.jayfeng.lesscode.headerbar.HeaderBarConfig;
import com.wwssxx.kaiyan.config.Global;
import com.wwssxx.kaiyan.module.greendao.helper.GreenDaoHelper;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Global.setContext(this);
        Stetho.initializeWithDefaults(this);
        GreenDaoHelper.initDatabase();
        initHeaderConfig();
    }

    private void initHeaderConfig() {
        HeaderBarConfig.getInstance()
                // header
                .headerHeight(DisplayLess.$dp2px(48)).headerBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff"))).headerBackIcon(R.drawable.app_back).headerShadowHeight(DisplayLess.$dp2px(16))
                // title
                .titleTextColor(getResources().getColor(R.color.header_title_text_color))
                .titleTextSize(18).subtitleTextColor(Color.RED)
                // item
                .itemTextNormalColor(getResources().getColor(R.color.header_menu_text_normal_color))
                .itemTextPressedColor(getResources().getColor(R.color.header_menu_text_pressed_color))
                .itemTextSize(18).itemTextPadding(DisplayLess.$dp2px(16), 0, DisplayLess.$dp2px(16), 0)
                .itemImagePadding(DisplayLess.$dp2px(8), 0, DisplayLess.$dp2px(8), 0)

                .itemMinWidth(DisplayLess.$dp2px(48))
                // tab
                .tabBottomBackgroundDrawable(new ColorDrawable(Color.parseColor("#1abc9c")))
                // popup
                .popupBackgroundDrawable(new ColorDrawable(Color.parseColor("#1abc9c"))).build();

    }

}
