package com.example.midas.presentation.module;

import com.example.midas.domain.interactor.UseCase;
import com.example.midas.domain.interactor.GetUserList;
import com.example.midas.presentation.ActivityScope;
import com.example.midas.presentation.presenter.UserListPresenter;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Midas on 4/3/2559.
 */
@Module
public class UserModule {

    public UserModule() {
    }

    @Provides @ActivityScope @Named("userList")
    UseCase provideGetUserListUseCase(
            GetUserList getUserList) {
        return getUserList;
    }
}

