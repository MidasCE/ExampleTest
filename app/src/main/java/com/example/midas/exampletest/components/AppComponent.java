package com.example.midas.exampletest.components;

import android.app.Application;
import android.content.Context;

import com.example.midas.exampletest.module.AppModule;
import com.example.midas.exampletest.view.activity.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Midas on 5/3/2559.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(BaseActivity baseActivity);
    Application application();
    Context context();
}
