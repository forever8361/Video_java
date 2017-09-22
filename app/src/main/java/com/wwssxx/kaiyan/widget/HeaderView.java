package com.wwssxx.kaiyan.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jayfeng.lesscode.core.DrawableLess;
import com.jayfeng.lesscode.core.ViewLess;
import com.wwssxx.kaiyan.R;



public class HeaderView extends RelativeLayout {

    private View mContainerView;
    private TextView mTitleView;
    private ImageView mBackView;
    private TextView mBackTextView;
    private TextView mRightTextView;
    private ImageView mRightImageView;
    private View mShadowDividerView;

    public HeaderView(Context context) {
        super(context);
        init(null, 0);
    }

    public HeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public HeaderView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        LayoutInflater.from(getContext()).inflate(R.layout.view_header, this, true);
        mContainerView = ViewLess.$(this, R.id.header_container);
        mTitleView = ViewLess.$(this, R.id.title);
        mBackView = ViewLess.$(this, R.id.back);
        mBackTextView = ViewLess.$(this, R.id.back_text);
        mRightImageView = ViewLess.$(this, R.id.right_image);
        mRightTextView = ViewLess.$(this, R.id.right_text);
        mShadowDividerView = ViewLess.$(this, R.id.divider);

//        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(),"fonts/fz_xh.ttf");
//        mTitleView.setTypeface(typeface);

        mBackView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity) getContext()).onBackPressed();
            }
        });
        showLeft(false);
    }

    public void setTitle(String title) {
        mTitleView.setText(title);
    }

    public void setTitleColor(int titlecolor) {
        mTitleView.setTextColor(titlecolor);
    }

    public void setLeftImage(int leftImage) {
        mBackView.setImageResource(leftImage);
    }

    public void showLeft(boolean show) {
        mBackView.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    public void showLeftBackView(boolean show, OnClickListener listener) {
        mBackView.setOnClickListener(listener);
        mBackView.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    public void showLeftTextView(String text, OnClickListener listener) {
        mBackTextView.setText(text);
        mBackTextView.setOnClickListener(listener);
        mBackTextView.setVisibility(View.VISIBLE);
    }

    public void showRightTextView(String text, OnClickListener listener) {
        mRightTextView.setText(text);
        mRightTextView.setOnClickListener(listener);
        mRightTextView.setVisibility(View.VISIBLE);
    }

    public void showRightTextView(String text, String textColor, OnClickListener listener) {
        mRightTextView.setText(text);
        mRightTextView.setTextColor(Color.parseColor(textColor));
        mRightTextView.setOnClickListener(listener);
        mRightTextView.setVisibility(View.VISIBLE);
    }
    public void showRightTextView(String text, int textColor, OnClickListener listener) {
        mRightTextView.setText(text);
        mRightTextView.setTextColor(textColor);
        mRightTextView.setOnClickListener(listener);
        mRightTextView.setVisibility(View.VISIBLE);
    }
    public void showRightTextView() {
        mRightTextView.setVisibility(View.VISIBLE);
    }

    public TextView getRightTextView() {
        return mRightTextView;
    }

    public void showRightTextView(String text) {
        mRightTextView.setText(text);
        mRightTextView.setVisibility(View.VISIBLE);
    }

    public void showRightImageView(int drawableId, OnClickListener listener) {
        mRightImageView.setImageResource(drawableId);
        mRightImageView.setOnClickListener(listener);
        mRightImageView.setVisibility(View.VISIBLE);
    }

    public void showTintRightImageView(int drawableId, OnClickListener listener) {
        Drawable tintDrawable = DrawableLess.$tint(getResources().getDrawable(drawableId), getResources().getColorStateList(R.color.tint_drawable_color));
        mRightImageView.setImageDrawable(tintDrawable);
        mRightImageView.setOnClickListener(listener);
        mRightImageView.setVisibility(View.VISIBLE);
    }
    public void showTintRightImageView(int drawableId, OnClickListener listener,int color) {
        Drawable tintDrawable = DrawableLess.$tint(getResources().getDrawable(drawableId), getResources().getColor(color));
        mRightImageView.setImageDrawable(tintDrawable);
        mRightImageView.setOnClickListener(listener);
        mRightImageView.setVisibility(View.VISIBLE);
    }
    public void hideRightTextView() {
        mRightTextView.setVisibility(View.GONE);
    }

    public void hideRightImageView() {
        mRightImageView.setVisibility(View.GONE);
    }

    public void showRightImageView() {
        mRightImageView.setVisibility(View.VISIBLE);
    }

    public void setBgColor(String color) {
        mContainerView.setBackgroundColor(Color.parseColor(color));
    }

    public void setBgColor(int color) {
        mContainerView.setBackgroundColor(color);
    }

    public void setBgImage(int bgImage) {
        mContainerView.setBackgroundResource(bgImage);
    }

    public void alphaShadowDivider(int alpha) {
        mShadowDividerView.setAlpha(alpha);
    }

    public void hideShadowDivider() {
        mShadowDividerView.setVisibility(View.GONE);
    }

    public TextView getTitleView() {
        return mTitleView;
    }

    public ImageView getBackView() {
        return mBackView;
    }

    public ImageView getRightImageView() {
        return mRightImageView;
    }
}



