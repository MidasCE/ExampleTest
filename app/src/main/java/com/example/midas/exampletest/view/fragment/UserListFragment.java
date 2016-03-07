package com.example.midas.exampletest.view.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.midas.exampletest.MyApp;
import com.example.midas.exampletest.R;
import com.example.midas.exampletest.components.UserComponent;
import com.example.midas.exampletest.model.UserModel;
import com.example.midas.exampletest.presenter.UserListPresenter;
import com.example.midas.exampletest.view.UserListView;
import com.example.midas.exampletest.view.adapter.UserAdapter;

import java.util.Collection;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Midas on 4/3/2559.
 */
public class UserListFragment extends BaseFragment implements UserListView {
    @Inject UserAdapter userAdapter;
    @Inject UserListPresenter userListPresenter;

    @Bind(R.id.userlistview) ListView user_lv;
    @Bind(R.id.loading_progress) ProgressBar user_pb;

    public UserListFragment() {
        setRetainInstance(true);
    }

    @Override public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(UserComponent.class).inject(this);
    }

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                       Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_userlist, container, false);
        ButterKnife.bind(this, fragmentView);
        setupListView();
        return fragmentView;
    }

    @Override public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.userListPresenter.setView(this);
        if (savedInstanceState == null) {
            this.loadUserList();
        }
    }

    @Override public void onResume() {
        super.onResume();
        this.userListPresenter.resume();
    }

    @Override public void onPause() {
        super.onPause();
        this.userListPresenter.pause();
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        user_lv.setAdapter(null);
        ButterKnife.unbind(this);
    }

    @Override public void onDestroy() {
        super.onDestroy();
        this.userListPresenter.destroy();
    }

    @Override public void onDetach() {
        super.onDetach();
    }

    @Override
    public void renderUserList(Collection<UserModel> userModelCollection) {
        if (userModelCollection != null) {
            this.userAdapter.setUsersCollection(userModelCollection);
        }
    }

    @Override
    public void showProgress() {
        this.user_pb.setVisibility(View.VISIBLE);
        this.getActivity().setProgressBarIndeterminateVisibility(true);
    }

    @Override
    public void hideProgress() {
        this.user_pb.setVisibility(View.INVISIBLE);
        this.getActivity().setProgressBarIndeterminateVisibility(false);
    }

    @Override
    public void showError(String message) {
        showToastMessage(message);
    }

    @Override
    public Context context() {
        return this.getActivity().getApplicationContext();
    }

    private void setupListView() {
        this.user_lv.setAdapter(userAdapter);
    }

    private void loadUserList() {
        this.userListPresenter.initialize();
    }
}
