package com.ay3524.rxmvpdagger.application.di.modules;

import com.ay3524.rxmvpdagger.application.di.AppScope;
import com.ay3524.rxmvpdagger.data.network.ApiEndpoints;
import com.ay3524.rxmvpdagger.utils.NetworkingConstants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = NetworkModule.class)
public class ApiCallModule {
    @Provides
    @AppScope
    public ApiEndpoints apiEndpointCall(Retrofit apiEndpointCallRetrofit) {
        return apiEndpointCallRetrofit.create(ApiEndpoints.class);
    }

    @Provides
    @AppScope
    public Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    @Provides
    @AppScope
    public Retrofit retrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .baseUrl(NetworkingConstants.PIXABAY_BASE_URL)
                .build();
    }
}
