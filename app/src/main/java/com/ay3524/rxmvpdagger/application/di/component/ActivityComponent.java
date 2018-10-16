package com.ay3524.rxmvpdagger.application.di.component;

import com.ay3524.rxmvpdagger.application.di.PerActivity;
import com.ay3524.rxmvpdagger.application.di.modules.ActivityModule;
import com.ay3524.rxmvpdagger.ui.MainActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity activity);
}
