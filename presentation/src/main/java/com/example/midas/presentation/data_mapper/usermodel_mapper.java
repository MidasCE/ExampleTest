package com.example.midas.presentation.data_mapper;

import com.example.midas.domain.User;
import com.example.midas.presentation.model.UserModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.inject.Inject;

/**
 * Created by Midas on 11/3/2559.
 */
public class usermodel_mapper {
    @Inject
    public usermodel_mapper() {}

    /**
     * Transform a {@link User} into an {@link UserModel}.
     *
     * @param user Object to be transformed.
     * @return {@link UserModel}.
     */
    public UserModel transform(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        UserModel userModel = new UserModel(user.getId());
        userModel.setLogin(user.getLogin());
        userModel.setHtml_url(user.getHtml_url());
        userModel.setAvatar_url(user.getAvatar_url());

        return userModel;
    }

    public Collection<UserModel> transform(Collection<User> usersCollection) {
        Collection<UserModel> userModelsCollection;

        if (usersCollection != null && !usersCollection.isEmpty()) {
            userModelsCollection = new ArrayList<>();
            for (User user : usersCollection) {
                userModelsCollection.add(transform(user));
            }
        } else {
            userModelsCollection = Collections.emptyList();
        }

        return userModelsCollection;
    }
}
