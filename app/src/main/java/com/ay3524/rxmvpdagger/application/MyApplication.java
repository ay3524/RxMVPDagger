package com.ay3524.rxmvpdagger.application;

import android.app.Activity;
import android.app.Application;

import com.ay3524.rxmvpdagger.application.di.component.AppComponent;
import com.ay3524.rxmvpdagger.application.di.component.DaggerAppComponent;
import com.ay3524.rxmvpdagger.application.di.modules.ApplicationModule;
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

        appComponent = DaggerAppComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        appComponent.inject(this);

        apiEndpoints = appComponent.getWooHooApiCall();
        picasso = appComponent.getPicasso();
        sharedPrefsHelper = appComponent.getSharedPrefsHelper();

        test();
    }

    private void test() {
        //FIXME remove later only for testing
//        Call<Example> call =  apiEndpoints.getUserDetails(NetworkingConstants.API_KEY,"latest");
//        call.enqueue(new Callback<Example>() {
//            @Override
//            public void onResponse(@NonNull Call<Example> call, @NonNull Response<Example> response) {
//
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<Example> call, @NonNull Throwable t) {
//
//            }
//        });
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
