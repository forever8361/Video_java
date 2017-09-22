package com.wwssxx.kaiyan.base;

import android.view.View;

import com.jayfeng.lesscode.core.ViewLess;
import com.jayfeng.lesscode.headerbar.HeaderBar;
import com.wwssxx.kaiyan.R;
import com.trello.rxlifecycle2.components.support.RxFragment;

public class BaseFragment extends RxFragment {
    protected HeaderBar mHeaderBar;
    protected void initHeaderBar(View rootView, String title, boolean showBack) {
        mHeaderBar = ViewLess.$(rootView, R.id.headerbar);
        mHeaderBar.setTitle(title);
        mHeaderBar.hideShadow();
        if (showBack) {
            mHeaderBar.showBack(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().onBackPressed();
                }
            });
        }
    }

    protected void initHeaderBar(View rootView, String title, int backResource) {
        mHeaderBar = ViewLess.$(rootView, R.id.headerbar);
        mHeaderBar.setTitle(title);
        mHeaderBar.hideShadow();
        mHeaderBar.showBack(backResource, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
    }
}