package com.example.jangjieun.newsker;

import android.app.Activity;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.os.Bundle;

import java.util.Locale;

public class SoundActivity extends Activity implements TextToSpeech.OnInitListener {
    TextToSpeech _tts;
    boolean _ttsActive= false;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);

        str = "아브라카다브라";
        if (_ttsActive == false) {
     //       str = editT.getText().toString();
            _tts.setLanguage(Locale.KOREA);
            _ttsActive = true;
            _tts.speak(str, TextToSpeech.QUEUE_FLUSH, null);
        } else {
            _tts.stop();
            _ttsActive = false;
        }
    }

    @Override
    public void onInit(int status) {}

    @Override
    public void onPause() {
        super.onPause();

        try {
            if (_tts != null ) {
                _tts.stop();
                _ttsActive = false;
            }
        } catch (Exception e) {}
    }

    @Override
    public void onResume() {
        super.onResume();
        _tts = new TextToSpeech(getApplicationContext(), this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        try{
            if(_tts != null) {
                _tts.shutdown();
                _tts = null;
            }
        }
        catch(Exception e) {}
    }
}
