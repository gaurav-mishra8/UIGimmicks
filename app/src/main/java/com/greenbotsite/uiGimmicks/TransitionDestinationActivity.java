package com.greenbotsite.uiGimmicks;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by gaurav on 13/2/17.
 */

public class TransitionDestinationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_dest);

        getSupportActionBar().setTitle(R.string.transition_dest_activity);
    }
}
