package com.example.mohebbat.sevennews;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.example.mohebbat.sevennews.base.BaseActivity;
import com.example.mohebbat.sevennews.home.HomeFragment;

public class MainActivity extends BaseActivity {
    private View progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
    }

    private void setupViews() {
        progressBar = findViewById(R.id.frame_main_progressBarContainer);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_main_fragmentContainer,new HomeFragment());
        fragmentTransaction.commit();
    }

    @Override
    public void setProgressBarIndicator(boolean shouldShow) {
        progressBar.setVisibility(shouldShow ? View.VISIBLE : View.GONE);
    }
}
