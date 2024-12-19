package com.artofcode.battleofcrossandcircle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class EnterPlayerActivity extends AppCompatActivity {
TextView tvEnterGame;
EditText playerOne;
EditText playerTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_player);
        tvEnterGame=findViewById(R.id.tvEnterGame);
        playerOne=findViewById(R.id.playerOne);
        playerTwo=findViewById(R.id.playerTwo);

        playerOne.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    playerTwo.requestFocus();
                    return true;
                }
                return false;

            }
        });


        playerTwo.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    return true;
                }
                return false;
            }
        });



        tvEnterGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1=playerOne.getText().toString().trim();
                String text2=playerTwo.getText().toString().trim();
                Intent enterGameintent=new Intent(EnterPlayerActivity.this, MainGameActivity.class);
                enterGameintent.putExtra("text1", text1);
                enterGameintent.putExtra("text2", text2);
                startActivity(enterGameintent);
            }
        });


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