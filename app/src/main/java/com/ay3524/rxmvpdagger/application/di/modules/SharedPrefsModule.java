package com.ay3524.rxmvpdagger.application.di.modules;

import android.content.Context;
import android.content.SharedPreferences;

import com.ay3524.rxmvpdagger.application.di.AppScope;
import com.ay3524.rxmvpdagger.application.di.ApplicationContext;
import com.ay3524.rxmvpdagger.data.prefs.SharedPrefsHelper;

import dagger.Module;
import dagger.Provides;

/**
 * Created by admin on 2/21/18.
 */

@Module(includes = ApplicationModule.class)
public class SharedPrefsModule {

    @Provides
    @AppScope
    public SharedPrefsHelper sharedPrefsHelper(@ApplicationContext Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        return new SharedPrefsHelper(sharedPreferences);
    }

}
