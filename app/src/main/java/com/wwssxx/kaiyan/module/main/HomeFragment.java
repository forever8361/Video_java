package com.wwssxx.kaiyan.module.main;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jayfeng.lesscode.core.AdapterLess;
import com.jayfeng.lesscode.core.LogLess;
import com.jayfeng.lesscode.core.ViewLess;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.wwssxx.kaiyan.R;
import com.wwssxx.kaiyan.general.GlideImageLoader;
import com.wwssxx.kaiyan.model.SelectdEntiry;
import com.wwssxx.kaiyan.module.video.VideoDetailActivity;
import com.wwssxx.kaiyan.repository.ConfigRepository;
import com.wwssxx.kaiyan.widget.LoadingLayout;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.wwssxx.kaiyan.R.id.refreshLayout;


public class HomeFragment extends Fragment {
    public static final int VIEW_ITEM_VIDEO_INDEX = 0;
    public static final int VIEW_ITEM_TEXT_INDEX = 1;

    public static final int VIEW_ITEM_VIDEO = R.layout.view_home_vedio_list_item;
    public static final int VIEW_ITEM_TEXT = R.layout.view_home_texttype_list_item;

    private RecyclerView mRecyclerView;
    protected RecyclerView.Adapter<AdapterLess.RecyclerViewHolder> mAdapter;
    private LoadingLayout mLoadingView;
    private List<SelectdEntiry.ItemListBean> mListData;
    private RefreshLayout mRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        initView(rootView);
        requestData();
        return rootView;
    }

    private void initView(View view) {
        mListData = new ArrayList<>();
        mRefreshLayout = ViewLess.$(view, refreshLayout);
        mRecyclerView = ViewLess.$(view, R.id.recyclerview);
        mRecyclerView = ViewLess.$(view, R.id.recyclerview);
        mLoadingView = ViewLess.$(view, R.id.loading);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mLoadingView.setStatus(LoadingLayout.Loading);
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000);
            }
        });
        mRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(2000);
            }
        });

    }

    private void requestData() {
        ConfigRepository.getInstance().getTabSelectedData(2)
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
                            LogLess.$d("mListData.size:-------", "=========" + mListData.size());
                            if (mListData.size() > 0) {
                                mLoadingView.setStatus(LoadingLayout.Success);
                                showList();
                            } else {
                                mLoadingView.setStatus(LoadingLayout.Empty);
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (mListData.size() <= 0) {
                            mLoadingView.setStatus(LoadingLayout.No_Network);
                            mLoadingView.setOnReloadListener(new LoadingLayout.OnReloadListener() {
                                @Override
                                public void onReload(View v) {
                                    mLoadingView.setStatus(LoadingLayout.Loading);
                                    requestData();
                                }
                            });
                        }

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


    private void showList() {
        mAdapter = AdapterLess.$recycler(getActivity(), mListData, getHomeItemLayout(), new AdapterLess.FullRecyclerCallBack<SelectdEntiry.ItemListBean>() {


            @Override
            public void onBindViewHolder(int position, AdapterLess.RecyclerViewHolder recyclerViewHolder, SelectdEntiry.ItemListBean itemListBean) {
                if (getItemViewType(position) == VIEW_ITEM_VIDEO_INDEX) {
                    showVideoItemView(recyclerViewHolder, mListData.get(position));
                } else if (getItemViewType(position) == VIEW_ITEM_TEXT_INDEX) {
                    showTextItemView(recyclerViewHolder, mListData.get(position));
                }
            }

            @Override
            public int getItemViewType(int position) {
                return getHomeItemViewType(mListData.get(position));
            }
        });

        mRecyclerView.setAdapter(mAdapter);

    }

    private int getHomeItemViewType(SelectdEntiry.ItemListBean itemListBean) {
        if ("video".equals(itemListBean.getType())) {
            return VIEW_ITEM_VIDEO_INDEX;
        } else {
            return VIEW_ITEM_TEXT_INDEX;
        }

    }

    private void showVideoItemView(AdapterLess.RecyclerViewHolder recyclerViewHolder, final SelectdEntiry.ItemListBean itemListBean) {
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
        GlideImageLoader.displayImageByUrl(getActivity(), feed, imageView);
        titleView.setText(title);
        timeView.setText(category + stringTime);
        //单个的点击事件
        imageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (!"video".equals(itemListBean.getType())) {
                    return;
                }
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), new Pair<View, String>(imageView, VideoDetailActivity.SHARED_ELEMENT_PHOTO));
                Bundle bundle = new Bundle();
                bundle.putSerializable(VideoDetailActivity.KEY_VIDEO, itemListBean);
                Intent intent = new Intent(getActivity(), VideoDetailActivity.class);
                intent.putExtras(bundle);
                ActivityCompat.startActivity(getActivity(), intent, options.toBundle());

            }
        });


    }

    private void showTextItemView(AdapterLess.RecyclerViewHolder recyclerViewHolder, SelectdEntiry.ItemListBean itemListBean) {
        TextView titleView = recyclerViewHolder.$view(R.id.tv_home_text);
        titleView.setVisibility(View.GONE);
//        String text = itemListBean.getData().getText();
//        titleView.setText(text + "dfse");

    }


    private int[] getHomeItemLayout() {
        return new int[]{
                VIEW_ITEM_VIDEO, VIEW_ITEM_TEXT
        };
    }


}
