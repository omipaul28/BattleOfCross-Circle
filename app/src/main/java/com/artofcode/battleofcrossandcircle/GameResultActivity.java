package com.artofcode.battleofcrossandcircle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GameResultActivity extends AppCompatActivity {
    TextView tvResult;
    TextView btnPlayAgain;
    LinearLayout resultBG;
    private MediaPlayer winMusic; // Declare winMusic here

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_result);
        tvResult = findViewById(R.id.tvResult);
        btnPlayAgain = findViewById(R.id.btnPlayAgain);
        resultBG = findViewById(R.id.resultBG);

        String getFlag = getIntent().getStringExtra("flag");
        int FinalFlag = Integer.parseInt(getFlag);
        String FinalResult = getIntent().getStringExtra("winner");

        if (FinalFlag == 3) {
            tvResult.setText("DRAW");
        } else if (FinalFlag == 1) {
            resultBG.setBackgroundResource(R.color.x);
            tvResult.setText("Winner Is\n" + FinalResult);
            winMusic = MediaPlayer.create(GameResultActivity.this, R.raw.win); // Initialize winMusic
            winMusic.start();
        } else if (FinalFlag == 2) {
            resultBG.setBackgroundResource(R.color.o);
            tvResult.setText("Winner Is\n" + FinalResult);
            winMusic = MediaPlayer.create(GameResultActivity.this, R.raw.win); // Initialize winMusic
            winMusic.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (winMusic != null) {
            winMusic.release();
            winMusic = null;
        }
    }

    protected void onPause() {
        super.onPause();
        if (winMusic != null && winMusic.isPlaying()) {
            winMusic.pause();
        }
    }

    protected void onResume() {
        super.onResume();

        if (winMusic != null && !winMusic.isPlaying()) {
            winMusic.start();
        }
    }

    public void playAgain(View view) {
        if (winMusic != null && winMusic.isPlaying()) {
            winMusic.stop();
            winMusic.release();
            winMusic = null;
        }
        Intent restartIntent = new Intent(GameResultActivity.this, EnterPlayerActivity.class);
        startActivity(restartIntent);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
