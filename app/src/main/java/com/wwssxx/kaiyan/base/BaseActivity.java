package com.wwssxx.kaiyan.base;

import android.os.Build;
import android.view.View;

import com.jaeger.library.StatusBarUtil;
import com.jayfeng.lesscode.core.ViewLess;
import com.jayfeng.lesscode.headerbar.HeaderBar;
import com.wwssxx.kaiyan.R;
import com.wwssxx.kaiyan.utils.StatusBarHelper;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;


public class BaseActivity extends RxAppCompatActivity {
    protected HeaderBar mHeaderBar;

    protected void initHeaderBar(String title, boolean showBack) {
        mHeaderBar = ViewLess.$(this, R.id.headerbar);
        mHeaderBar.setTitle(title);
        mHeaderBar.hideShadow();
        if (showBack) {
            mHeaderBar.showBack(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }
    }

    protected void initHeaderBar(String title, int backResource) {
        mHeaderBar = ViewLess.$(this, R.id.headerbar);
        mHeaderBar.setTitle(title);
        mHeaderBar.hideShadow();
        mHeaderBar.showBack(backResource, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }


    // 设置状态栏透明度
    protected void translateStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        int supportWhiteStatusBar = StatusBarHelper.StatusBarLightMode(this);
        if (supportWhiteStatusBar > 0) {
            StatusBarUtil.setColor(this, getResources().getColor(android.R.color.white), 0);
        } else {
            StatusBarUtil.setColor(this, getResources().getColor(android.R.color.black), 0);
        }
    }


}
