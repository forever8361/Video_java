package com.wwssxx.kaiyan.module.discover;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jayfeng.lesscode.core.AdapterLess;
import com.jayfeng.lesscode.core.ViewLess;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wwssxx.kaiyan.R;
import com.wwssxx.kaiyan.base.BaseFragment;
import com.wwssxx.kaiyan.common.WebviewActivity;
import com.wwssxx.kaiyan.config.Api;
import com.wwssxx.kaiyan.general.GlideImageLoader;
import com.wwssxx.kaiyan.model.DiscovertoryCategoryEntiry;
import com.wwssxx.kaiyan.module.video.VideoDetailActivity;
import com.wwssxx.kaiyan.repository.ConfigRepository;
import com.wwssxx.kaiyan.widget.LoadingLayout;
import com.wwssxx.kaiyan.widget.ShangshabanChangeTextSpaceView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerClickListener;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ruby on 2017/2/27.
 */

public class CategoryFragment extends BaseFragment {
    public static final int TYPE_CATEGORY_BANNER_INDEX = 0;
    public static final int TYPE_CATEGORY_OTHER_INDEX = 1;
    public static final int TYPE_CATEGORY_TEXT_INDEX = 2;

    public static final int VIEW_ITEM_BANNER_CATEGORY_INDEX = R.layout.fragment_category_type_banner_item;
    public static final int VIEW_ITEM_BANNER_OTHER_INDEX = R.layout.fragment_category_type_banner_item;
    public static final int VIEW_ITEM_BANNER_TEXT_INDEX = R.layout.fragment_category_type_cardcollection;
    private XRecyclerView mRecyclerView;
    private RecyclerView mHorizontalRecyclerView;
    private ShangshabanChangeTextSpaceView mCardView;
    protected RecyclerView.Adapter<AdapterLess.RecyclerViewHolder> mAdapter;
    private LoadingLayout mLoadingView;
    private List<DiscovertoryCategoryEntiry.ItemListBeanX> mListData;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_category, container, false);
        initView(rootView);
        requestData();
        return rootView;


    }

    private void initView(View view) {
        mListData = new ArrayList<>();
        mRecyclerView = ViewLess.$(view, R.id.recyclerview);
        mLoadingView = ViewLess.$(view, R.id.loading);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setPullRefreshEnabled(false);
        mLoadingView.setStatus(LoadingLayout.Loading);
    }


    private void requestData() {
        ConfigRepository.getInstance().getDiscovertoryCategoryData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DiscovertoryCategoryEntiry>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DiscovertoryCategoryEntiry discovertoryCategoryEntiry) {
                        if (discovertoryCategoryEntiry != null) {
                            mListData=discovertoryCategoryEntiry.getItemList();
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
        mAdapter = AdapterLess.$recycler(getActivity(), mListData, getHomeItemLayout(), new AdapterLess.FullRecyclerCallBack<DiscovertoryCategoryEntiry.ItemListBeanX>() {


            @Override
            public void onBindViewHolder(int position, AdapterLess.RecyclerViewHolder recyclerViewHolder, DiscovertoryCategoryEntiry.ItemListBeanX itemListBean) {
                if (getItemViewType(position) == TYPE_CATEGORY_BANNER_INDEX) {
                    showBannerItemView(recyclerViewHolder, mListData.get(position));
                } else if (getItemViewType(position) == TYPE_CATEGORY_OTHER_INDEX) {
                    showOtherHeaderItemView(recyclerViewHolder, mListData.get(position));
                } else if (getItemViewType(position) == TYPE_CATEGORY_TEXT_INDEX) {
                    showTextHeaderItemView(recyclerViewHolder, mListData.get(position));
                }
            }

            @Override
            public int getItemViewType(int position) {
                return getHomeItemViewType(mListData.get(position));
            }
        });

        mRecyclerView.setAdapter(mAdapter);

    }

    private void showOtherHeaderItemView(AdapterLess.RecyclerViewHolder recyclerViewHolder, final DiscovertoryCategoryEntiry.ItemListBeanX itemListBean) {
        String itemTitle = itemListBean.getData().getHeader().getTitle();
        List<DiscovertoryCategoryEntiry.ItemListBeanX.DataBeanX.ItemListBean> itemList =
                itemListBean.getData().getItemList();
        ArrayList<String> bannerItemimageUrlList = new ArrayList<>();
        for (int i = 0; i < itemList.size(); i++) {
            bannerItemimageUrlList.add(itemList.get(i).getData().getImage());
        }
        ShangshabanChangeTextSpaceView categoryView = recyclerViewHolder.$view(R.id.tv_category);
        TextView subTitleView = recyclerViewHolder.$view(R.id.tv_subtitle);
        categoryView.setText(itemTitle);
        categoryView.setSpacing(10);
        subTitleView.setVisibility(View.GONE);

        Banner banner = recyclerViewHolder.$view(R.id.banner);
        banner.rlCustomView.setVisibility(View.GONE);
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(bannerItemimageUrlList);
        banner.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void OnBannerClick(int position) {
                Intent intent = new Intent(getActivity(), WebviewActivity.class);
                intent.putExtra(WebviewActivity.WEBVIEW_URL, Api.sShareUrl);
                intent.putExtra(WebviewActivity.WEBVIEW_TITLE, "dsaery");
                startActivity(intent);

            }
        });
        // banner设置方法全部调用完毕时最后调用
        banner.start();

    }

    private void showTextHeaderItemView(AdapterLess.RecyclerViewHolder recyclerViewHolder, final DiscovertoryCategoryEntiry.ItemListBeanX itemListBean) {

        RecyclerView mHorizontalRecyclerView = recyclerViewHolder.$view(R.id.recycler_horizontal_view);
        mCardView = recyclerViewHolder.$view(R.id.tv_cardcollection_title);

        LinearLayoutManager layoutManagertwo = new LinearLayoutManager(getActivity());
        layoutManagertwo.setOrientation(LinearLayoutManager.HORIZONTAL);
        mHorizontalRecyclerView.setLayoutManager(layoutManagertwo);
        mCardView.setText(itemListBean.getData().getHeader().getTitle());
        mCardView.setSpacing(10);
        mAdapter = AdapterLess.$recycler(getActivity(), mListData, R.layout.fragment_category_type_cardcollection_item, new AdapterLess.RecyclerCallBack<DiscovertoryCategoryEntiry.ItemListBeanX>() {

            @Override
            public void onBindViewHolder(int position, AdapterLess.RecyclerViewHolder recyclerViewHolder, DiscovertoryCategoryEntiry.ItemListBeanX itemListBeanX) {
                String imageUrl = itemListBean.getData().getItemList().get(position).getData().getImage();
                ImageView imageView = recyclerViewHolder.$view(R.id.image);
                TextView titleView = recyclerViewHolder.$view(R.id.tv_collection_category);
                titleView.setText(itemListBean.getData().getItemList().get(position).getData().getTitle());
                if (position == (itemListBean.getData().getItemList().size() - 1)) {
                    titleView.setText(itemListBean.getData().getItemList().get(position).getData().getText());
                    titleView.setTextColor(getResources().getColor(R.color.colorGray));
                }
                GlideImageLoader.displayImageByUrl(getActivity(), imageUrl, imageView);
            }
        });

        mHorizontalRecyclerView.setAdapter(mAdapter);

    }


    private void showBannerItemView(AdapterLess.RecyclerViewHolder recyclerViewHolder, final DiscovertoryCategoryEntiry.ItemListBeanX itemListBean) {
        String itemTitle = itemListBean.getData().getHeader().getTitle();
        String itemSubTitle = itemListBean.getData().getHeader().getSubTitle();
        List<DiscovertoryCategoryEntiry.ItemListBeanX.DataBeanX.ItemListBean> itemList =
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
        ShangshabanChangeTextSpaceView categoryView = recyclerViewHolder.$view(R.id.tv_category);
        TextView subTitleView = recyclerViewHolder.$view(R.id.tv_subtitle);
        Banner banner = recyclerViewHolder.$view(R.id.banner);
        banner.setBannerTitles(bannerItemTitleList);
        banner.setBannerSubTitles(bannerItemTimeList);

        categoryView.setText(itemTitle);
        categoryView.setSpacing(10);
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

    private int getHomeItemViewType(DiscovertoryCategoryEntiry.ItemListBeanX itemListBean) {
        if ("videoCollectionOfHorizontalScrollCard".equals(itemListBean.getType())) {
            return TYPE_CATEGORY_BANNER_INDEX;
        } else if ("bannerCollection".equals(itemListBean.getType())) {
            return TYPE_CATEGORY_OTHER_INDEX;
        } else if ("squareCardCollection".equals(itemListBean.getType())) {
            return TYPE_CATEGORY_TEXT_INDEX;
        }
        return TYPE_CATEGORY_TEXT_INDEX;
    }

    private int[] getHomeItemLayout() {
        return new int[]{
                VIEW_ITEM_BANNER_CATEGORY_INDEX, VIEW_ITEM_BANNER_OTHER_INDEX, VIEW_ITEM_BANNER_TEXT_INDEX
        };
    }
}
