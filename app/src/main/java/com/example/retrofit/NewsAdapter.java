package com.example.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import model.Articles;
import model.Source;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    private Context context;
    private ArrayList<Articles> articleList;

    public NewsAdapter(Context context1, ArrayList<Articles> articles){
        this.context = context1;
        this.articleList = articles;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        NewsHolder newsHolder = new NewsHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_news_info, parent, false));

        return newsHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        Articles currentArticle = articleList.get(position);

        holder.dTvAuthor.setText(currentArticle.author);
        holder.dTvTitle.setText(currentArticle.title);
        holder.dTvDescription.setText(currentArticle.description);
        holder.dTvUrl.setText(currentArticle.url);
        holder.dTvUrlToImage.setText(currentArticle.urlToImage);
        holder.dTvPublishedAt.setText(currentArticle.publishedAt);
        holder.dTvContent.setText(currentArticle.content);
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    class NewsHolder extends RecyclerView.ViewHolder{

        private TextView dTvAuthor;
        private TextView dTvTitle;
        private TextView dTvDescription;
        private TextView dTvUrl;
        private TextView dTvUrlToImage;
        private TextView dTvPublishedAt;
        private TextView dTvContent;

        public NewsHolder(@NonNull View itemView) {

            super(itemView);

            dTvAuthor = itemView.findViewById(R.id.tv_author);
            dTvTitle = itemView.findViewById(R.id.tv_title);
            dTvDescription = itemView.findViewById(R.id.tv_description);
            dTvUrl = itemView.findViewById(R.id.tv_url);
            dTvUrlToImage = itemView.findViewById(R.id.tv_url_to_image);
            dTvPublishedAt = itemView.findViewById(R.id.tv_published_at);
            dTvContent = itemView.findViewById(R.id.tv_content);
        }
    }
}
