package com.example.midas.exampletest.view.fragment;

import android.app.Fragment;
import android.widget.Toast;

import com.example.midas.exampletest.HasComponent;

/**
 * Created by Midas on 4/3/2559.
 */
public abstract class BaseFragment extends Fragment {
    protected void showToastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }


}
