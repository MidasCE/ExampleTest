package com.example.midas.presentation.components;

import android.content.Context;

import com.example.midas.domain.executor.PostThread;
import com.example.midas.domain.repository.UserInterfaceRepository;
import com.example.midas.presentation.module.AppModule;
import com.example.midas.presentation.view.activity.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Midas on 5/3/2559.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(BaseActivity baseActivity);
    Context context();
    PostThread postThread();
    UserInterfaceRepository userRepository();
}
