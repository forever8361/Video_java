package com.wwssxx.kaiyan.module.discover;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wwssxx.kaiyan.R;
import com.wwssxx.kaiyan.base.BaseActivity;

@Route(path = "/test/activity")
public class AuthorAllActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_all);
        initHeaderBar("全部作者", true);
        AuthorFragment authorFragment = new AuthorFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.contentFrame, authorFragment);
        transaction.commit();
    }
}
