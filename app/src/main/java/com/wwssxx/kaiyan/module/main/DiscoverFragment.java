package com.wwssxx.kaiyan.module.main;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.flyco.tablayout.SlidingTabLayout;
import com.jayfeng.lesscode.core.AdapterLess;
import com.jayfeng.lesscode.core.ViewLess;
import com.wwssxx.kaiyan.R;
import com.wwssxx.kaiyan.config.Api;
import com.wwssxx.kaiyan.model.DiscovertoryEntiry;
import com.wwssxx.kaiyan.module.discover.AuthorFragment;
import com.wwssxx.kaiyan.module.discover.CategoryAllActivity;
import com.wwssxx.kaiyan.module.discover.CategoryFragment;
import com.wwssxx.kaiyan.module.discover.HotFragment;
import com.wwssxx.kaiyan.module.search.SearchActivity;
import com.wwssxx.kaiyan.repository.ConfigRepository;
import com.wwssxx.kaiyan.widget.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DiscoverFragment extends Fragment implements View.OnClickListener {
    public static final int TAB_POS_HOT = 0;
    public static final int TAB_POS_CATEGORY = 1;
    public static final int TAB_POS_AUTHOR = 2;

    private FragmentManager mFragmentManager;

    private SlidingTabLayout mTabs;
    private RelativeLayout mTabsView;
    private NoScrollViewPager mViewPager;
    private FragmentPagerAdapter mFragmentPagerAdapter;
    private ImageButton mImageButtonView;
    private TextView mToobarLeftView;
    private ArrayList<String> mTabTitleArray;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_discovertory, container, false);
        init(rootView);
        initListener();
        requestData();
        return rootView;
    }

    private void init(View view) {
        mFragmentManager = getChildFragmentManager();
        mTabs = ViewLess.$(view, R.id.tabs);
        mTabsView = ViewLess.$(view, R.id.tabs_container);
        mViewPager = ViewLess.$(view, R.id.viewpager_discovery);
        mImageButtonView = ViewLess.$(view, R.id.main_toolbar_iv_right);
        mToobarLeftView = ViewLess.$(view, R.id.toobar_left_tv);
        mViewPager.setOffscreenPageLimit(10);
        mTabTitleArray = new ArrayList<>();
    }

    private void initListener() {
        mImageButtonView.setOnClickListener(this);
        mToobarLeftView.setOnClickListener(this);
    }


    private void initTabsTitle() {
        mFragmentPagerAdapter = AdapterLess.$pager(mFragmentManager, 3, new AdapterLess.FullFragmentPagerCallBack() {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                switch (position) {
                    case TAB_POS_HOT:
                        fragment = new HotFragment();
                        break;
                    case TAB_POS_CATEGORY:
                        fragment = new CategoryFragment();
                        break;
                    case TAB_POS_AUTHOR:
                        fragment = new AuthorFragment();
                        break;
                }
                return fragment;
            }

            @Override
            public String getPageTitle(int position) {
                return mTabTitleArray.get(position);
            }
        });
        mViewPager.setAdapter(mFragmentPagerAdapter);
        mTabs.setViewPager(mViewPager);

    }


    private void requestData() {
        ConfigRepository.getInstance().getDiscovertoryData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DiscovertoryEntiry>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DiscovertoryEntiry discovertoryEntiry) {
                        if (discovertoryEntiry != null) {
                            mTabsView.setVisibility(View.VISIBLE);
                            List<DiscovertoryEntiry.TabInfoBean.TabListBean> tabList = discovertoryEntiry.getTabInfo().getTabList();
                            mTabTitleArray.clear();
                            mTabTitleArray.add(tabList.get(0).getName());
                            mTabTitleArray.add(tabList.get(1).getName());
                            mTabTitleArray.add(tabList.get(2).getName());
                            Api.sDiscoveryHotUrl = tabList.get(0).getApiUrl();
                            Api.sDiscoveryCategoryUrl = tabList.get(1).getApiUrl();
                            Api.sDiscoveryPgcsAllUrl = tabList.get(2).getApiUrl();
                            initTabsTitle();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        mTabsView.setVisibility(View.GONE);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View view) {
        if (view == mImageButtonView) {
            Intent intent = new Intent(getActivity(), SearchActivity.class);
            startActivity(intent);
            getActivity().overridePendingTransition(R.anim.activity_open,0);

        } else if (view == mToobarLeftView) {
            startActivity(new Intent(getActivity(), CategoryAllActivity.class));
        }
    }
}
