package com.example.jangjieun.newsker.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jangjieun.newsker.ArticleActivity;
import com.example.jangjieun.newsker.R;

import java.util.ArrayList;

/**
 * Created by jangjieun on 2017. 1. 20..
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    Intent intent;
    Context context;
    private ArrayList<NewsDetailsList> mDatasetList;

    public MainAdapter(ArrayList<NewsDetailsList> mDatasetList,Context context) {
        this.mDatasetList = mDatasetList;
        this.context = context;
    }

    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_cardview, parent, false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(MainAdapter.ViewHolder holder, int position) {
        final NewsDetailsList item = mDatasetList.get(position);

        holder.date.setText(mDatasetList.get(position).date);
        holder.mainImage.setImageResource(mDatasetList.get(position).articleImage);

        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, item.getDate(), Toast.LENGTH_SHORT).show();
                intent = new Intent(context, ArticleActivity.class);
                intent.putExtra("DATE",item.getDate()+", 2017");

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatasetList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView date;
        public ImageView mainImage;
        public CardView cardview;

        public ViewHolder(View itemView) {
            super(itemView);

            date = (TextView) itemView.findViewById(R.id.date);
            mainImage = (ImageView) itemView.findViewById(R.id.main_image);
            cardview = (CardView) itemView.findViewById(R.id.cardView);
        }
    }
}
