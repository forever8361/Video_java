package com.wwssxx.kaiyan.module.video;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jayfeng.lesscode.core.ViewLess;
import com.wwssxx.kaiyan.R;
import com.wwssxx.kaiyan.base.BaseActivity;
import com.wwssxx.kaiyan.general.GlideImageLoader;
import com.wwssxx.kaiyan.model.SelectdEntiry;
import com.wwssxx.kaiyan.model.modelforvideo.Cover;
import com.wwssxx.kaiyan.model.modelforvideo.Video;
import com.wwssxx.kaiyan.module.greendao.helper.GreenDaoHelper;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class VideoDetailActivity extends BaseActivity implements View.OnClickListener {
    public static final String KEY_ALBUM_URL = "image_url";
    public static final String SHARED_ELEMENT_PHOTO = "shared_element_photo";
    public static final String KEY_VIDEO = "key_video";
    public static final String KEY_VIDEO_FOR_DB = "key_video_for_db";

    ImageButton mVideoToolbarIv;
    Toolbar mVideoToolbar;
 //  ImageView mVideoDetailIv;
   // ImageView mVideoPaly;
    ImageView mVideoDetailIvmo;
    TextView mVideoDetailTitle;
    TextView mVideoDetailTime;
    TextView mVideoDetailDesc;
    ImageView mVideoDetailIvFav;
    TextView mVideoDetailTvFav;
    ImageView mVideoDetailIvShare;
    TextView mVideoDetailTvShare;
    ImageView mVideoDetailIvReply;
    ImageView mIvBackView;
    TextView mVideoDetailTvReply;
    ImageView mVideoDetailIvDown;
    TextView mVideoDetailTvDown;
    private String mVideoStr;
    private String mTitleStr;
    private String mCategory;
    private String mFeed;
    private String mDesc;
    private String mBlurred;
    private int mCollect;
    private int mShare;
    private int mReply;
    private int mDuration;
    private String mVideoTime;
    SelectdEntiry.ItemListBean mItemListBean;
    private Video mVideo;
    private JZVideoPlayerStandard mVideoPlayerView;
    private String mVideoBitmapUrl;
    private String mVideoPlayUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        translateStatusBar();
        setContentView(R.layout.activity_video_detail);
        initView();
        initData();
        initListener();
    }


    private void initView() {
        mVideoToolbarIv = ViewLess.$(this, R.id.video_toolbar_iv_right);
        mVideoToolbar = ViewLess.$(this, R.id.video_toolbar);
        mVideoDetailIvmo = ViewLess.$(this, R.id.video_detail_ivmo);
        mVideoDetailTitle = ViewLess.$(this, R.id.video_detail_title);
        mVideoDetailTime = ViewLess.$(this, R.id.video_detail_time);
        mVideoDetailDesc = ViewLess.$(this, R.id.video_detail_desc);
        mVideoDetailIvFav = ViewLess.$(this, R.id.video_detail_iv_fav);
        mVideoDetailTvFav = ViewLess.$(this, R.id.video_detail_tv_fav);
        mVideoDetailIvShare = ViewLess.$(this, R.id.video_detail_iv_share);
        mVideoDetailTvShare = ViewLess.$(this, R.id.video_detail_tv_share);
        mVideoDetailIvReply = ViewLess.$(this, R.id.video_detail_iv_reply);
        mVideoDetailTvReply = ViewLess.$(this, R.id.video_detail_tv_reply);
        mVideoDetailIvDown = ViewLess.$(this, R.id.video_detail_iv_down);
        mVideoDetailTvDown = ViewLess.$(this, R.id.video_detail_tv_down);
        mIvBackView = ViewLess.$(this, R.id.iv_back);
        mVideoPlayerView = ViewLess.$(this, R.id.video_player);
    }


    //初始化数据
    private void initData() {
        mItemListBean = (SelectdEntiry.ItemListBean) getIntent().getSerializableExtra(VideoDetailActivity.KEY_VIDEO);

        mVideo = (Video) getIntent().getSerializableExtra(VideoDetailActivity.KEY_VIDEO_FOR_DB);
        if (mVideo == null && mItemListBean != null) {
            mDuration = mItemListBean.getData().getDuration();
            int mm = mDuration / 60;//分
            int ss = mDuration % 60;//秒
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

            mFeed = mItemListBean.getData().getCover().getFeed();//背景图片
            mVideoBitmapUrl= mItemListBean.getData().getCover().getDetail();
            mVideoPlayUrl=mItemListBean.getData().getPlayUrl();
            mTitleStr = mItemListBean.getData().getTitle();
            mCategory = mItemListBean.getData().getCategory();
            mDesc = mItemListBean.getData().getDescription();//视频详情
            mBlurred = mItemListBean.getData().getCover().getBlurred();//模糊图片
            mVideoStr = mItemListBean.getData().getPlayUrl();//视频播放地址
            mCollect = mItemListBean.getData().getConsumption().getCollectionCount();//收藏量
            mShare = mItemListBean.getData().getConsumption().getShareCount();//分享量
            mCategory = mItemListBean.getData().getCategory();
            mReply = mItemListBean.getData().getConsumption().getReplyCount();//回复量
            mVideoTime = "#" + mCategory + " / " + minute + "'" + second + '"';//时间

        }
        if (mItemListBean == null && mVideo != null) {
            long customerId = mVideo.getCustomerId();
            Cover cover = GreenDaoHelper.getDaoSession().getCoverDao().loadByRowId(customerId);
            mDuration = mVideo.getDuration();
            int mm = mDuration / 60;//分
            int ss = mDuration % 60;//秒
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
            mFeed = cover.getFeed();//背景图片
            //mFeed = "dfse";
            mTitleStr = mVideo.getTitle();
            mCategory = mVideo.getCategory();
            mDesc = mVideo.getDescription();//视频详情
            mBlurred = cover.getBlurred();//模糊图片
           // mBlurred = "sdfwe";//模糊图片
            mVideoStr = mVideo.getPlayUrl();//视频播放地址
            mCategory = mVideo.getCategory();
            mCollect = mVideo.getConsumption().getCollectionCount();//收藏量
            mShare = mVideo.getConsumption().getShareCount();//分享量
            mReply = mVideo.getConsumption().getReplyCount();//回复量
            mVideoTime = "#" + mCategory + " / " + minute + "'" + second + '"';//时间

        }

        mVideoPlayerView.setUp(mVideoPlayUrl, JZVideoPlayerStandard .SCREEN_LAYOUT_LIST,"");
        GlideImageLoader.displayImageByUrl(this, mVideoBitmapUrl, mVideoPlayerView.thumbImageView);

        mVideoDetailTitle.setText(mTitleStr);
        mVideoDetailTime.setText(mVideoTime);
        mVideoDetailDesc.setText(mDesc);
        Glide.with(this)
                .load(Uri.parse(mBlurred))
                .centerCrop()
                .crossFade()
                .placeholder(R.drawable.app_image_loading)
                .error(R.drawable.app_image_loading)
                .into(mVideoDetailIvmo);
        mVideoDetailTvFav.setText(String.valueOf(mCollect));
        mVideoDetailTvShare.setText(String.valueOf(mShare));
        mVideoDetailTvReply.setText(String.valueOf(mReply));

    }

    private void initListener() {
      //  mVideoPaly.setOnClickListener(this);
        mIvBackView.setOnClickListener(this);
        mVideoDetailIvDown.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        if (view == mIvBackView) {
            ActivityCompat.finishAfterTransition(this);
        } else if (view == mVideoDetailIvDown) {
        }

    }

    @Override
    public void onBackPressed() {
        ActivityCompat.finishAfterTransition(this);
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }
}
