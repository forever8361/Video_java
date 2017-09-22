package com.wwssxx.kaiyan.module.discover;

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
import com.wwssxx.kaiyan.general.GlideImageLoader;
import com.wwssxx.kaiyan.model.PgcsEntiry;
import com.wwssxx.kaiyan.repository.ConfigRepository;
import com.wwssxx.kaiyan.widget.LoadingLayout;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by ruby on 2017/2/27.
 */

public class AuthorFragment extends BaseFragment {
    public static final int TYPE_ITEM_PPCS_BLANKCARD = 0;
    public static final int TYPE_ITEM_PPCS_TEXTHEADER = 1;
    public static final int TYPE_ITEM_PPCS_BRIEFCARD = 2;
    public static final int TYPE_ITEM_PPCS_WITHBRIEF = 3;

    public static final int VIEW_ITEM_BLANKCARD = R.layout.fragment_author_type_blankcard_item;
    public static final int VIEW_ITEM_TEXTHEADER = R.layout.fragment_author_type_textheader_item;
    public static final int VIEW_ITEM_BRIEFCARD = R.layout.fragment_author_type_textheader_item_item;
    public static final int VIEW_ITEM_WITHBRIEF = R.layout.fragment_attention_type_videowithbrief_item;
    private XRecyclerView mRecyclerView;
    protected RecyclerView.Adapter<AdapterLess.RecyclerViewHolder> mAdapter;
    private LoadingLayout mLoadingView;
    private List<PgcsEntiry.ItemListBean> mListData;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_author, container, false);
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
        ConfigRepository.getInstance().getPgcsAllData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PgcsEntiry>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PgcsEntiry pgcsEntiry) {
                        if (pgcsEntiry != null) {
                            mListData = pgcsEntiry.getItemList();
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
        mAdapter = AdapterLess.$recycler(getActivity(), mListData, getHomeItemLayout(), new AdapterLess.FullRecyclerCallBack<PgcsEntiry.ItemListBean>() {


            @Override
            public void onBindViewHolder(int position, AdapterLess.RecyclerViewHolder recyclerViewHolder, PgcsEntiry.ItemListBean itemListBean) {
                if (getItemViewType(position) == TYPE_ITEM_PPCS_BLANKCARD) {
                    showBlankHandItemView(recyclerViewHolder, mListData.get(position));
                } else if (getItemViewType(position) == TYPE_ITEM_PPCS_TEXTHEADER) {
                    showTextHeaderItemView(recyclerViewHolder, mListData.get(position));
                } else if (getItemViewType(position) == TYPE_ITEM_PPCS_BRIEFCARD) {
                    showBriefCardItemView(recyclerViewHolder, mListData.get(position));
                } else if (getItemViewType(position) == TYPE_ITEM_PPCS_WITHBRIEF) {
                    showWithBriefItemView(recyclerViewHolder, mListData.get(position));
                }
            }

            @Override
            public int getItemViewType(int position) {
                return getHomeItemViewType(mListData.get(position));
            }
        });

        mRecyclerView.setAdapter(mAdapter);

    }

    private void showTextHeaderItemView(AdapterLess.RecyclerViewHolder recyclerViewHolder, final PgcsEntiry.ItemListBean itemListBean) {
        TextView titleView = recyclerViewHolder.$view(R.id.tv_textheader_title);
        titleView.setText(itemListBean.getData().getText());
    }

    private void showBriefCardItemView(AdapterLess.RecyclerViewHolder recyclerViewHolder, final PgcsEntiry.ItemListBean itemListBean) {
        RoundedImageView iconView = recyclerViewHolder.$view(R.id.iv);
        TextView titleView = recyclerViewHolder.$view(R.id.tv_header_title);
        TextView descView = recyclerViewHolder.$view(R.id.tv_header_desc);
        titleView.setText(itemListBean.getData().getTitle());
        descView.setText(itemListBean.getData().getDescription());
        GlideImageLoader.displayImageByUrl(getActivity(), itemListBean.getData().getIcon(), iconView);
    }


    private void showBlankHandItemView(AdapterLess.RecyclerViewHolder recyclerViewHolder, PgcsEntiry.ItemListBean itemListBean) {

    }

    private void showWithBriefItemView(AdapterLess.RecyclerViewHolder recyclerViewHolder, final PgcsEntiry.ItemListBean itemListBean) {

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

        mAdapter = AdapterLess.$recycler(getActivity(), itemListBean.getData().getItemList(), R.layout.fragment_attention_type_videowithbrief_item_item, new AdapterLess.RecyclerCallBack<PgcsEntiry.ItemListBean.DataBean.ItemListBeanX>() {

            @Override
            public void onBindViewHolder(int position, AdapterLess.RecyclerViewHolder recyclerViewHolder, PgcsEntiry.ItemListBean.DataBean.ItemListBeanX itemListBeanX) {
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

    private int getHomeItemViewType(PgcsEntiry.ItemListBean itemListBean) {
        if ("blankCard".equals(itemListBean.getType())) {
            return TYPE_ITEM_PPCS_BLANKCARD;
        } else if ("leftAlignTextHeader".equals(itemListBean.getType())) {
            return TYPE_ITEM_PPCS_TEXTHEADER;
        } else if ("briefCard".equals(itemListBean.getType())) {
            return TYPE_ITEM_PPCS_BRIEFCARD;
        } else if ("videoCollectionWithBrief".equals(itemListBean.getType())) {
            return TYPE_ITEM_PPCS_WITHBRIEF;
        }
        return TYPE_ITEM_PPCS_BLANKCARD;
    }

    private int[] getHomeItemLayout() {
        return new int[]{
                VIEW_ITEM_BLANKCARD, VIEW_ITEM_TEXTHEADER, VIEW_ITEM_BRIEFCARD, VIEW_ITEM_WITHBRIEF
        };
    }

}
