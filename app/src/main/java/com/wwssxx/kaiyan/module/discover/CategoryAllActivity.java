package com.wwssxx.kaiyan.module.discover;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jayfeng.lesscode.core.AdapterLess;
import com.jayfeng.lesscode.core.DisplayLess;
import com.jayfeng.lesscode.core.ViewLess;
import com.jayfeng.lesscode.core.other.DividerItemDecoration;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wwssxx.kaiyan.R;
import com.wwssxx.kaiyan.base.BaseActivity;
import com.wwssxx.kaiyan.general.GlideImageLoader;
import com.wwssxx.kaiyan.model.CategoryAllEntiry;
import com.wwssxx.kaiyan.repository.ConfigRepository;
import com.wwssxx.kaiyan.widget.LoadingLayout;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class CategoryAllActivity extends BaseActivity {
    public static final int TYPE_ITEM_SQUARECARD_INDEX = 0;
    public static final int TYPE_ITEM_RECTANGLECARD_INDEX = 1;

    public static final int VIEW_ITEM_SQUARECARD = R.layout.view_category_all_squarecard_item;
    public static final int VIEW_ITEM_RECTANGLECARD = R.layout.view_category_all_rectanglecard_item;
    DividerItemDecoration mItemDecoration;

    private XRecyclerView mRecyclerView;
    GridLayoutManager mLayoutManager;
    private List<CategoryAllEntiry.ItemListBean> mListData;
    private FrameLayout.LayoutParams hideMarqueeLayoutParams;
    protected RecyclerView.Adapter<AdapterLess.RecyclerViewHolder> mAdapter;
    private int mSpanCount = 2;
    private LoadingLayout mLoadingView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_all);
        translateStatusBar();
        initView();
        requestData();
    }

    private void initView() {
        mListData = new ArrayList<>();
        initHeaderBar("全部分类", true);
        mRecyclerView = ViewLess.$(this, R.id.recyclerview);
        mLoadingView = ViewLess.$(this, R.id.loading);
        mItemDecoration = new DividerItemDecoration(this, DividerItemDecoration
                .GRID_LIST, new ColorDrawable(Color.TRANSPARENT));
        mItemDecoration.setHeight(DisplayLess.$dp2px(1));
        mItemDecoration.setWidth(DisplayLess.$dp2px(1));
        mRecyclerView.setPullRefreshEnabled(false);
//        hideMarqueeLayoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        hideMarqueeLayoutParams.setMargins(0, DisplayLess.$dp2px(45), 0, 0);
     //   mRecyclerView.setLayoutParams(hideMarqueeLayoutParams);
        mRecyclerView.addItemDecoration(mItemDecoration);
        mLayoutManager = new GridLayoutManager(this, mSpanCount);
        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if ("SquareCard".equals(mListData.get(position).getData().getDataType())) {
                    return mSpanCount;
                } else {
                    return 1;
                }
            }
        });
        mRecyclerView.setLayoutManager(mLayoutManager);
        mLoadingView = ViewLess.$(this,R.id.loading);
        mLoadingView.setStatus(LoadingLayout.Loading);
    }


    private void requestData() {
        ConfigRepository.getInstance().getCategoryAllData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CategoryAllEntiry>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CategoryAllEntiry categoryAllEntiry) {
                        if (categoryAllEntiry != null) {
                            mListData = categoryAllEntiry.getItemList();
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
                        mLoadingView.setStatus(LoadingLayout.No_Network);
                        mLoadingView.setOnReloadListener(new LoadingLayout.OnReloadListener() {
                            @Override
                            public void onReload(View v) {
                                requestData();
                            }
                        });
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private void showList() {
//        mAdapter = AdapterLess.$recycler(this, mListData, getHomeItemLayout(), new AdapterLess.FullRecyclerCallBack<CategoryAllEntiry.ItemListBean>() {
//            @Override
//            public void onBindViewHolder(int position, AdapterLess.RecyclerViewHolder recyclerViewHolder, CategoryAllEntiry.ItemListBean itemListBean) {
//                //if (getItemViewType(position) == TYPE_ITEM_SQUARECARD_INDEX) {
//                    showSquareCardItemView(recyclerViewHolder, mListData.get(position));
//               // }
////                else if (getItemViewType(position) == TYPE_ITEM_RECTANGLECARD_INDEX) {
////                    showRectangleCardItemView(recyclerViewHolder, mListData.get(position));
////                }
//            }
//
//
//            @Override
//            public int getItemViewType(int position) {
//                return getHomeItemViewType(mListData.get(position));
//            }
        mAdapter = AdapterLess.$recycler(this, mListData, R.layout.view_category_all_squarecard_item, new AdapterLess.RecyclerCallBack<CategoryAllEntiry.ItemListBean>() {
            @Override
            public void onBindViewHolder(int position, AdapterLess.RecyclerViewHolder recyclerViewHolder, CategoryAllEntiry.ItemListBean itemListBean) {
                String imageUrl = itemListBean.getData().getImage();
                final ImageView imageView = recyclerViewHolder.$view(R.id.pic);
                TextView textView = recyclerViewHolder.$view(R.id.tv_category);
                textView.setText(itemListBean.getData().getTitle());
                GlideImageLoader.displayImageByUrl(CategoryAllActivity.this, imageUrl, imageView);
                //单个的点击事件
                imageView.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                    }
                });

            }
        });

        mRecyclerView.setAdapter(mAdapter);

    }


    private void showSquareCardItemView(AdapterLess.RecyclerViewHolder recyclerViewHolder, CategoryAllEntiry.ItemListBean itemListBean) {
        String imageUrl = itemListBean.getData().getImage();
        final ImageView imageView = recyclerViewHolder.$view(R.id.pic);
        Glide.with(this)
                .load(imageUrl)
                .centerCrop()
                .crossFade()
                .into(imageView);
        //单个的点击事件
        imageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
            }
        });

    }

    private void showRectangleCardItemView(AdapterLess.RecyclerViewHolder recyclerViewHolder, CategoryAllEntiry.ItemListBean itemListBean) {
        String imageUrl = itemListBean.getData().getImage();
        final ImageView imageView = recyclerViewHolder.$view(R.id.iv);
        Glide.with(this)
                .load(imageUrl)
                .centerCrop()
                .crossFade()
                .into(imageView);
        //单个的点击事件
        imageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
            }
        });

    }

    private int getHomeItemViewType(CategoryAllEntiry.ItemListBean itemListBean) {
        if ("SquareCard".equals(itemListBean.getData().getDataType())) {
            return TYPE_ITEM_SQUARECARD_INDEX;
        } else {
            return TYPE_ITEM_RECTANGLECARD_INDEX;
        }

    }

    private int[] getHomeItemLayout() {
        return new int[]{
                VIEW_ITEM_SQUARECARD, VIEW_ITEM_RECTANGLECARD
        };
    }
}
