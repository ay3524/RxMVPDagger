package com.ay3524.rxmvpdagger.application;

import android.app.Activity;
import android.app.Application;

import com.ay3524.rxmvpdagger.application.di.AppComponent;
import com.ay3524.rxmvpdagger.application.di.ContextModule;
import com.ay3524.rxmvpdagger.application.di.DaggerAppComponent;
import com.ay3524.rxmvpdagger.data.network.ApiEndpoints;
import com.ay3524.rxmvpdagger.data.prefs.SharedPrefsHelper;
import com.squareup.picasso.Picasso;

public class MyApplication extends Application {

    private Picasso picasso;
    private ApiEndpoints apiEndpoints;
    private AppComponent appComponent;
    private SharedPrefsHelper sharedPrefsHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeComponent();
    }

    private void initializeComponent() {
        appComponent = DaggerAppComponent
                .builder()
                .contextModule(new ContextModule(this))
                .build();
        apiEndpoints = appComponent.getWooHooApiCall();
        picasso = appComponent.getPicasso();
        sharedPrefsHelper = appComponent.getSharedPrefsHelper();
    }

    public Picasso getPicasso() {
        return picasso;
    }

    public ApiEndpoints getApiEndpoints() {
        return apiEndpoints;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public SharedPrefsHelper getSharedPrefsHelper() {
        return sharedPrefsHelper;
    }

    public static MyApplication get(Activity activity) {
        return (MyApplication) activity.getApplication();
    }

}
