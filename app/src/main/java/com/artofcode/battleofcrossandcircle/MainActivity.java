package com.artofcode.battleofcrossandcircle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaPlayer stmusic=MediaPlayer.create(MainActivity.this,R.raw.stmusic);
        stmusic.start();

        Thread thread=new Thread() {
            public void run() {
                try {
                    sleep(4000);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                finally {
                    Intent myintent = new Intent(MainActivity.this, EnterPlayerActivity.class);
                    startActivity(myintent);
                    finish();
                }

            }
        };
        thread.start();

    }
}