package com.example.mohebbat.sevennews.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.widget.Toast;

import com.example.mohebbat.sevennews.R;
import com.example.mohebbat.sevennews.base.BaseFragment;
import com.example.mohebbat.sevennews.data.Banner;
import com.example.mohebbat.sevennews.data.News;
import com.example.mohebbat.sevennews.data.NewsRepository;

import java.util.List;

public class HomeFragment extends BaseFragment implements HomeContract.View {
    private HomeContract.Presenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new HomePresenter(new NewsRepository());
    }

    @Override
    public void showNews(List<News> newsList) {
        RecyclerView newsRecyclerView = rootView.findViewById(R.id.rv_home_newsList);
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        newsRecyclerView.setAdapter(new NewsAdapter(newsList));
        newsRecyclerView.setNestedScrollingEnabled(false);
    }

    @Override
    public void showBanners(List<Banner> banners) {
        RecyclerView bannerRecyclerView = rootView.findViewById(R.id.rv_home_banners);
        bannerRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(bannerRecyclerView);
        bannerRecyclerView.setAdapter(new BannerAdapter(banners));
        bannerRecyclerView.setAdapter(new BannerAdapter(banners));
        bannerRecyclerView.setNestedScrollingEnabled(false);
    }

    @Override
    public void setProgressIndicator(boolean shouldShow) {
        getBaseActivity().setProgressBarIndicator(shouldShow);
    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context context() {
        return getActivity();
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.attachView(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.detachView();
    }

    @Override
    public void setupViews() {

    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_home;
    }
}
