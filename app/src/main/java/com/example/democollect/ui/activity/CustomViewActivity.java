package com.example.democollect.ui.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.NoCopySpan;

import com.example.democollect.R;

import androidx.annotation.Nullable;

/**
 * @author zhangt
 * @description:
 * @date :2020/8/18 17:27
 */
public class CustomViewActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_activity_custom_view_layout);
    }
}
