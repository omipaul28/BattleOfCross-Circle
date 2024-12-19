package com.artofcode.battleofcrossandcircle;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainGameActivity extends AppCompatActivity {
    TextView playerBoardOne;
    TextView playerBoardTwo;



int PlayerActivity=0;
int count=0;
int []GameActivity={2,2,2,2,2,2,2,2,2};

    public void TapGrid(View myview){
        ImageView tempImage=(ImageView) myview;
        int TapedImage=Integer.parseInt(tempImage.getTag().toString());
        if(GameActivity[TapedImage]==2){
            count++;
            GameActivity[TapedImage]=PlayerActivity;
            if(PlayerActivity==0){
                tempImage.setImageResource(R.drawable.x);
                PlayerActivity=1;
            }else{
                tempImage.setImageResource(R.drawable.o);
                PlayerActivity=0;
            }
        }

        String winner1=getIntent().getStringExtra("text1");
        String winner2=getIntent().getStringExtra("text2");
        Intent Rintent=new Intent(MainGameActivity.this, GameResultActivity.class);
        if(PlayerActivity==1){
            MediaPlayer x=MediaPlayer.create(MainGameActivity.this, R.raw.xtone);
            x.start();
        Rintent.putExtra("winner", winner1);
        Rintent.putExtra("flag","1");
        }else if(PlayerActivity==0){

            MediaPlayer o=MediaPlayer.create(MainGameActivity.this, R.raw.otone);
            o.start();
         Rintent.putExtra("winner", winner2);
            Rintent.putExtra("flag","2");
        }
        if(count>4){
            if((GameActivity[0]==GameActivity[1])&&(GameActivity[1]==GameActivity[2])&&(GameActivity[0]!=2)){
                //1
                startActivity(Rintent);
            }else if((GameActivity[3]==GameActivity[4])&&(GameActivity[4]==GameActivity[5])&&(GameActivity[3]!=2)){
                //2
                startActivity(Rintent);
            }else if((GameActivity[6]==GameActivity[7])&&(GameActivity[7]==GameActivity[8])&&(GameActivity[6]!=2)){
                //3
                startActivity(Rintent);
            }else if((GameActivity[0]==GameActivity[3])&&(GameActivity[3]==GameActivity[6])&&(GameActivity[0]!=2)){
                //4
                startActivity(Rintent);
            }else if((GameActivity[1]==GameActivity[4])&&(GameActivity[4]==GameActivity[7])&&(GameActivity[1]!=2)){
                //5
                startActivity(Rintent);
            } else if((GameActivity[2]==GameActivity[5])&&(GameActivity[5]==GameActivity[8])&&(GameActivity[2]!=2)){
                //6
                startActivity(Rintent);
            }else if((GameActivity[0]==GameActivity[4])&&(GameActivity[4]==GameActivity[8])&&(GameActivity[0]!=2)){
                //7
                startActivity(Rintent);
            }else if((GameActivity[2]==GameActivity[4])&&(GameActivity[4]==GameActivity[6])&&(GameActivity[2]!=2)){
                //8
                startActivity(Rintent);
            }else if(count==9){
                Rintent.putExtra("flag","3");
                startActivity(Rintent);
            }



        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);
        playerBoardOne=findViewById(R.id.playerBoardOne);
        playerBoardTwo=findViewById(R.id.playerBoardTwo);
        String name1=getIntent().getStringExtra("text1");
        String name2=getIntent().getStringExtra("text2");
        playerBoardOne.setText(name1);
        playerBoardTwo.setText(name2);
    }

    @Override
    public void onBackPressed() {
        // Leave this method empty to disable the back button
    }

}