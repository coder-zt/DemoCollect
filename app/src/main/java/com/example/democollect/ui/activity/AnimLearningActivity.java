package com.example.democollect.ui.activity;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

import com.example.democollect.R;
import com.example.democollect.ui.anim.CameraAnimator;
import com.example.democollect.ui.anim.TVCloseAnimator;

import androidx.annotation.LongDef;
import androidx.annotation.Nullable;

/**
 * @author zhangt
 * @description: 用来测试和学习android中动画的使用
 * @date :2020/8/14 11:53
 */
public class AnimLearningActivity extends Activity implements View.OnClickListener {

//    public static final String TAG;
    private static final String TAG = "AnimLearningActivity";
    private TextView mTvAlphaAnim;
    private TextView mTvScaleAnim;
    private TextView mTvTranslateAnim;
    private TextView mTvRotateAnim;
    private TextView mTvCollectAnim;
    private Button mMBtnTranslateAnimator;
    private Button mBtnCustomAnimator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_activity_anim_learning_layout);
        initView();
        initListener();
    }

    private void initListener() {
        //透明度动画
        mTvAlphaAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f,1.0f);
                alphaAnimation.setDuration(3000);
                alphaAnimation.setRepeatCount(5);
                v.startAnimation(alphaAnimation);
            }
        });
        //旋转动画
        mTvRotateAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Rect rect = new Rect();
                v.getDrawingRect(rect);
                RotateAnimation rotateAnimation = new RotateAnimation(0, 360, rect.width()/2, rect.height()/2);
                rotateAnimation.setDuration(3000);
                rotateAnimation.setRepeatCount(5);
                v.startAnimation(rotateAnimation);
            }
        });
        //位移动画
        mTvTranslateAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Rect rect = new Rect();
                v.getDrawingRect(rect);
                TranslateAnimation translateAnimation = new TranslateAnimation(0, (float) (rect.width()/2.0), 0, 5 * rect.height());
                translateAnimation.setDuration(3000);
                translateAnimation.setRepeatCount(5);
                v.startAnimation(translateAnimation);
            }
        });
        //缩放动画
        mTvScaleAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1,0,1, Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF,0.5f);
                scaleAnimation.setDuration(3000);
                scaleAnimation.setRepeatCount(5);
                v.startAnimation(scaleAnimation);
            }
        });
        //集合动画
        mTvCollectAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationSet animationSet = new AnimationSet(true);
                animationSet.setDuration(500);
                animationSet.setRepeatCount(5);
                ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1,0,1, Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF,0.5f);
                scaleAnimation.setDuration(3000);
                scaleAnimation.setRepeatCount(5);
                animationSet.addAnimation(scaleAnimation);
                Rect rect = new Rect();
                v.getDrawingRect(rect);
                RotateAnimation rotateAnimation = new RotateAnimation(0, 360, rect.width()/2, rect.height()/2);
                rotateAnimation.setDuration(3000);
                rotateAnimation.setRepeatCount(5);
                animationSet.addAnimation(rotateAnimation);
                v.startAnimation(animationSet);
                rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Log.d(TAG, "onAnimationStart: ...");
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Log.d(TAG, "onAnimationEnd: ....");
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        Log.d(TAG, "onAnimationRepeat: ...");
                    }
                });
            }
        });

        mMBtnTranslateAnimator.setOnClickListener(this);
        mBtnCustomAnimator.setOnClickListener(this);
    }

    private void initView() {
        mTvAlphaAnim = (TextView)findViewById(R.id.tv_alpha_animation);
        mTvRotateAnim = (TextView)findViewById(R.id.tv_rotate_animation);
        mTvTranslateAnim = (TextView)findViewById(R.id.tv_translate_animation);
        mTvScaleAnim = (TextView)findViewById(R.id.tv_scale_animation);
        mTvCollectAnim = (TextView)findViewById(R.id.tv_collect_animation);
        mMBtnTranslateAnimator = (Button)findViewById(R.id.btn_translate_animator);
        mBtnCustomAnimator = (Button)findViewById(R.id.btn_custom_animator);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_translate_animator:
                animatorTranslate();
                break;
            case R.id.btn_custom_animator:
                customAnimator();
                break;
        }
    }

    private void customAnimator() {

        CameraAnimator rotateAnimation = new CameraAnimator(360, mBtnCustomAnimator.getWidth()/2, mBtnCustomAnimator.getMeasuredHeight()/2);
        rotateAnimation.setDuration(3000);
        mBtnCustomAnimator.startAnimation(rotateAnimation);
    }

    private void animatorTranslate() {
        //单一动画效果
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mMBtnTranslateAnimator,"rotationY", 180);
        objectAnimator.setDuration(5000);
        objectAnimator.start();
//        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(mMBtnTranslateAnimator,"translationX", -300);
//        objectAnimator2.setDuration(500);
//        objectAnimator2.start();
        //组合动画效果
//        PropertyValuesHolder pvh1 = PropertyValuesHolder.ofFloat("translationX", 300f);
//        PropertyValuesHolder pvh2 = PropertyValuesHolder.ofFloat("scaleX", 1f,0,1f);
//        PropertyValuesHolder pvh3 = PropertyValuesHolder.ofFloat("scaleY", 1f,0,1f);
//        ObjectAnimator.ofPropertyValuesHolder(mMBtnTranslateAnimator, pvh1,pvh2,pvh3)
//                .setDuration(1000).start();
        //ValueAnimator-数值发生器
//        ValueAnimator animator = ValueAnimator.ofFloat(0, 100);
//        animator.setTarget(mMBtnTranslateAnimator);
//        animator.setDuration(1000).start();
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                Float floatValue = (Float)animation.getAnimatedValue();
//                Log.d(TAG, "onAnimationUpdate: " + floatValue);
//            }
//        });
    }
}
