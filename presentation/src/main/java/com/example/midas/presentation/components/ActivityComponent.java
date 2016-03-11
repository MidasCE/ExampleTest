package com.example.midas.presentation.components;

import android.app.Activity;

import com.example.midas.presentation.ActivityScope;
import com.example.midas.presentation.module.ActivityModule;

import dagger.Component;

/**
 * Created by Midas on 5/3/2559.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity activity();
}
