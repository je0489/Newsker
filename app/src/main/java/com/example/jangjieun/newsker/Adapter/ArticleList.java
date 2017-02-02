package com.example.jangjieun.newsker.Adapter;

/**
 * Created by jangjieun on 2017. 1. 20..
 */
public class ArticleList {
    int articleImage;
    String article;
    String part;
    String title;

    public ArticleList(int Image, String str,String part,String title) {
        this.articleImage = Image;
        this.article = str;
        this.part = part;
        this.title = title;
    }
}
