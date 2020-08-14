package com.example.democollect.ui.customview.groupview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.example.democollect.uitls.UIHelper;

/**
 * 该类用于测试onMeasure中不同测量模式的特征
 */
public class TestMeasureGroupView extends ViewGroup {
    public TestMeasureGroupView(Context context) {
        this(context, null);
    }

    public TestMeasureGroupView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TestMeasureGroupView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 初始化相关属性和添加child view
     */
    private void init() {
        View childView = new View(getContext());
        childView.setLayoutParams(new LayoutParams(UIHelper.dip2px(30),UIHelper.dip2px(30) ));
        addView(childView);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();
//            child.measure();
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
