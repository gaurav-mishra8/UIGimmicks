package com.greenbotsite.uiGimmicks;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gaurav on 3/2/17.
 */

public class AnimationDemoActivity extends AppCompatActivity {

    @BindView(R.id.image1)
    View image1;
    @BindView(R.id.image2)
    View image2;
    @BindView(R.id.btn_action)
    Button actionBtn;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, AnimationDemoActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvity_animation);

        ButterKnife.bind(this);

        getSupportActionBar().setTitle(R.string.animation_demo);

        actionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transition();
            }
        });
    }

    private void transition() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.beginDelayedTransition((LinearLayout) findViewById(R.id.parent));
        }
        image2.setRotation(image2.getRotation() == 0f ? 50f : 0f);
        image1.setVisibility(image1.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
    }


    @Override
    protected void onResume() {
        super.onResume();
        translate();
    }

    private void translate() {

        image1.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {

                image1.removeOnLayoutChangeListener(this);
                image1.animate().translationY(image1.getWidth()).setInterpolator(new AccelerateDecelerateInterpolator())
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                image2.animate().translationX(image2.getWidth()).withLayer().
                                        setStartDelay(200).setInterpolator(new AnticipateOvershootInterpolator());
                            }
                        });

            }


        });

    }


}