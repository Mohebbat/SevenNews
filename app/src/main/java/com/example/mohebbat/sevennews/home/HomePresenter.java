package com.example.mohebbat.sevennews.home;

import com.example.mohebbat.sevennews.R;
import com.example.mohebbat.sevennews.data.Banner;
import com.example.mohebbat.sevennews.data.News;
import com.example.mohebbat.sevennews.data.NewsDataSource;

import java.util.List;

import javax.sql.DataSource;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomePresenter implements HomeContract.Presenter {
    private HomeContract.View view;
    private NewsDataSource newsDataSource;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public HomePresenter(NewsDataSource newsDataSource){
        this.newsDataSource = newsDataSource;
    }

    @Override
    public void getNewsList() {
        view.setProgressIndicator(true);
        newsDataSource.getNews().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<News>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(List<News> newsList) {
                        view.showNews(newsList);
                        view.setProgressIndicator(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.setProgressIndicator(false);
                        view.showError(view.context().getString(R.string.all_unKnownError));
                    }
                });
    }

    @Override
    public void getBanners() {
        view.setProgressIndicator(true);
        newsDataSource.getBanner().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Banner>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(List<Banner> banners) {
                        view.showBanners(banners);
                        view.setProgressIndicator(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.setProgressIndicator(false);
                        view.showError(view.context().getString(R.string.all_unKnownError));
                    }
                });
    }

    @Override
    public void attachView(HomeContract.View view) {
        this.view = view;
        getNewsList();
        getBanners();
    }

    @Override
    public void detachView() {
        this.view = null;
        if (compositeDisposable!= null && compositeDisposable.size() > 0) {
            compositeDisposable.clear();
        }
    }
}
