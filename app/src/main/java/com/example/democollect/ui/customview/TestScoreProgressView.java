package com.example.democollect.ui.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.democollect.uitls.UIHelper;

import androidx.annotation.Nullable;

/**
 * @author zhangt
 * @description: 自定义统计分数的seekBar
 * @date :2020/8/13 17:30
 */
public class TestScoreProgressView extends View {
    private static final String TAG = "TestScoreProgressView";
    public  int mTotalWidth = 800;
    public float mProgressRate = 0.0f;
    Paint backPaint, progressPaint, scorePaint,textPaint;
    private int scoreWidth = UIHelper.dip2px(36);
    private int scoreHeight = UIHelper.dip2px(20);
    private int mProgressBarWidth = UIHelper.dip2px(8);
    private Path mPath;
    private RectF mRect;
    private int mMSingleScore;
    private int mSingleScore;
    private boolean mIsDrawScore;

    public TestScoreProgressView(Context context) {
        this(context, null);
    }

    public TestScoreProgressView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TestScoreProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
        Log.d(TAG, "onFinishInflate: " + getMeasuredHeight());
    }

    private void initPaint() {
        backPaint = new Paint();
        backPaint.setColor(Color.parseColor("#3DC0CC"));
        backPaint.setAlpha(26);
        backPaint.setStrokeWidth(mProgressBarWidth);
        backPaint.setStrokeCap(Paint.Cap.ROUND);
        progressPaint = new Paint(backPaint);
        progressPaint.setAlpha(255);
        scorePaint = new Paint(progressPaint);
        scorePaint.setStyle(Paint.Style.FILL);
        textPaint = new Paint();
        textPaint.setTextSize(UIHelper.dip2px(13));
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setColor(Color.WHITE);
        mPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        calculateParam();
        canvas.drawLine(mProgressBarWidth/2, getMeasuredHeight()- mProgressBarWidth/2,
                mTotalWidth,getMeasuredHeight()- mProgressBarWidth/2, backPaint);
        if (mProgressRate > 0f) {
            canvas.drawLine(mProgressBarWidth/2, getMeasuredHeight()- mProgressBarWidth/2
                    ,mTotalWidth*mProgressRate,getMeasuredHeight()- mProgressBarWidth/2, progressPaint);
            if(mIsDrawScore){
                canvas.drawPath(mPath, scorePaint);
                canvas.drawRoundRect(mRect,UIHelper.dip2px(2),UIHelper.dip2px(2),scorePaint);
                canvas.drawText(String.format("+%d", mSingleScore), mRect.left + mRect.width()/2,
                        mRect.top + mRect.height()/4 * 3, textPaint);
            }
        }

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.d(TAG, "onFinishInflate: " + getMeasuredHeight());
    }

    private void calculateParam() {
        Log.d(TAG, "onFinishInflate: " + getMeasuredHeight());
        mTotalWidth = getMeasuredWidth() - UIHelper.dip2px(8)/2 - scoreWidth * 2/3;
        Log.d(TAG, "calculateParam: vmProgressRate ===> " + mProgressRate);
        int progressPoint = (int) (mTotalWidth * mProgressRate) + UIHelper.dip2px(8)/2;
        Log.d(TAG, "calculateParam: progressPoint ===> "  + progressPoint);

        mRect = new RectF(progressPoint -  scoreWidth/3, 0,
                progressPoint + scoreWidth * 2/3,scoreHeight);
        if(mRect.left < 0){
            mRect.right += -mRect.left;
            mRect.left = 0;
        }
//        if(mRect.right > mTotalWidth + UIHelper.dip2px(8)/2){
//            mRect.left -= mRect.right - mTotalWidth;
//            mRect.right = mTotalWidth + UIHelper.dip2px(8)/2 + 10;
//        }
        //画三角形开始
        mPath.reset();
        mPath.moveTo(progressPoint - 10 , (int)mRect.bottom);
        mPath.lineTo(progressPoint,  (int)mRect.bottom + UIHelper.dip2px(4));
        mPath.lineTo(progressPoint + 10 , (int)mRect.bottom);
        mPath.close();
        //画三角形结束
    }

    public void upDateProgress(float rate, int score) {
        if (rate > 1.0f) {
            return;
        }
        mIsDrawScore = true;
        mProgressRate = rate;
        mSingleScore = score;
        invalidate();
    }

    public void setDrawScoreEnable(boolean isDrawScore){
        mIsDrawScore = isDrawScore;
        invalidate();
    }
}
