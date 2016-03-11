package com.example.midas.data;

import com.example.midas.domain.User;
import com.example.midas.domain.repository.User_InterfaceRepository;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Midas on 11/3/2559.
 */
public class UserDataRepository implements User_InterfaceRepository {
    @Override
    public Observable<List<User>> users() {
        Observable<List<User>> fetchFromGoogle = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("https://api.github.com/users?since="+randInt(0,99999))
                            .build();

                    try {
                        Response response = client.newCall(request).execute();

                        subscriber.onNext(response.body().string()); // Emit the contents of the URL
                        subscriber.onCompleted(); // Nothing more to emit
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    subscriber.onError(e); // In case there are network errors
                }
            }
        });
        return fetchFromGoogle;
    }
}
