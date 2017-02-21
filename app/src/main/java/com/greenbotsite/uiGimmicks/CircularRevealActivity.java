package com.greenbotsite.uiGimmicks;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gaurav on 20/2/17.
 */
public class CircularRevealActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.tv_label)
    ImageView imageView;

    public static void startActivtiy(Context context) {
        Intent intent = new Intent(context, CircularRevealActivity.class);
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(android.R.anim.slide_in_left, R.anim.hold);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_circular_reveal);
        ButterKnife.bind(this);
        findViewById(R.id.parent).setOnClickListener(this);
    }


    private void createCircularReveal() {

        // get the final radius for the clipping circle
        int finalRadius = Math.max(imageView.getWidth(), imageView.getHeight());

        // create the animator for this view (the start radius is zero)
        Animator anim = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            anim = ViewAnimationUtils.createCircularReveal(imageView, 0, 0, 0, finalRadius);
            anim.setInterpolator(new AnticipateOvershootInterpolator());
            anim.setDuration(1333);
        }

        // make the view visible and start the animation
        imageView.setVisibility(View.VISIBLE);
        anim.start();
    }

    @Override
    public void onClick(View v) {
        createCircularReveal();
    }
}
