package com.example.midas.exampletest.components;

import com.example.midas.exampletest.ActivityScope;
import com.example.midas.exampletest.module.ActivityModule;
import com.example.midas.exampletest.module.UserModule;
import com.example.midas.exampletest.view.fragment.UserListFragment;

import dagger.Component;

/**
 * Created by Midas on 4/3/2559.
 */
@ActivityScope
@Component(dependencies={AppComponent.class},modules={ActivityModule.class,UserModule.class})
public interface UserComponent extends ActivityComponent{
    void inject(UserListFragment userListFragment);
}
