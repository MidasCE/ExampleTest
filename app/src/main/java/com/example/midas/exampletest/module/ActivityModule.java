package com.example.midas.exampletest.module;

import android.app.Activity;

import com.example.midas.exampletest.ActivityScope;
import com.example.midas.exampletest.view.adapter.UserAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Midas on 5/3/2559.
 */
@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope Activity activity() {
        return this.activity;
    }

    @Provides
    @ActivityScope
    UserAdapter providesUserAdapter(){
        return new UserAdapter(activity);
    }
}
