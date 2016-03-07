package com.example.midas.exampletest.presenter;

import android.support.annotation.NonNull;

import com.example.midas.exampletest.ActivityScope;
import com.example.midas.exampletest.view.UserListView;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Midas on 4/3/2559.
 */
@ActivityScope
public class UserListPresenter implements Presenter{

    private UserListView userviewListView;

    @Inject
    public UserListPresenter() {
    }

    public void setView(@NonNull UserListView view) {
        this.userviewListView = view;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        this.userviewListView = null;
    }

    public void initialize() {
        this.loadUserList();
    }

    private void loadUserList() {
        this.showViewProgress();
        this.getUserList();
    }

    private void showViewProgress() {
        this.userviewListView.showProgress();
    }

    private void hideViewProgress() {
        this.userviewListView.hideProgress();
    }

    private void getUserList() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/users?since=")
                .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int randInt(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
