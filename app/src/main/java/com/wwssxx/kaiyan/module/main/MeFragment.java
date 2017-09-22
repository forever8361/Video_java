package com.wwssxx.kaiyan.module.main;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wwssxx.kaiyan.R;
import com.wwssxx.kaiyan.base.BaseFragment;
import com.wwssxx.kaiyan.model.SelectdEntiry;

public class MeFragment extends BaseFragment implements View.OnClickListener {
    private View mCacheContainer;
    private SelectdEntiry.ItemListBean mItemListBean;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_me, container, false);
        initView(rootView);
        initListener();
        return rootView;
    }

    private void initView(View rootView) {
        initHeaderBar(rootView,"我的",false);
    }

    private void initListener() {
    }


    @Override
    public void onClick(View view) {
    }


}
