package com.example.jangjieun.newsker;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.jangjieun.newsker.Adapter.MainAdapter;
import com.example.jangjieun.newsker.Adapter.NewsDetailsList;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

import static android.support.v4.app.ActivityCompat.startActivity;

public class MyRunnable implements Runnable {
    AsyncHttpClient httpClient;
    final String url;
    final String TAG = "MYTEST";


    NewsDetailsList lc;

    public MyRunnable(final String pUrl) {
        url = pUrl;
    }

    @Override
    public void run() {
        httpClient = new AsyncHttpClient();

        httpClient.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Log.d(TAG, "Http get Success");

                String text = "";
                String navernews = "";
                try {
                    text = new String(responseBody, "euc-kr");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                int ds = text.indexOf("c_date");
                navernews += text.substring(ds + 8, ds + 18) + "\n";

                //정치 시작
                int polits = text.indexOf("rankingSectionId=100&rankingSeq=1");
                navernews +=  "\n정치정치정치정치\n" + "\nRANK 1 : news.naver.com";
                String tmp = text.substring(polits,polits+650);
                String[] data = tmp.split("dt");
                int polits2 = data[1].indexOf("title");
                tmp = data[1].substring(10,polits2-2);
                navernews += tmp + "\n";
                tmp =  text.substring(polits,polits+200);
                String tmp2 = tmp.substring(tmp.indexOf("http"),tmp.indexOf("jpg")+3);
                navernews += "\n" + tmp2 + "\n";
/*
                Intent intent = new intent(this, MainActivity.class);
                intent.putExtra("image",navernews);
                startActivity(intent);
                //MainActivity.tvContent.setText(navernews);
*/
            }

            @Override
            public void onFailure(int statusCode, Header[] header, byte[] responseBody, Throwable error) {
                Log.d(TAG, "Http get Fail");
                Log.d(TAG, "Status Code:" + statusCode);
                Log.d(TAG, "Error:" + error.getMessage());

                //MainActivity.tvContent.setText("Http get fail.\nstatus code=" + statusCode + "\nError:" + error.getMessage());
            }
        });
    }
}
