package com.example.mohebbat.sevennews.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mohebbat.sevennews.R;
import com.example.mohebbat.sevennews.data.News;
import com.squareup.picasso.Picasso;

import java.util.List;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private List<News> newsList;

    public NewsAdapter(List<News> newsList) {
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new NewsViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_news, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, int position) {
        newsViewHolder.bindNews(newsList.get(position));
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {
        private ImageView newsImageView;
        private TextView titleTextView;
        private TextView dateTextView;
        private View videoIndicator;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            newsImageView = itemView.findViewById(R.id.iv_news_image);
            videoIndicator = itemView.findViewById(R.id.iv_news_videoIndicator);
            titleTextView = itemView.findViewById(R.id.tv_news_title);
            dateTextView = itemView.findViewById(R.id.tv_news_data);
        }

        public void bindNews(News news) {
            Picasso.get().load(news.getImage()).into(newsImageView);
            videoIndicator.setVisibility(news.isVideoNews() ? View.VISIBLE : View.GONE);
            titleTextView.setText(news.getTitle());
            dateTextView.setText(news.getData());
        }
    }
}
