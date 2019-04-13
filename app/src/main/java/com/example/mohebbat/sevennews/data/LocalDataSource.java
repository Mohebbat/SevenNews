package com.example.mohebbat.sevennews.data;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public class LocalDataSource implements NewsDataSource {
    @Override
    public Single<List<News>> getNews() {
        return null;
    }

    @Override
    public Single<List<Banner>> getBanner() {
        return null;
    }

    @Override
    public Single<List<News>> getVideoNews() {
        return null;
    }

    @Override
    public Completable bookmark(News news) {
        return null;
    }

    @Override
    public Completable unBookmark(News news) {
        return null;
    }

    @Override
    public Single<List<News>> getBookmarkedNews() {
        return null;
    }

    @Override
    public Single<News> search(String keyword) {
        return null;
    }
}
