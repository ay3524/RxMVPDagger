package com.ay3524.rxmvpdagger.application.di.component;

import com.ay3524.rxmvpdagger.application.MyApplication;
import com.ay3524.rxmvpdagger.application.di.AppScope;
import com.ay3524.rxmvpdagger.application.di.modules.ApplicationModule;
import com.ay3524.rxmvpdagger.application.di.modules.ApiCallModule;
import com.ay3524.rxmvpdagger.data.network.ApiEndpoints;
import com.ay3524.rxmvpdagger.application.di.modules.PicassoModule;
import com.ay3524.rxmvpdagger.data.prefs.SharedPrefsHelper;
import com.ay3524.rxmvpdagger.application.di.modules.SharedPrefsModule;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import dagger.Component;
import retrofit2.Retrofit;

@AppScope
@Component(modules = {ApplicationModule.class, ApiCallModule.class,
        PicassoModule.class, SharedPrefsModule.class})
public interface AppComponent {

    void inject(MyApplication myApplication);

    Picasso getPicasso();

    ApiEndpoints getWooHooApiCall();

    Gson getGson();

    Retrofit getRetrofit();

    SharedPrefsHelper getSharedPrefsHelper();

}
