package com.greenbotsite.uiGimmicks;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by gaurav on 13/2/17.
 */

public class CustomViewActivity extends AppCompatActivity {

    public static void startactivity(Context context) {
        Intent intent = new Intent(context, CustomViewActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        getSupportActionBar().setTitle(R.string.customview_demo);
    }
}
