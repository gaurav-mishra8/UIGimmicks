package com.greenbotsite.uiGimmicks;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by gaurav on 7/2/17.
 */

public class VectorDemoActivity extends AppCompatActivity {

    private ImageView morphImageView;
    private ImageView trimImageView;


    public static void startActivity(Context context) {
        Intent intent = new Intent(context, VectorDemoActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vector);
        getSupportActionBar().setTitle(R.string.vector_demo);

        morphImageView = (ImageView) findViewById(R.id.morph_imageview);
        trimImageView = (ImageView) findViewById(R.id.trim_imageview);


    }

    @Override
    protected void onResume() {
        super.onResume();

        startMorphing();
        startTrimPath();

    }

    private void startTrimPath() {
        Drawable drawable = trimImageView.getDrawable();
        if (drawable instanceof Animatable)
            ((Animatable) drawable).start();
    }

    private void startMorphing() {
        Drawable drawable = morphImageView.getDrawable();
        if (drawable instanceof Animatable)
            ((Animatable) drawable).start();
    }


}
