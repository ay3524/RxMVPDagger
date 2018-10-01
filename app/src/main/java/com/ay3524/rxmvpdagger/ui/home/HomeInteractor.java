package com.ay3524.rxmvpdagger.ui.home;

import com.ay3524.rxmvpdagger.base.BaseInteractor;
import com.ay3524.rxmvpdagger.data.network.ApiEndpoints;
import com.ay3524.rxmvpdagger.data.prefs.SharedPrefsHelper;

public class HomeInteractor extends BaseInteractor {

    public HomeInteractor(ApiEndpoints apiHelper, SharedPrefsHelper sharedPrefsHelper) {
        super(apiHelper, sharedPrefsHelper);
    }
}
