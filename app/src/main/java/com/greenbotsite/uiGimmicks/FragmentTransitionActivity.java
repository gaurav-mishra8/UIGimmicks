package com.greenbotsite.uiGimmicks;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by gaurav on 17/2/17.
 */
public class FragmentTransitionActivity extends AppCompatActivity {


    public static void startActivtiy(Context context) {
        Intent intent = new Intent(context, FragmentTransitionActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(android.R.id.content, SourceFragment.newInstance(), SourceFragment.class.getSimpleName())
                    .commit();
        }

    }
}
