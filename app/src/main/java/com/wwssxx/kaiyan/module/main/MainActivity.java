package com.wwssxx.kaiyan.module.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.jayfeng.lesscode.core.ViewLess;
import com.wwssxx.kaiyan.R;
import com.wwssxx.kaiyan.base.BaseActivity;

public class MainActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener {
    private static final String TAG_HOME = "home";
    private static final String TAG_DISCOVER = "discover";
    private static final String TAG_ATTENTION = "attention";
    private static final String TAG_ME = "me";

    protected FragmentManager mFragmentManager;
    protected Fragment mCurrentFragment;
    protected Fragment mHomeFragment;
    protected Fragment mAttentionFragment;
    protected Fragment mDiscoverFragment;
    protected Fragment meFragment;

    private RadioButton mHomeTabBtn;
    private RadioButton mAttentionTabBtn;
    private RadioButton mDiscoverTabBtn;
    private RadioButton meTabBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        translateStatusBar();
        initView();
        initListener();
        initFragment(savedInstanceState);
    }


    private void initView() {
        mFragmentManager = getSupportFragmentManager();
        mHomeTabBtn = ViewLess.$(this, R.id.tab_home_btn);
        mAttentionTabBtn = ViewLess.$(this, R.id.tab_conversation_btn);
        mDiscoverTabBtn = ViewLess.$(this, R.id.tab_discover_btn);
        meTabBtn = ViewLess.$(this, R.id.tab_me_btn);
    }

    private void initListener() {
        mHomeTabBtn.setOnCheckedChangeListener(this);
        mAttentionTabBtn.setOnCheckedChangeListener(this);
        mDiscoverTabBtn.setOnCheckedChangeListener(this);
        meTabBtn.setOnCheckedChangeListener(this);
    }


    protected void initFragment(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mCurrentFragment = mHomeFragment = mFragmentManager.findFragmentByTag(TAG_HOME);
            mAttentionFragment = mFragmentManager.findFragmentByTag(TAG_ATTENTION);
            mDiscoverFragment = mFragmentManager.findFragmentByTag(TAG_DISCOVER);
            meFragment = mFragmentManager.findFragmentByTag(TAG_ME);

            if (mCurrentFragment == null) {
                mCurrentFragment = mHomeFragment = new HomeFragment();
            }
            if (mAttentionFragment == null) {
                mAttentionFragment = new AttentionFragment();
            }
            if (mDiscoverFragment == null) {
                mDiscoverFragment = new DiscoverFragment();
            }
            if (meFragment == null) {
                meFragment = new MeFragment();
            }

            mFragmentManager.beginTransaction().hide(mAttentionFragment).hide
                    (mDiscoverFragment).hide(meFragment).show(mCurrentFragment)
                    .commitAllowingStateLoss();
        } else {
            mCurrentFragment = mHomeFragment = new HomeFragment();
            mAttentionFragment = new AttentionFragment();
            mDiscoverFragment = new DiscoverFragment();
            meFragment = new MeFragment();
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragments, mHomeFragment, TAG_HOME)
                    .commitAllowingStateLoss();
        }
    }

    public void changeFrament(Fragment fragment, String fragmentTag) {

        if (fragment == mCurrentFragment) {
            return;
        }

        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentManager.executePendingTransactions();
        if (!fragment.isAdded()) {
            fragmentTransaction.hide(mCurrentFragment).add(R.id.fragments, fragment, fragmentTag)
                    .show(fragment).commitAllowingStateLoss();
        } else {
            fragmentTransaction.hide(mCurrentFragment).show(fragment).commitAllowingStateLoss();
        }
        mCurrentFragment = fragment;

    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            int buttonViewId = buttonView.getId();
            if (buttonViewId == R.id.tab_home_btn) {
                changeFrament(mHomeFragment, TAG_HOME);
            } else if (buttonViewId == R.id.tab_conversation_btn) {
                changeFrament(mAttentionFragment, TAG_ATTENTION);
            } else if (buttonViewId == R.id.tab_discover_btn) {
                changeFrament(mDiscoverFragment, TAG_DISCOVER);
            } else if (buttonViewId == R.id.tab_me_btn) {
                changeFrament(meFragment, TAG_ME);
            }
        }
    }


}
