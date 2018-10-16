package com.ay3524.rxmvpdagger.application.di.modules;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.ay3524.rxmvpdagger.application.di.ActivityContext;
import com.ay3524.rxmvpdagger.application.di.PerActivity;
import com.ay3524.rxmvpdagger.ui.home.HomeInteractor;
import com.ay3524.rxmvpdagger.ui.home.HomeMvpInteractor;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }



    @Provides
    @PerActivity
    HomeMvpInteractor provideHomeInteractor(HomeInteractor homeInteractor) {
        return homeInteractor;
    }
}
