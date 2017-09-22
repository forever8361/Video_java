package com.wwssxx.kaiyan.module.start;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jayfeng.lesscode.core.ViewLess;
import com.wwssxx.kaiyan.R;
import com.wwssxx.kaiyan.base.BaseActivity;
import com.wwssxx.kaiyan.module.main.MainActivity;


/**
 * 程序启动页
 */
public class SpashActivity extends BaseActivity {

    private ImageView mLogoView;
    private TextView mSpashEnView;
    private TextView mSpashZhView;
    private RelativeLayout mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_spalsh);
        translateStatusBar();
        initView();
        startAnimation();
    }

    private void initView() {
        mLayout = ViewLess.$(this, R.id.rl);
        mLogoView = ViewLess.$(this, R.id.splash_iv);
        mSpashEnView = ViewLess.$(this, R.id.spash_tv_english);
        mSpashZhView = ViewLess.$(this, R.id.spash_tv_zh);

    }

    private void startAnimation() {

        PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat("alpha", 0.7f, 1f);
        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX", 1f, 1.2f);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", 1f, 1.2f);
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofPropertyValuesHolder(mLayout, alpha, scaleX, scaleY);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimator1);
        animatorSet.setInterpolator(new

                AccelerateInterpolator());
        animatorSet.setDuration(1500);
        animatorSet.addListener(new Animator.AnimatorListener()

        {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                startActivity(new Intent(SpashActivity.this, MainActivity.class));
                finish();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        animatorSet.start();
    }
}
