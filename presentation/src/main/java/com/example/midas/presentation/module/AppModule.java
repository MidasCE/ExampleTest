package com.example.midas.presentation.module;

import android.app.Application;
import android.content.Context;

import com.example.midas.data.repository.UserDataRepository;
import com.example.midas.domain.executor.PostThread;
import com.example.midas.domain.repository.User_InterfaceRepository;
import com.example.midas.presentation.ThreadUI;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Midas on 4/3/2559.
 */
@Module
public class AppModule {
    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides @Singleton
    PostThread proviedPostThread(ThreadUI threadUI) {
        return threadUI;
    }

    @Provides @Singleton
    User_InterfaceRepository proviedUser_InterfaceRepository(UserDataRepository userDataRepository) {
        return userDataRepository;
    }
}
