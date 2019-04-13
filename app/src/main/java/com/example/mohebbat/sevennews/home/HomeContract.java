package com.example.mohebbat.sevennews.home;

import com.example.mohebbat.sevennews.base.BasePresenter;
import com.example.mohebbat.sevennews.base.BaseView;
import com.example.mohebbat.sevennews.data.Banner;
import com.example.mohebbat.sevennews.data.News;

import java.util.List;

public interface HomeContract {

    interface View extends BaseView {
        void showNews(List<News> newsList);
        void showBanners(List<Banner> banners);
    }

    interface Presenter extends BasePresenter<View> {
        void getNewsList();

        void getBanners();
    }
}
