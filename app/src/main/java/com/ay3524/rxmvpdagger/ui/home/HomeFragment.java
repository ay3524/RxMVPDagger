package com.ay3524.rxmvpdagger.ui.home;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ay3524.rxmvpdagger.R;
import com.ay3524.rxmvpdagger.base.BaseFragment;
import com.ay3524.rxmvpdagger.ui.MainActivity;
import com.ay3524.rxmvpdagger.ui.home.di.DaggerHomeComponent;
import com.ay3524.rxmvpdagger.ui.home.di.HomeComponent;
import com.ay3524.rxmvpdagger.ui.home.di.HomeModule;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<MainActivity> implements HomeMvpView {

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public String createTag() {
        return HomeFragment.class.getSimpleName();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        attachParent(getParentActivity());
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        diSetup();
    }

    private void diSetup() {
        HomeComponent component =
                DaggerHomeComponent
                        .builder()
                        .homeModule(new HomeModule(HomeFragment.this))
                        .build();
        component.injectHomeFragment(HomeFragment.this);
    }
}
