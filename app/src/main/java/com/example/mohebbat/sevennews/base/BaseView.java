package com.example.mohebbat.sevennews.base;

import android.content.Context;

public interface BaseView {

    void setProgressIndicator(boolean shouldShow);

    void showError(String errorMessage);

    Context context();
}
