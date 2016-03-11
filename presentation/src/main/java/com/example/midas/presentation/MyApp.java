package com.example.midas.presentation;

import android.app.Application;

import com.example.midas.presentation.components.AppComponent;
import com.example.midas.presentation.components.DaggerAppComponent;
import com.example.midas.presentation.components.UserComponent;
import com.example.midas.presentation.module.AppModule;

/**
 * Created by Midas on 4/3/2559.
 */
public class MyApp extends Application {
    private AppComponent appComponent;
    private UserComponent userComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
