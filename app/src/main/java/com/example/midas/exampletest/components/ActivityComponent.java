package com.example.midas.exampletest.components;

import android.app.Activity;

import com.example.midas.exampletest.ActivityScope;
import com.example.midas.exampletest.module.ActivityModule;
import com.example.midas.exampletest.module.AppModule;

import dagger.Component;

/**
 * Created by Midas on 5/3/2559.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity activity();
}
