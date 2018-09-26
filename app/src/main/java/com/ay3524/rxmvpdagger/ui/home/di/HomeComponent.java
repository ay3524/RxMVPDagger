package com.ay3524.rxmvpdagger.ui.home.di;

import com.ay3524.rxmvpdagger.ui.home.HomeFragment;

import dagger.Component;

@Component( modules = HomeModule.class )
public interface HomeComponent {
    void injectHomeFragment ( HomeFragment fragment );
}
