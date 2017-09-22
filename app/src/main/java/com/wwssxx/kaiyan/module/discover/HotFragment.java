package com.wwssxx.kaiyan.module.discover;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jayfeng.lesscode.core.AdapterLess;
import com.jayfeng.lesscode.core.ViewLess;
import com.wwssxx.kaiyan.R;
import com.wwssxx.kaiyan.base.BaseFragment;
import com.wwssxx.kaiyan.general.GlideImageLoader;
import com.wwssxx.kaiyan.model.DiscovertoryHotEntiry;
import com.wwssxx.kaiyan.module.video.VideoDetailActivity;
import com.wwssxx.kaiyan.repository.ConfigRepository;
import com.wwssxx.kaiyan.widget.LoadingLayout;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ruby on 2017/2/27.
 */

public class HotFragment extends BaseFragment {
    public static final int TYPE_HOT_HORIZONTAL_INDEX = 0;
    public static final int TYPE_HOT_TEXTHEADER_INDEX = 1;
    public static final int TYPE_HOT_VIDEO_INDEX = 2;
    public static final int TYPE_HOT_SQUARECARD_INDEX = 3;

    public static final int VIEW_ITEM_HOT_HORIZONTAL_INDEX = R.layout.fragment_hot_type_horizontalscrollcard_item;
    public static final int VIEW_ITEM_HOT_TEXTHEADER_INDEX = R.layout.fragment_hot_type_textheader_item;
    public static final int VIEW_ITEM_HOT_VIDEO_INDEX = R.layout.view_home_vedio_list_item;
    public static final int VIEW_ITEM_HOT_SQUARECARDCOLLECTION_INDEX = R.layout.fragment_hot_type_cardcollection;

    private com.jcodecraeer.xrecyclerview.XRecyclerView mRecyclerView;
    private LoadingLayout mLoadingView;
    protected RecyclerView.Adapter<AdapterLess.RecyclerViewHolder> mAdapter;

