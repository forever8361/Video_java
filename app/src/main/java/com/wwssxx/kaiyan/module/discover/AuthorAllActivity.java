package com.wwssxx.kaiyan.module.discover;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.wwssxx.kaiyan.R;
import com.wwssxx.kaiyan.base.BaseActivity;

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
