package com.example.democollect.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.democollect.R;
import com.example.democollect.adapter.MainGuideAdapter;
import com.example.democollect.ui.customview.TestScoreProgressView;
import com.example.democollect.uitls.Constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    List<String> mData;
    private int totalNum = 50;
    private int  currentNum = 0;
    private TestScoreProgressView mTestScoreProgressView;
    private RecyclerView mRvGuideContainer;
    private MainGuideAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mRvGuideContainer = (RecyclerView) findViewById(R.id.rv_guide_container);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        mRvGuideContainer.setLayoutManager(gridLayoutManager);
        mAdapter = new MainGuideAdapter();
        mRvGuideContainer.setAdapter(mAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }

    private void loadData() {
        String[] items = getApplicationContext().getResources().getStringArray(R.array.index_guide_collect);
        if (mAdapter != null) {
            mAdapter.setData(Arrays.asList(items));
        }
    }

}
