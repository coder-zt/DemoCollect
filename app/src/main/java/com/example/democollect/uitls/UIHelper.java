package com.example.democollect.uitls;

import com.example.democollect.base.DemoApplication;

/**
 * 该类的功能用于屏幕单位的转换
 */
public class UIHelper {


    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


    public static int dip2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


    public static int dip2px(float dpValue) {
        Context context = DemoApplication.getContextInstance();
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
