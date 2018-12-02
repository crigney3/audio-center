package com.example.nicol.audiocenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.AudioManager;
import android.content.Context;
import android.widget.SeekBar;


public class MainActivity extends AppCompatActivity {

    AudioManager audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        normalizeAudio(getVolume());
    }

    //Volume currently playing
    public int getVolume(){
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        int x = audioManager.getStreamVolume(15);
        return x;
    }

    public int volumeChange(){
        SeekBar volumeControl = (SeekBar) findViewById(R.id.volumeBar);
        return volumeControl.getProgress();
    }


    //Change volume to what the user requests, based on what's currently playing
    public void normalizeAudio(int decibelLevel){
        audioManager.setStreamVolume(15,decibelLevel,0);
    }

}
