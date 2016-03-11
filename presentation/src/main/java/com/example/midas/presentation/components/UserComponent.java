package com.example.midas.presentation.components;

import com.example.midas.presentation.ActivityScope;
import com.example.midas.presentation.module.ActivityModule;
import com.example.midas.presentation.module.UserModule;
import com.example.midas.presentation.view.fragment.UserListFragment;

import dagger.Component;

/**
 * Created by Midas on 4/3/2559.
 */
@ActivityScope
@Component(dependencies={AppComponent.class},modules={ActivityModule.class,UserModule.class})
public interface UserComponent extends ActivityComponent{
    void inject(UserListFragment userListFragment);
}
