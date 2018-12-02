package com.example.nicol.audiocenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.AudioManager;
import android.content.Context;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        volumeControl = (SeekBar) findViewById(R.id.volumeBar);
        volumeControl.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

             @Override
             public void onStopTrackingTouch(SeekBar seekBar) {
                 // TODO Auto-generated method stub
             }

             @Override
             public void onStartTrackingTouch(SeekBar seekBar) {
                 // TODO Auto-generated method stub
             }

             @Override
             public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                 // TODO Auto-generated method stub
                userVolume = progress;
                System.out.println(userVolume);
                normalizeAudio(userVolume);
             }
         });

    }

    AudioManager audioManager;
    SeekBar volumeControl;
    int userVolume = 50;

    //Volume currently playing
    public int getVolume(){
        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        setVolumeControlStream(audioManager.STREAM_MUSIC);
        int x = audioManager.getStreamVolume(audioManager.STREAM_MUSIC);
        return x;
    }

    public int volumeChange(){
        volumeControl = (SeekBar) findViewById(R.id.volumeBar);
        return volumeControl.getProgress();
    }


    //Change volume to what the user requests, based on what's currently playing
    public void normalizeAudio(int decibelLevel){
        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        audioManager.setStreamVolume(audioManager.STREAM_MUSIC,decibelLevel,0);
    }

}
