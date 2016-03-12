package com.example.midas.data.entity.mapper;

import com.example.midas.data.entity.UserEntity;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Midas on 12/3/2559.
 */
public class JsonUserMapper {

    private final Gson gson;

    @Inject
    public JsonUserMapper() {
        this.gson = new Gson();
    }

    public UserEntity transformUserEntity(String userJsonResponse) throws JsonSyntaxException {
        return gson.fromJson(userJsonResponse, UserEntity.class);
    }

    public List<UserEntity> transformUserEntityCollection(String userListJsonResponse)
            throws JsonSyntaxException {

        List<UserEntity> userEntityCollection;
        try {
            Type listOfUserEntityType = new TypeToken<List<UserEntity>>() {}.getType();
            userEntityCollection = this.gson.fromJson(userListJsonResponse, listOfUserEntityType);

            return userEntityCollection;
        } catch (JsonSyntaxException jsonException) {
            throw jsonException;
        }
    }
}
