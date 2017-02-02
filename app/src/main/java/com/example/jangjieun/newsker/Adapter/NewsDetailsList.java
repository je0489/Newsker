package com.example.jangjieun.newsker.Adapter;

/**
 * Created by jangjieun on 2017. 1. 20..
 */
public class NewsDetailsList {
    int articleImage;
    String date;

    public NewsDetailsList(int Image, String date) {
        this.articleImage = Image;
        this.date = date;
    }

    int getArticleImage() {
        return this.articleImage;
    }

    String getDate() {
        return this.date;
    }
}


