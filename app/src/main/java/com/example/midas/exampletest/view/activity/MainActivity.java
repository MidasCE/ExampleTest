package com.example.midas.exampletest.view.activity;

import android.os.Bundle;
import android.view.Window;

import com.example.midas.exampletest.HasComponent;
import com.example.midas.exampletest.R;
import com.example.midas.exampletest.components.DaggerUserComponent;
import com.example.midas.exampletest.components.UserComponent;
import com.example.midas.exampletest.view.fragment.UserListFragment;


public class MainActivity extends BaseActivity implements HasComponent<UserComponent> {
    private UserComponent userComponent;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_layout);

        this.userComponent = DaggerUserComponent.builder()
                .appComponent(getAppComponent())
                .activityModule(getActivityModule())
                .build();
        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, new UserListFragment());
        }
    }

    @Override public UserComponent getComponent() {
        return userComponent;
    }

}
