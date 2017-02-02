package com.example.jangjieun.newsker.Adapter;

import android.content.Context;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jangjieun.newsker.ArticleActivity;
import com.example.jangjieun.newsker.R;
import com.example.jangjieun.newsker.SoundActivity;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by jangjieun on 2017. 1. 20..
 */
public class ArticleListAdapter extends PagerAdapter {
    Button sound,allsound;
    TextView article,articleTitle,articlePart;
    ImageView articleImage;
    Context context;
    LayoutInflater inflacter;

    ArrayList<ArticleList> ArArticleList = null;
    int layout;

    public ArticleListAdapter(Context context, int alayout, ArrayList<ArticleList> DL){
        this.context = context;
        inflacter = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layout = alayout;
        ArArticleList = DL;
    }

    @Override
    public int getCount() {
        return ArArticleList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = null;

        view = inflacter.inflate(R.layout.article_childview,null);

        articleImage = (ImageView) view.findViewById(R.id.article_image);
        article = (TextView) view.findViewById(R.id.article);
        articlePart = (TextView) view.findViewById(R.id.article_part);
        articleTitle = (TextView) view.findViewById(R.id.article_title);

        articleImage.setImageResource(ArArticleList.get(position).articleImage);
        article.setText(ArArticleList.get(position).article);
        articlePart.setText(ArArticleList.get(position).part);
        articleTitle.setText(ArArticleList.get(position).title);

        container.addView(view);

        sound = (Button) view.findViewById(R.id.article_sound);
        sound.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"부분 재생",Toast.LENGTH_LONG).show();
            }
        }) ;

        allsound = (Button) view.findViewById(R.id.article_all_sound);
        allsound.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"전체 재생",Toast.LENGTH_LONG).show();
            }
        }) ;
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
}
