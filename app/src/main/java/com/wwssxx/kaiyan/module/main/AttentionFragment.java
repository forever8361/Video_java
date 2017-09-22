package com.wwssxx.kaiyan.module.main;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.jayfeng.lesscode.core.AdapterLess;
import com.jayfeng.lesscode.core.ViewLess;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wwssxx.kaiyan.R;
import com.wwssxx.kaiyan.general.GlideImageLoader;
import com.wwssxx.kaiyan.model.FollowEntiry;
import com.wwssxx.kaiyan.module.discover.AuthorAllActivity;
import com.wwssxx.kaiyan.module.search.SearchActivity;
import com.wwssxx.kaiyan.module.video.VideoDetailActivity;
import com.wwssxx.kaiyan.repository.ConfigRepository;
import com.wwssxx.kaiyan.widget.LoadingLayout;
import com.makeramen.roundedimageview.RoundedImageView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerClickListener;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class AttentionFragment extends Fragment implements View.OnClickListener {
    public static final int TYPE_ITEM_VIDEO_WITHBRIEF_INDEX = 0;
    public static final int TYPE_ITEM_VIDEO_SCROLLCARDINDEX = 1;

    public static final int VIEW_ITEM_WITHBRIEF = R.layout.fragment_attention_type_videowithbrief_item;
    public static final int VIEW_ITEM_SCROLLCARDINDEX = R.layout.fragment_attention_type_scrollcard_item;
    private XRecyclerView mRecyclerView;
    protected RecyclerView.Adapter<AdapterLess.RecyclerViewHolder> mAdapter;
    private ImageButton mImageButtonView;
    private TextView mToobarLeftView;
    private LoadingLayout mLoadingView;
    private List<FollowEntiry.ItemListBeanX> mListData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_attention, container, false);
        initView(rootView);
        initListener();
        requestData();
        return rootView;
    }

    private void initView(View view) {
        mListData = new ArrayList<>();
        mRecyclerView = ViewLess.$(view, R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mImageButtonView = ViewLess.$(view, R.id.main_toolbar_iv_right);
        mToobarLeftView = ViewLess.$(view, R.id.toobar_left_tv);
        mLoadingView = ViewLess.$(view, R.id.loading);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setPullRefreshEnabled(false);
        mLoadingView.setStatus(LoadingLayout.Loading);
    }

    private void initListener() {
        mImageButtonView.setOnClickListener(this);
        mToobarLeftView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mImageButtonView) {
            Intent intent = new Intent(getActivity(), SearchActivity.class);
            startActivity(intent);
            getActivity().overridePendingTransition(R.anim.activity_open,0);
        } else if (view == mToobarLeftView) {
            startActivity(new Intent(getActivity(), AuthorAllActivity.class));
        }
    }

    private void requestData() {
        ConfigRepository.getInstance().getfollowData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FollowEntiry>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FollowEntiry followEntiry) {
                        if (followEntiry != null) {
                            mListData = followEntiry.getItemList();
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
        mAdapter = AdapterLess.$recycler(getActivity(), mListData, getHomeItemLayout(), new AdapterLess.FullRecyclerCallBack<FollowEntiry.ItemListBeanX>() {


            @Override
            public void onBindViewHolder(int position, AdapterLess.RecyclerViewHolder recyclerViewHolder, FollowEntiry.ItemListBeanX itemListBean) {
                if (getItemViewType(position) == TYPE_ITEM_VIDEO_WITHBRIEF_INDEX) {
                    showWithBriefItemView(recyclerViewHolder, mListData.get(position));
                } else if (getItemViewType(position) == TYPE_ITEM_VIDEO_SCROLLCARDINDEX) {
                    showScrollCardItemView(recyclerViewHolder, mListData.get(position));
                }
            }

            @Override
            public int getItemViewType(int position) {
                return getHomeItemViewType(mListData.get(position));
            }
        });

        mRecyclerView.setAdapter(mAdapter);

    }


    private void showWithBriefItemView(AdapterLess.RecyclerViewHolder recyclerViewHolder, final FollowEntiry.ItemListBeanX itemListBean) {

        RoundedImageView iconView = recyclerViewHolder.$view(R.id.iv);
        TextView titleView = recyclerViewHolder.$view(R.id.tv_header_title);
        TextView descView = recyclerViewHolder.$view(R.id.tv_header_desc);
        titleView.setText(itemListBean.getData().getHeader().getTitle());
        descView.setText(itemListBean.getData().getHeader().getDescription());
        GlideImageLoader.displayImageByUrl(getActivity(), itemListBean.getData().getHeader().getIcon(), iconView);

        RecyclerView mHorizontalRecyclerView = recyclerViewHolder.$view(R.id.recyclerview);
        LinearLayoutManager layoutManagertwo = new LinearLayoutManager(getActivity());
        layoutManagertwo.setOrientation(LinearLayoutManager.HORIZONTAL);
        mHorizontalRecyclerView.setLayoutManager(layoutManagertwo);

        mAdapter = AdapterLess.$recycler(getActivity(), itemListBean.getData().getItemList(), R.layout.fragment_attention_type_videowithbrief_item_item, new AdapterLess.RecyclerCallBack<FollowEntiry.ItemListBeanX.DataBeanX.ItemListBean>() {

            @Override
            public void onBindViewHolder(int position, AdapterLess.RecyclerViewHolder recyclerViewHolder, FollowEntiry.ItemListBeanX.DataBeanX.ItemListBean itemListBeanX) {
                ImageView imageView = recyclerViewHolder.$view(R.id.iv_data_item_cover);
                TextView titleView = recyclerViewHolder.$view(R.id.tv_data_item_title);
                TextView categoryView = recyclerViewHolder.$view(R.id.tv_data_item_category);
                String imageUrl = itemListBeanX.getData().getCover().getFeed();
                titleView.setText(itemListBeanX.getData().getTitle());
                GlideImageLoader.displayImageByUrl(getActivity(), imageUrl, imageView);
                String category = itemListBeanX.getData().getCategory();
                category = "#" + category + "  /  ";

                long duration = itemListBeanX.getData().getDuration();

                long last = duration % 60;
                String stringLast;
                if (last <= 9) {
                    stringLast = "0" + last;
                } else {
                    stringLast = last + "";
                }

                String durationString;
                long minit = duration / 60;
                if (minit < 10) {
                    durationString = "0" + minit;

                } else {
                    durationString = "" + minit;

                }
                String stringTime = durationString + "' " + stringLast + '"';
                categoryView.setText(category + stringTime);
            }
        });

        mHorizontalRecyclerView.setAdapter(mAdapter);

    }

    private void showScrollCardItemView(AdapterLess.RecyclerViewHolder recyclerViewHolder, final FollowEntiry.ItemListBeanX itemListBean) {
        String itemTitle = itemListBean.getData().getHeader().getTitle();
        String itemSubTitle = (String) itemListBean.getData().getHeader().getSubTitle();
        List<FollowEntiry.ItemListBeanX.DataBeanX.ItemListBean> itemList =
                itemListBean.getData().getItemList();
        ArrayList<String> bannerItemTitleList = new ArrayList<>();
        ArrayList<String> bannerItemTimeList = new ArrayList<>();
        ArrayList<String> bannerItemimageUrlList = new ArrayList<>();

        for (int i = 0; i < itemList.size(); i++) {
            bannerItemTitleList.add(itemList.get(i).getData().getTitle());

            bannerItemimageUrlList.add(itemList.get(i).getData().getCover().getFeed());
            String category = itemListBean.getData().getHeader().getTitle();
            category = "#" + category + "  /  ";

            long duration = itemListBean.getData().getItemList().get(0).getData().getDuration();

            long last = duration % 60;
            String stringLast;
            if (last <= 9) {
                stringLast = "0" + last;
            } else {
                stringLast = last + "";
            }

            String durationString;
            long minit = duration / 60;
            if (minit < 10) {
                durationString = "0" + minit;

            } else {
                durationString = "" + minit;

            }
            String stringTime = durationString + "' " + stringLast + '"';
            bannerItemTimeList.add(category + stringTime);
        }
        TextView categoryView = recyclerViewHolder.$view(R.id.tv_category);
        TextView subTitleView = recyclerViewHolder.$view(R.id.tv_subtitle);
        Banner banner = recyclerViewHolder.$view(R.id.banner);
        banner.setBannerTitles(bannerItemTitleList);
        banner.setBannerSubTitles(bannerItemTimeList);

        categoryView.setText(itemTitle);
        subTitleView.setText(itemSubTitle);
        banner.setBannerTitles(bannerItemTitleList);
        banner.rlCustomView.setVisibility(View.VISIBLE);
        banner.setBannerSubTitles(bannerItemTimeList);
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(bannerItemimageUrlList);
        banner.isAutoPlay(false);
        banner.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void OnBannerClick(int position) {

                if (!"video".equals(itemListBean.getData().getItemList().get(position - 1).getType())) {
                    return;
                }
                //  bundle.putString("title", itemListBean.getData().getTitle());
                //获取到时间
                int duration = itemListBean.getData().getItemList().get(position - 1).getData().getDuration();
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
                Intent intent = new Intent(getActivity(), VideoDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("time", "#" + itemListBean.getData().getItemList().get(position - 1).getData().getCategory() + " / " + minute + "'" + second + '"');
                bundle.putString("title", itemListBean.getData().getItemList().get(position - 1).getData().getTitle());
                bundle.putString("desc", itemListBean.getData().getItemList().get(position - 1).getData().getDescription());//视频描述
                bundle.putString("blurred", itemListBean.getData().getItemList().get(position - 1).getData().getCover().getBlurred());//模糊图片地址
                bundle.putString("feed", itemListBean.getData().getItemList().get(position - 1).getData().getCover().getFeed());//图片地址
                bundle.putString("video", itemListBean.getData().getItemList().get(position - 1).getData().getPlayUrl());//视频播放地址
                bundle.putInt("collect", itemListBean.getData().getItemList().get(position - 1).getData().getConsumption().getCollectionCount());//收藏量
                bundle.putInt("share", itemListBean.getData().getItemList().get(position - 1).getData().getConsumption().getShareCount());//分享量
                bundle.putInt("reply", itemListBean.getData().getItemList().get(position - 1).getData().getConsumption().getReplyCount());//回复数量
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
        // banner设置方法全部调用完毕时最后调用
        banner.start();
    }


    private int getHomeItemViewType(FollowEntiry.ItemListBeanX itemListBean) {
        if ("videoCollectionWithBrief".equals(itemListBean.getType())) {
            return TYPE_ITEM_VIDEO_WITHBRIEF_INDEX;
        } else if ("videoCollectionOfHorizontalScrollCard".equals(itemListBean.getType())) {
            return TYPE_ITEM_VIDEO_SCROLLCARDINDEX;
        }
        return TYPE_ITEM_VIDEO_WITHBRIEF_INDEX;
    }

    private int[] getHomeItemLayout() {
        return new int[]{
                VIEW_ITEM_WITHBRIEF, VIEW_ITEM_SCROLLCARDINDEX
        };
    }

}
