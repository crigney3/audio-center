package com.example.nicol.audiocenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public int volumeChange(){
        SeekBar volumeControl = (SeekBar) findViewById(R.id.volumeBar);
        return volumeControl.getProgress();
    }
}