    private List<DiscovertoryHotEntiry.ItemListBeanX> mListData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_hot, container, false);
        initView(rootView);
        requestData();
        return rootView;
    }

    private void initView(View view) {
        mListData = new ArrayList<>();
        mRecyclerView = ViewLess.$(view, R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mLoadingView = ViewLess.$(view, R.id.loading);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setPullRefreshEnabled(false);
        mLoadingView.setStatus(LoadingLayout.Loading);
    }


    private void requestData() {
        ConfigRepository.getInstance().getDiscovertoryHotData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DiscovertoryHotEntiry>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DiscovertoryHotEntiry discovertoryHotEntiry) {
                        if (discovertoryHotEntiry != null) {
                            mListData = discovertoryHotEntiry.getItemList();
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
        mAdapter = AdapterLess.$recycler(getActivity(), mListData, getHomeItemLayout(), new AdapterLess.FullRecyclerCallBack<DiscovertoryHotEntiry.ItemListBeanX>() {
            @Override
            public void onBindViewHolder(int position, AdapterLess.RecyclerViewHolder recyclerViewHolder, DiscovertoryHotEntiry.ItemListBeanX itemListBean) {
                if (getItemViewType(position) == TYPE_HOT_HORIZONTAL_INDEX) {
                    showHorizontalItemView(recyclerViewHolder, mListData.get(position));
                } else if (getItemViewType(position) == TYPE_HOT_TEXTHEADER_INDEX) {
                    showTextHeaderItemView(recyclerViewHolder, mListData.get(position));
                } else if (getItemViewType(position) == TYPE_HOT_VIDEO_INDEX) {
                    showVideoItemView(recyclerViewHolder, mListData.get(position));
                } else if (getItemViewType(position) == TYPE_HOT_SQUARECARD_INDEX) {
                    showSquareCardItemView(recyclerViewHolder, mListData.get(position));
                }
            }

            @Override
            public int getItemViewType(int position) {
                return getHomeItemViewType(mListData.get(position));
            }
        });

        mRecyclerView.setAdapter(mAdapter);

    }

    private void showHorizontalItemView(AdapterLess.RecyclerViewHolder recyclerViewHolder, final DiscovertoryHotEntiry.ItemListBeanX itemListBean) {
        String imageUrl = itemListBean.getData().getItemList().get(0).getData().getImage();

        final ImageView imageView = recyclerViewHolder.$view(R.id.iv);
        GlideImageLoader.displayImageByUrl(getActivity(), imageUrl, imageView);
        //单个的点击事件
        imageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), NeedleSourcesActivity.class));
            }
        });
    }


    private void showSquareCardItemView(AdapterLess.RecyclerViewHolder recyclerViewHolder, final DiscovertoryHotEntiry.ItemListBeanX itemListBean) {
        RecyclerView mHorizontalRecyclerView = recyclerViewHolder.$view(R.id.recycler_horizontal_view);
        com.wwssxx.kaiyan.widget.ShangshabanChangeTextSpaceView mCardView = recyclerViewHolder.$view(R.id.tv_cardcollection_title);

        LinearLayoutManager layoutManagertwo = new LinearLayoutManager(getActivity());
        layoutManagertwo.setOrientation(LinearLayoutManager.HORIZONTAL);
        mHorizontalRecyclerView.setLayoutManager(layoutManagertwo);
        mCardView.setText(itemListBean.getData().getHeader().getTitle());
        mCardView.setSpacing(10);
        final List<DiscovertoryHotEntiry.ItemListBeanX.DataBeanX.ItemListBean> itemList = itemListBean.getData().getItemList();

        mAdapter = AdapterLess.$recycler(getActivity(), itemList, R.layout.fragment_category_type_cardcollection_item, new AdapterLess.RecyclerCallBack<DiscovertoryHotEntiry.ItemListBeanX.DataBeanX.ItemListBean>() {

            @Override
            public void onBindViewHolder(int position, AdapterLess.RecyclerViewHolder recyclerViewHolder, DiscovertoryHotEntiry.ItemListBeanX.DataBeanX.ItemListBean itemListBeanX2) {
                String imageUrl = itemListBeanX2.getData().getImage();
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

    private void showTextHeaderItemView(AdapterLess.RecyclerViewHolder recyclerViewHolder, final DiscovertoryHotEntiry.ItemListBeanX itemListBean) {
        String text = itemListBean.getData().getText();
        if (!TextUtils.isEmpty(text)) {
            com.wwssxx.kaiyan.widget.ShangshabanChangeTextSpaceView textView = recyclerViewHolder.$view(R.id.tv_textheader_title);
            textView.setText(text);
            textView.setSpacing(10);
            //单个的点击事件
            textView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                }
            });
        }


    }

    private void showVideoItemView(AdapterLess.RecyclerViewHolder recyclerViewHolder, final DiscovertoryHotEntiry.ItemListBeanX itemListBean) {
        String authorName = "";
        String feed = itemListBean.getData().getCover().getFeed();
        String title = itemListBean.getData().getTitle();
        String category = itemListBean.getData().getCategory();
        if (itemListBean.getData().getAuthor() != null) {
            authorName = itemListBean.getData().getAuthor().getName();
        }
        category = "#" + category + "  /  ";

        long duration = itemListBean.getData().getDuration();

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

        final ImageView imageView = recyclerViewHolder.$view(R.id.iv);
        TextView titleView = recyclerViewHolder.$view(R.id.tv_title);
        TextView timeView = recyclerViewHolder.$view(R.id.tv_time);
        TextView tvNameView = recyclerViewHolder.$view(R.id.tv_video_from);
        GlideImageLoader.displayImageByUrl(getActivity(), feed, imageView);
        titleView.setText(title);
        timeView.setText(category + stringTime);
        if (!TextUtils.isEmpty(authorName)) {
            tvNameView.setVisibility(View.VISIBLE);
            tvNameView.setText(authorName);
        }
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


                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), new Pair<View, String>(imageView, VideoDetailActivity.SHARED_ELEMENT_PHOTO));
                Intent intent = new Intent(getActivity(), VideoDetailActivity.class);
                intent.putExtra("time", "#" + itemListBean.getData().getCategory() + " / " + minute + "'" + second + '"');
                intent.putExtra("title", itemListBean.getData().getTitle());
                intent.putExtra("desc", itemListBean.getData().getDescription());//视频描述
                intent.putExtra("blurred", itemListBean.getData().getCover().getBlurred());//模糊图片地址
                intent.putExtra("feed", itemListBean.getData().getCover().getFeed());//图片地址
                intent.putExtra("video", itemListBean.getData().getPlayUrl());//视频播放地址
                intent.putExtra("collect", itemListBean.getData().getConsumption().getCollectionCount());//收藏量
                intent.putExtra("share", itemListBean.getData().getConsumption().getShareCount());//分享量
                intent.putExtra("reply", itemListBean.getData().getConsumption().getReplyCount());//回复数量

               // ActivityCompat.startActivity(getActivity(), intent, options.toBundle());
            }
        });


    }


    private int getHomeItemViewType(DiscovertoryHotEntiry.ItemListBeanX itemListBean) {
        if ("squareCardCollection".equals(itemListBean.getType())) {
            return TYPE_HOT_SQUARECARD_INDEX;
        } else if ("textHeader".equals(itemListBean.getType())) {
            return TYPE_HOT_TEXTHEADER_INDEX;
        } else if ("video".equals(itemListBean.getType())) {
            return TYPE_HOT_VIDEO_INDEX;
        } else if ("horizontalScrollCard".equals(itemListBean.getType())) {
            return TYPE_HOT_HORIZONTAL_INDEX;
        }
        return TYPE_HOT_TEXTHEADER_INDEX;
    }

    private int[] getHomeItemLayout() {
        return new int[]{
                VIEW_ITEM_HOT_HORIZONTAL_INDEX, VIEW_ITEM_HOT_TEXTHEADER_INDEX, VIEW_ITEM_HOT_VIDEO_INDEX, VIEW_ITEM_HOT_SQUARECARDCOLLECTION_INDEX
        };
    }

}
