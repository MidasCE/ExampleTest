package com.example.midas.presentation.view;

import com.example.midas.presentation.model.UserModel;

import java.util.Collection;

/**
 * Created by Midas on 4/3/2559.
 */
public interface UserListView extends LoadDataView{
    void renderUserList(Collection<UserModel> userModelCollection);
}
