package com.example.democollect.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.democollect.R;
import com.example.democollect.ui.customview.TestScoreProgressView;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    List<String> mData;
    private int totalNum = 50;
    private int  currentNum = 0;
    private TestScoreProgressView mTestScoreProgressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTestScoreProgressView = findViewById(R.id.test);
    }

    public void random(View view) {

        Random r = new Random();
        if(r.nextBoolean()){
            currentNum++;
            mTestScoreProgressView.upDateProgress((float) (currentNum * 1.0 /totalNum),
                    Math.abs(r.nextInt()%6) + 1);
        }else {
            mTestScoreProgressView.setDrawScoreEnable(false);
        }
    }
}
