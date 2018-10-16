package com.ay3524.rxmvpdagger.ui.detailWall;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ay3524.rxmvpdagger.R;
import com.ay3524.rxmvpdagger.base.BaseFragment;
import com.ay3524.rxmvpdagger.ui.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class WallDetailFragment extends BaseFragment<MainActivity> {

    public WallDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public String createTag() {
        return WallDetailFragment.class.getSimpleName();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wall_detail, container, false);
    }

}
