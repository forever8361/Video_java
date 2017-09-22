package com.wwssxx.kaiyan.module.search;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.transition.Slide;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jayfeng.lesscode.core.AdapterLess;
import com.jayfeng.lesscode.core.DisplayLess;
import com.jayfeng.lesscode.core.ViewLess;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wwssxx.kaiyan.R;
import com.wwssxx.kaiyan.base.BaseActivity;
import com.wwssxx.kaiyan.model.SelectdEntiry;
import com.wwssxx.kaiyan.module.video.VideoDetailActivity;
import com.wwssxx.kaiyan.repository.ConfigRepository;

import org.apmem.tools.layouts.FlowLayout;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SearchActivity extends BaseActivity {
    private FlowLayout mFlowLayout;
    private View mSearchHotLayout;
    private View mSearchResultLayout;
    private XRecyclerView mXRecyclerView;
    private TextView mCancleView;
    private ImageView mIvDeleteView;
    private EditText mEtSearchView;
    private TextView mTvResultCountView;
    private List<SelectdEntiry.ItemListBean> mListData;
    protected RecyclerView.Adapter<AdapterLess.RecyclerViewHolder> mAdapter;
    private Slide mExplodeAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        translateStatusBar();
        initView();
        initListener();
        showSearchHotView();
        requestData();
    }

    private void initView() {
        mListData = new ArrayList<>();
        mFlowLayout = ViewLess.$(this, R.id.rl_flowLayout);
        mSearchHotLayout = ViewLess.$(this, R.id.ll_search_hot);
        mSearchResultLayout = ViewLess.$(this, R.id.ll_search_reasult);
        mXRecyclerView = ViewLess.$(this, R.id.recyclerview);
        mCancleView = ViewLess.$(this, R.id.tv_cancle);
        mIvDeleteView = ViewLess.$(this, R.id.iv_delete);
        mEtSearchView = ViewLess.$(this, R.id.et_search);
        mTvResultCountView = ViewLess.$(this, R.id.tv_result_count);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mXRecyclerView.setLayoutManager(layoutManager);
        mXRecyclerView.setPullRefreshEnabled(false);
    }

    private void initListener() {
        mCancleView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(0, R.anim.activity_close);
            }
        });
        mIvDeleteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEtSearchView.setText("");
            }
        });
        mEtSearchView.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    mIvDeleteView.setVisibility(View.GONE);
                } else {
                    mIvDeleteView.setVisibility(View.VISIBLE);
                }


            }
        });
    }

    private void requestData() {
        ConfigRepository.getInstance().getSearthHotData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String[]>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String[] searchHotArray) {
                        mFlowLayout.removeAllViews();
                        if (searchHotArray != null) {
                            for (int i = 0; i < searchHotArray.length; i++) {
                                View mLinearlayout = View.inflate(SearchActivity.this, R.layout.view_search_hot, null);
                                final TextView textView = (TextView) mLinearlayout.findViewById(R.id.tv_search_hot);
                                mLinearlayout.setPadding(0, DisplayLess.$dp2px(0), DisplayLess.$dp2px(10), DisplayLess.$dp2px(0));
                                textView.setText((String) searchHotArray[i]);
                                mFlowLayout.addView(mLinearlayout);
                                textView.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(SearchActivity.this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                                        showSearchReasultView();
                                        requestSearchResultData(textView.getText().toString());
                                    }

                                });
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


    private void showResultData() {
        mTvResultCountView.setText("— 搜索结果共" + mListData.size() + "个 —");
        mAdapter = AdapterLess.$recycler(this, mListData, R.layout.view_home_vedio_list_item, new AdapterLess.RecyclerCallBack<SelectdEntiry.ItemListBean>() {
            @Override
            public void onBindViewHolder(int position, AdapterLess.RecyclerViewHolder recyclerViewHolder, final SelectdEntiry.ItemListBean itemListBean) {
                if (!itemListBean.getType().equals("video")) {
                    return;
                }
                String feed = itemListBean.getData().getCover().getFeed();
                String title = itemListBean.getData().getTitle();
                String category = itemListBean.getData().getCategory();
                category = "#" + category + "  /  ";

                int duration = itemListBean.getData().getDuration();

                int last = duration % 60;
                String stringLast;
                if (last <= 9) {
                    stringLast = "0" + last;
                } else {
                    stringLast = last + "";
                }

                String durationString;
                int minit = duration / 60;
                if (minit < 10) {
                    durationString = "0" + minit;

                } else {
                    durationString = "" + minit;

                }
                String stringTime = durationString + "' " + stringLast + '"';

                final ImageView imageView = recyclerViewHolder.$view(R.id.iv);
                TextView titleView = recyclerViewHolder.$view(R.id.tv_title);
                TextView timeView = recyclerViewHolder.$view(R.id.tv_time);
                Glide.with(SearchActivity.this)
                        .load(feed)
                        .centerCrop()
                        .crossFade()
                        .into(imageView);
                titleView.setText(title);
                timeView.setText(category + stringTime);
                //单个的点击事件
                imageView.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        if (!"video".equals(itemListBean.getType())) {
                            return;
                        }
                        //获取到时间
                        int duration = itemListBean.getData().getDuration();
                        int mm = duration / 60;//分
                        int ss = duration % 60;//秒
                        String second = "";//秒
                        String minute = "";//分
                        if (ss < 10) {
                            second = "0" + String.valueOf(ss);
                        } else {
                            second = String.valueOf(ss);
                        }
                        if (mm < 10) {
                            minute = "0" + String.valueOf(mm);
                        } else {
                            minute = String.valueOf(mm);//分钟
                        }


                        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(SearchActivity.this, new Pair<View, String>(imageView, VideoDetailActivity.SHARED_ELEMENT_PHOTO));
                        Intent intent = new Intent(SearchActivity.this, VideoDetailActivity.class);
                        intent.putExtra("time", "#" + itemListBean.getData().getCategory() + " / " + minute + "'" + second + '"');
                        intent.putExtra("title", itemListBean.getData().getTitle());
                        intent.putExtra("desc", itemListBean.getData().getDescription());//视频描述
                        intent.putExtra("blurred", itemListBean.getData().getCover().getBlurred());//模糊图片地址
                        intent.putExtra("feed", itemListBean.getData().getCover().getFeed());//图片地址
                        intent.putExtra("video", itemListBean.getData().getPlayUrl());//视频播放地址
                        intent.putExtra("collect", itemListBean.getData().getConsumption().getCollectionCount());//收藏量
                        intent.putExtra("share", itemListBean.getData().getConsumption().getShareCount());//分享量
                        intent.putExtra("reply", itemListBean.getData().getConsumption().getReplyCount());//回复数量

                        ActivityCompat.startActivity(SearchActivity.this, intent, options.toBundle());
                    }
                });


            }
        });

        mXRecyclerView.setAdapter(mAdapter);
    }


    private void requestSearchResultData(String s) {
        ConfigRepository.getInstance().getSearchResultData(s)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SelectdEntiry>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SelectdEntiry kaiYanSelectdEntiry) {
                        if (kaiYanSelectdEntiry != null) {
                            mListData = kaiYanSelectdEntiry.getItemList();
                            showResultData();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    public void showSearchHotView() {
        if (mSearchHotLayout != null) {
            mSearchResultLayout.setVisibility(View.GONE);
            mSearchHotLayout.setVisibility(View.VISIBLE);
        }
    }


    public void showSearchReasultView() {
        if (mSearchResultLayout != null) {
            mSearchHotLayout.setVisibility(View.GONE);
            mSearchResultLayout.setVisibility(View.VISIBLE);
        }
    }
}
