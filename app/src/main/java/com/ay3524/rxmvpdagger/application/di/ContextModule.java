package com.ay3524.rxmvpdagger.application.di;

import android.content.Context;

import com.ay3524.rxmvpdagger.application.MyApplication;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private final Context context;
    private final MyApplication application;

    public ContextModule(MyApplication context) {
        this.application = context;
        this.context = context.getApplicationContext();
    }

    @Provides
    public MyApplication getApplication(){
        return application;
    }

    @Provides
    @ApplicationContext
    public Context context() {
        return context;
    }
}
