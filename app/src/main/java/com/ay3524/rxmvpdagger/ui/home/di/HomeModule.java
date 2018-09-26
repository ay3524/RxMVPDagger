package com.ay3524.rxmvpdagger.ui.home.di;

import com.ay3524.rxmvpdagger.ui.home.HomeFragment;

import dagger.Module;

@Module
public class HomeModule {
    private HomeFragment mFragment;

    public HomeModule(HomeFragment fragment) {
        this.mFragment = fragment;
    }
}
