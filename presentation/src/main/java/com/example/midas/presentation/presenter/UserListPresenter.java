package com.example.midas.presentation.presenter;

import android.support.annotation.NonNull;

import com.example.midas.domain.User;
import com.example.midas.domain.interactor.BaseSubscriber;
import com.example.midas.domain.interactor.UseCase;
import com.example.midas.presentation.ActivityScope;
import com.example.midas.presentation.data_mapper.usermodel_mapper;
import com.example.midas.presentation.view.UserListView;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Midas on 4/3/2559.
 */
@ActivityScope
public class UserListPresenter implements Presenter{

    private UserListView userviewListView;
    private final UseCase getUserListUseCase;
    private final usermodel_mapper userModelMapper;

    @Inject
    public UserListPresenter(@Named("userList") UseCase getUserListUseCase,usermodel_mapper userModelMapper) {
        this.getUserListUseCase = getUserListUseCase;
        this.userModelMapper = userModelMapper;
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
        getUserListUseCase.execute(new UserListSubscriber());
    }

    private void showUsersCollectionInView(Collection<User> usersCollection) {
        this.userviewListView.renderUserList(userModelMapper.transform(usersCollection));
    }
    private final class UserListSubscriber extends BaseSubscriber<List<User>> {

        @Override public void onCompleted() {
            UserListPresenter.this.hideViewProgress();
        }

        @Override public void onError(Throwable e) {
            UserListPresenter.this.hideViewProgress();
        }

        @Override public void onNext(List<User> users) {
            UserListPresenter.this.showUsersCollectionInView(users);
        }
    }

    private int randInt(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
