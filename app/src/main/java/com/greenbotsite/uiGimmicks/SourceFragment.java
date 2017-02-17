package com.greenbotsite.uiGimmicks;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gaurav on 17/2/17.
 */

public class SourceFragment extends Fragment {

    @BindView(R.id.btn_action)
    Button startTransition;
    @BindView(R.id.img_shared)
    ImageView imageView;

    public static SourceFragment newInstance() {

        SourceFragment sourceFragment = new SourceFragment();
        return sourceFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_source, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(SourceFragment.class.getSimpleName());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        startTransition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .addSharedElement(imageView, getString(R.string.fragment_image_transition))
                        .addToBackStack(null)
                        .replace(android.R.id.content, DestinationFragment.newInstance(), DestinationFragment.class.getSimpleName())
                        .commit();
            }
        });
    }
}
