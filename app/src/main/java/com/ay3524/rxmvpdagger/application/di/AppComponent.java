package com.ay3524.rxmvpdagger.application.di;

import com.ay3524.rxmvpdagger.data.network.ApiCallModule;
import com.ay3524.rxmvpdagger.data.network.ApiEndpoints;
import com.ay3524.rxmvpdagger.data.network.PicassoModule;
import com.ay3524.rxmvpdagger.data.prefs.SharedPrefsHelper;
import com.ay3524.rxmvpdagger.data.prefs.SharedPrefsModule;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import dagger.Component;
import retrofit2.Retrofit;

@AppScope
@Component(modules = {ApiCallModule.class, PicassoModule.class, SharedPrefsModule.class})
public interface AppComponent {
    Picasso getPicasso();

    ApiEndpoints getWooHooApiCall();

    Gson getGson();

    Retrofit getRetrofit();

    SharedPrefsHelper getSharedPrefsHelper();

}
