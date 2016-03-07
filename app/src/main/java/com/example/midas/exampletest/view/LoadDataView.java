package com.example.midas.exampletest.view;

import android.content.Context;

/**
 * Created by Midas on 4/3/2559.
 */
public interface LoadDataView {
    void showProgress();
    void hideProgress();
    void showError(String message);
    Context context();
}
