package com.example.mohebbat.sevennews.data;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public class NewsRepository implements NewsDataSource{
    private CloudDataSource cloudDataSource = new CloudDataSource();
    private LocalDataSource localDataSource = new LocalDataSource();
    
    @Override
    public Single<List<News>> getNews() {
        return cloudDataSource.getNews();
    }

    @Override
    public Single<List<Banner>> getBanner() {
        return cloudDataSource.getBanner();
    }

    @Override
    public Single<List<News>> getVideoNews() {
        return cloudDataSource.getVideoNews();
    }

    @Override
    public Completable bookmark(News news) {
        return localDataSource.bookmark(news);
    }

    @Override
    public Completable unBookmark(News news) {
        return localDataSource.unBookmark(news);
    }

    @Override
    public Single<List<News>> getBookmarkedNews() {
        return localDataSource.getBookmarkedNews();
    }

    @Override
    public Single<News> search(String keyword) {
        return localDataSource.search(keyword);
    }
}
