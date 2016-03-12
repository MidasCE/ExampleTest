package com.example.midas.presentation.presenter;

import android.support.annotation.NonNull;

import com.example.midas.domain.User;
import com.example.midas.domain.interactor.BaseSubscriber;
import com.example.midas.domain.interactor.UseCase;
import com.example.midas.presentation.ActivityScope;
import com.example.midas.presentation.data_mapper.UserModelMapper;
import com.example.midas.presentation.view.UserListView;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Midas on 4/3/2559.
 */
@ActivityScope
public class UserListPresenter implements Presenter{

    private UserListView userviewListView;
    private final UseCase getUserListUseCase;
    private final UserModelMapper userModelMapper;

    @Inject
    public UserListPresenter(@Named("userList") UseCase getUserListUseCase,UserModelMapper userModelMapper) {
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

}
