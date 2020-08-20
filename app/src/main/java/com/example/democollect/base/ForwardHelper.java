package com.example.democollect.base;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.example.democollect.R;
import com.example.democollect.ui.activity.AnimLearningActivity;
import com.example.democollect.ui.activity.CustomViewActivity;

/**
 * @author zhangt
 * @description:
 * @date :2020/8/18 16:56
 */
public class ForwardHelper {

    public static void toGuideTargetForTitle(Context context, String title){
        switch ( getClickItemIndex(context, title)){
            case 0://动画
                toAnimLearningActivity(context);
                break;
            case 1://自定义视图
                toCustomViewActivity(context);
                break;

        }
    }

    private static int getClickItemIndex(Context context, String title) {
        int index = 0;
        final String[] items = context.getResources().getStringArray(R.array.index_guide_collect);
        for (String item : items) {
            if(TextUtils.equals(item,title)){
                break;
            }
            index++;
        }
        return index;
    }

    private static void toCustomViewActivity(Context context) {
        Intent in = new Intent(context, CustomViewActivity.class);
        context.startActivity(in);
    }

    /**
     *
     * @param context
     */
    private static void toAnimLearningActivity(Context context) {
        Intent in = new Intent(context, AnimLearningActivity.class);
        context.startActivity(in);
    }
}
