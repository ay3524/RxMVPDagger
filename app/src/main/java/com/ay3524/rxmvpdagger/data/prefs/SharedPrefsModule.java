package com.ay3524.rxmvpdagger.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.ay3524.rxmvpdagger.application.di.AppScope;
import com.ay3524.rxmvpdagger.application.di.ApplicationContext;
import com.ay3524.rxmvpdagger.application.di.ContextModule;

import dagger.Module;
import dagger.Provides;

/**
 * Created by admin on 2/21/18.
 */

@Module(includes = ContextModule.class)
public class SharedPrefsModule {

    @Provides
    @AppScope
    public SharedPrefsHelper sharedPrefsHelper(@ApplicationContext Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        return new SharedPrefsHelper(sharedPreferences);
    }

}
