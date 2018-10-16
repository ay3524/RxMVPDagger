package com.ay3524.rxmvpdagger.application.di.modules;

import android.content.Context;

import com.ay3524.rxmvpdagger.application.di.AppScope;
import com.ay3524.rxmvpdagger.application.di.ApplicationContext;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module(includes = {ApplicationModule.class, NetworkModule.class})
public class PicassoModule {

    @Provides
    @AppScope
    public Picasso picasso(@ApplicationContext Context context, OkHttp3Downloader okHttp3Downloader) {
        return new Picasso.Builder(context)
                .downloader(okHttp3Downloader)
                .build();
    }

    @Provides
    @AppScope
    public OkHttp3Downloader okHttp3Downloader(OkHttpClient okHttpClient) {
        return new OkHttp3Downloader(okHttpClient);
    }

}
