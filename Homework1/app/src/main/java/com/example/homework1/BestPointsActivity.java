package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;

public class BestPointsActivity extends AppCompatActivity {
    private ImageButton button1,b_play;
    TextView b_point;
    TextToSpeech t1;
    int score,highScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_points);
        button1=(ImageButton)findViewById(R.id.home_button);
        b_point=(TextView) findViewById(R.id.best_result_point);
        b_play=(ImageButton)findViewById(R.id.bestpoint_play) ;
        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status!=TextToSpeech.ERROR)
                {
                    t1.setLanguage(Locale.ENGLISH);
                }

            }
        });

        score=getIntent().getIntExtra("SCORE",0);
        b_point.setText(score+"");

        SharedPreferences settings=getSharedPreferences("GAME DATA", Context.MODE_PRIVATE);
        highScore=settings.getInt("HIGH_SCORE",0);

        if(score>highScore)
        {
            b_play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    speak1();
                }
            });

            b_point.setText("High Score: "+score);

            //Save
            SharedPreferences.Editor editor=settings.edit();
            editor.putInt("HIGH_SCORE",score);
            editor.commit();
        }
        else
        {
            b_play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    speak2();
                }
            });

            b_point.setText("High Score: "+highScore);
        }
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

    }
    public void openMainActivity()
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void speak1()
    {
        t1.speak("High Score is "+score,TextToSpeech.QUEUE_FLUSH,null);
    }
    public void speak2()
    {
        t1.speak("High Score is "+highScore,TextToSpeech.QUEUE_FLUSH,null);
    }

}
