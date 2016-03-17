package com.example.midas.data.repository;

import com.example.midas.data.entity.mapper.EntityUserMapper;
import com.example.midas.data.entity.mapper.JsonUserMapper;
import com.example.midas.domain.User;
import com.example.midas.domain.repository.UserInterfaceRepository;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by Midas on 11/3/2559.
 */
public class UserDataRepository implements UserInterfaceRepository {
    private final  JsonUserMapper jsonUserMapper;
    private final EntityUserMapper entityUserMapper;

    @Inject
    public UserDataRepository(JsonUserMapper jsonUserMapper,
                              EntityUserMapper entityUserMapper) {
        this.jsonUserMapper = jsonUserMapper;
        this.entityUserMapper = entityUserMapper;
    }

    @Override
    public Observable<List<User>> users() {
        Observable<List<User>> fetchFromApi = Observable.create(new Observable.OnSubscribe<List<User>>() {
            @Override
            public void call(Subscriber<? super List<User>> subscriber) {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("https://api.github.com/users?since="+randInt(0,99999))
                            .build();

                    try {
                        Response response = client.newCall(request).execute();

                        subscriber.onNext(entityUserMapper.transform(jsonUserMapper.transformUserEntityCollection(response.body().string()))); // Emit the contents of the URL
                        subscriber.onCompleted(); // Nothing more to emit
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    subscriber.onError(e); // In case there are network errors
                }
            }
        });
        return fetchFromApi;
    }

    private int randInt(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
