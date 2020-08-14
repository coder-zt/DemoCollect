package com.example.democollect.ui.anim;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.Transformation;

/**
 * @author zhangt
 * @description:
 * @date :2020/8/14 17:10
 */
public class CameraAnimator extends Animation {

    private int mCenterX,mCenterY;
    private float mRotateY;
    Camera mCamera = new Camera();

    public CameraAnimator(float rotateY,int centerX, int centerY) {
        mRotateY = rotateY;
        mCenterX = centerX;
        mCenterY = centerY;
    }



    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        setFillAfter(true);
        setInterpolator(new BounceInterpolator());
//        mCenterX = parentWidth/2;
//        mCenterY = parentHeight/2;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        final Matrix matrix = t.getMatrix();
        mCamera.save();
        mCamera.rotateY(mRotateY * interpolatedTime);
        mCamera.getMatrix(matrix);
        mCamera.restore();
        matrix.preTranslate(mCenterX,mCenterY );
        matrix.postTranslate(-mCenterX,-mCenterY);
    }
}
