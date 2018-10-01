package com.ay3524.rxmvpdagger.base;

import com.ay3524.rxmvpdagger.data.network.ApiEndpoints;
import com.ay3524.rxmvpdagger.data.prefs.SharedPrefsHelper;

interface MvpInteractor {
    ApiEndpoints getApiHelper();

    SharedPrefsHelper getPreferencesHelper();
}
