package com.example.mohebbat.sevennews.data;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface NewsDataSource {
    Single<List<News>> getNews();

    Single<List<Banner>> getBanner();

    Single<List<News>> getVideoNews();

    Completable bookmark(News news);

    Completable unBookmark(News news);

    Single<List<News>> getBookmarkedNews();

    Single<News> search(String keyword);
}
