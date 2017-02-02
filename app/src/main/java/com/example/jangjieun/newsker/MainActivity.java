package com.example.jangjieun.newsker;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.jangjieun.newsker.Adapter.MainAdapter;
import com.example.jangjieun.newsker.Adapter.NewsDetailsList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private ArrayList<NewsDetailsList> mDatasetList = new ArrayList<NewsDetailsList>();

    Handler mHandler;
    MyRunnable myRunnable;
    InputMethodManager imm;
    String mStrUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            initNewsDetailsList();
        } catch(Exception e) {
        }
/*
        mHandler = new Handler();

        // 키보드 화면에서 내리기
        imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        //imm.hideSoftInputFromWindow(tvUrl.getWindowToken(), 0);

        String YY = (Calendar.getInstance().get(Calendar.YEAR)) + "";
        String MM = (Calendar.getInstance().get(Calendar.MONTH) + 1) + "";
        if(MM.length() < 10) MM = "0"+ MM;
        String DD = Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + "";

        //String kText = Calendar.getInstance().get(Calendar.YEAR) + "-" + (Calendar.getInstance().get(Calendar.MONTH) + 1) +  "-" + Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        //mStrUrl = tvUrl.getText().toString();
        mStrUrl = "http://news.naver.com/main/ranking/popularDay.nhn?rankingType=popular_day&date=" + YY + MM + DD;
        myRunnable = new MyRunnable(mStrUrl);

        mHandler.post(myRunnable);
*/
    }

    private void initNewsDetailsList() throws ParseException {
        NewsDetailsList lc;

        lc = new NewsDetailsList(R.drawable.article6,getDateString(0));
        mDatasetList.add(lc);
        lc = new NewsDetailsList(R.drawable.article7,getDateString(-1));
        mDatasetList.add(lc);
        lc = new NewsDetailsList(R.drawable.article1,getDateString(-2));
        mDatasetList.add(lc);
        lc = new NewsDetailsList(R.drawable.article4,getDateString(-3));
        mDatasetList.add(lc);
        lc = new NewsDetailsList(R.drawable.article0,getDateString(-4));
        mDatasetList.add(lc);
        lc = new NewsDetailsList(R.drawable.article5,getDateString(-5));
        mDatasetList.add(lc);
        lc = new NewsDetailsList(R.drawable.article2,getDateString(-6));
        mDatasetList.add(lc);

        mRecyclerView = (RecyclerView) findViewById(R.id.card_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MainAdapter(mDatasetList,this);
        mRecyclerView.setAdapter(mAdapter);

    }

    public String getDateString(int iDay) throws ParseException {
        Calendar temp = Calendar.getInstance();
        StringBuffer sbDate = new StringBuffer();
        SimpleDateFormat init,df;
        String USdate;
        Date date;

        temp.add(Calendar.DAY_OF_MONTH, iDay);

        int nYear = temp.get(Calendar.YEAR);
        int nMonth = temp.get(Calendar.MONTH) + 1;
        int nDay = temp.get(Calendar.DAY_OF_MONTH);

        sbDate.append ( nYear );

        if ( nMonth < 10 )
            sbDate.append ( "0" );
        sbDate.append ( nMonth );
        if ( nDay < 10 )
            sbDate.append ( "0" );
        sbDate.append ( nDay );

        init = new SimpleDateFormat("yyyymmdd");
        date = init.parse(sbDate.toString());

        df = new SimpleDateFormat("MMM d", Locale.US);
        USdate = df.format(date);

        return USdate;
    }
}
