package com.ay3524.rxmvpdagger.data.network;

import android.content.Context;
import android.util.Log;

import com.ay3524.rxmvpdagger.application.di.AppScope;
import com.ay3524.rxmvpdagger.application.di.ApplicationContext;
import com.ay3524.rxmvpdagger.application.di.modules.ContextModule;
import com.ay3524.rxmvpdagger.data.prefs.SharedPrefsModule;

import java.io.File;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.Authenticator;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by admin on 1/31/18.
 */

@Module(includes = {ContextModule.class, SharedPrefsModule.class})
public class NetworkModule {

    @Provides
    @AppScope
    public HttpLoggingInterceptor loggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.e(NetworkModule.class.getSimpleName(), message);
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Provides
    @AppScope
    public Cache cache(File cacheFile) {
        return new Cache(cacheFile, 10 * 1000 * 1000); //10MB Cache
    }

    @Provides
    @AppScope
    public File cacheFile(@ApplicationContext Context context) {
        return new File(context.getCacheDir(), "okhttp_cache");
    }

    @Provides
    @AppScope
    public OkHttpClient okHttpClient(HttpLoggingInterceptor loggingInterceptor, Cache cache) {

        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .connectTimeout(30 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(120 * 1000, TimeUnit.MILLISECONDS)
                .build();
    }

    @Provides
    @AppScope
    public OkHttpClient.Builder okHttpClientBuilder(HttpLoggingInterceptor loggingInterceptor, Cache cache, Authenticator authenticator) {

        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .connectTimeout(30 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(120 * 1000, TimeUnit.MILLISECONDS);
    }

}
