package com.example.democollect.ui.anim;

import android.animation.Animator;
import android.graphics.Matrix;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * @author zhangt
 * @description: 电视关闭的动画效果
 * @date :2020/8/14 16:50
 */
public class TVCloseAnimator extends Animation {
    private static final String TAG = "TVCloseAnimator";
    private int mCenterX,mCenterY;
    public TVCloseAnimator(int centerX, int centerY) {
        mCenterX = centerX;
        mCenterY = centerY;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        Log.d(TAG, "applyTransformation: " + interpolatedTime);
        Matrix matrix = t.getMatrix();
        matrix.preScale(1, 1-interpolatedTime, mCenterX,mCenterY);
    }
}
