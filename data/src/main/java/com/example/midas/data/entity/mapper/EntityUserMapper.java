package com.example.midas.data.entity.mapper;

import com.example.midas.data.entity.UserEntity;
import com.example.midas.domain.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Midas on 12/3/2559.
 */
@Singleton
public class EntityUserMapper {
    @Inject
    public EntityUserMapper() {}
    public User transform(UserEntity user) {
        if (user == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        User userModel = new User(user.getId());
        userModel.setLogin(user.getLogin());
        userModel.setHtml_url(user.getHtml_url());
        userModel.setAvatar_url(user.getAvatar_url());

        return userModel;
    }

    public List<User> transform(Collection<UserEntity> userEntityCollection) {
        List<User> userList = new ArrayList<>(20);
        User user;
        for (UserEntity userEntity : userEntityCollection) {
            user = transform(userEntity);
            if (user != null) {
                userList.add(user);
            }
        }
        return userList;
    }
}
