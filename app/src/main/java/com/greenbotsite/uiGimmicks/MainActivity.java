package com.greenbotsite.uiGimmicks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.btn_anim)
    Button animation;
    @BindView(R.id.btn_shared_transition)
    Button sharedTransition;
    @BindView(R.id.btn_fragment_shared_transition)
    Button fragmentTransition;
    @BindView(R.id.btn_vector)
    Button vector;
    @BindView(R.id.btn_custom)
    Button customView;
    @BindView(R.id.btn_circular_reveal)
    Button circularReveal;

    int pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        animation.setOnClickListener(this);
        sharedTransition.setOnClickListener(this);
        fragmentTransition.setOnClickListener(this);
        vector.setOnClickListener(this);
        customView.setOnClickListener(this);
        circularReveal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_anim:
               // AnimationDemoActivity.startActivity(this);
                break;
            case R.id.btn_shared_transition:
                TransitionSourceActivity.startactivity(this);
                break;
            case R.id.btn_fragment_shared_transition:
                FragmentTransitionActivity.startActivtiy(this);
                break;
            case R.id.btn_vector:
                VectorDemoActivity.startActivity(this);
                break;
            case R.id.btn_custom:
                CustomViewActivity.startactivity(this);
                break;
            case R.id.btn_circular_reveal:

                CircularRevealActivity.startActivtiy(this);
                break;
        }
    }
}
