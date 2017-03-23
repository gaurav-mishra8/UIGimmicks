package com.greenbotsite.uiGimmicks;

import android.content.Context;
import android.content.Intent;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.transition.ArcMotion;
import android.transition.AutoTransition;
import android.transition.ChangeBounds;
import android.transition.ChangeScroll;
import android.transition.Fade;
import android.transition.PathMotion;
import android.transition.Scene;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gaurav on 21/2/17.
 */
public class SceneTransitionActivity extends AppCompatActivity {

    LinearLayout parent;

    Scene first, second;
    Scene current;
    TransitionManager transitionManager;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, SceneTransitionActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenes);
        parent = (LinearLayout) findViewById(R.id.root_group);

        buildTransition();
    }

    private void startTransition() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (current == first)
                transitionManager.transitionTo(second);
            else
                transitionManager.transitionTo(first);
        }
    }

    public void buildTransition() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            first = Scene.getSceneForLayout(parent, R.layout.first_scene, this);
            second = Scene.getSceneForLayout(parent, R.layout.second_scene, this);
            Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.arc1);
            transition.setDuration(1333);

            first.setEnterAction(new Runnable() {
                @Override
                public void run() {
                    current = first;
                }
            });

            second.setEnterAction(new Runnable() {
                @Override
                public void run() {
                    current = second;
                }
            });

            transitionManager = new TransitionManager();
            transitionManager.setTransition(first, second, transition);
            transitionManager.setTransition(second, first, transition);
            transitionManager.transitionTo(first);

            parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startTransition();
                }
            });
        }

    }

}



