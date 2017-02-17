package com.greenbotsite.uiGimmicks;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.util.Pair;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gaurav on 13/2/17.
 */

public class TransitionSourceActivity extends AppCompatActivity {

    @BindView(R.id.btn_startTransition)
    Button startTransition;

    @BindView(R.id.shared_imageview)
    View imageView;

    @BindView(R.id.tv_desc)
    View descriptionTv;

    public static void startactivity(Context context) {
        Intent intent = new Intent(context, TransitionSourceActivity.class);
        context.startActivity(intent);

    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_source);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle(R.string.transition_source_activity);
        startTransition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDestinationActivity();
            }
        });
    }

    private void startDestinationActivity() {

        Intent intent = new Intent(TransitionSourceActivity.this, TransitionDestinationActivity.class);

        Pair<View, String> imagePair = Pair.create(imageView, getString(R.string.shared_transition_image));
        Pair<View, String> descPair = Pair.create(descriptionTv, getString(R.string.shared_transition_desc));

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, imagePair, descPair);


        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            startActivity(intent, options.toBundle());
        else
            startActivity(intent);

    }
}
