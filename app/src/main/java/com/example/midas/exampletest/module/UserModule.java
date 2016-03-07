package com.example.midas.exampletest.module;

import com.example.midas.exampletest.ActivityScope;
import com.example.midas.exampletest.presenter.UserListPresenter;
import com.example.midas.exampletest.view.adapter.UserAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Midas on 4/3/2559.
 */
@Module
public class UserModule {

    public UserModule() {
    }

    @Provides
    @ActivityScope
    UserListPresenter providesUserListPresenter(){
        UserListPresenter userListPresenter = new UserListPresenter();
        return userListPresenter;
    }
}

