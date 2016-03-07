package com.example.midas.exampletest.view;

import com.example.midas.exampletest.model.UserModel;

import java.util.Collection;

/**
 * Created by Midas on 4/3/2559.
 */
public interface UserListView extends LoadDataView{
    void renderUserList(Collection<UserModel> userModelCollection);
}
