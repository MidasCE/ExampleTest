package com.example.midas.presentation.view.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.midas.presentation.MyApp;
import com.example.midas.presentation.components.AppComponent;
import com.example.midas.presentation.module.ActivityModule;

/**
 * Created by Midas on 4/3/2559.
 */
public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getAppComponent().inject(this);
    }

    protected void addFragment(int containerViewId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.commit();
    }
    protected AppComponent getAppComponent() {
        return ((MyApp)getApplication()).getAppComponent();
    }
    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
