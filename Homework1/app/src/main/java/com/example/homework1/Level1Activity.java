package com.example.homework1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;

import android.content.SharedPreferences;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;

public class Level1Activity extends AppCompatActivity implements View.OnClickListener {

    private CountDownTimer countDownTimer;
    private long timeLeftInMiliseconds=20000;
    private boolean timerRunning;
    ImageView image1,image2;
    MediaPlayer mediaplayer;
    TextView tv_status,timer;
    Button next_btn,level_btn;
    ImageButton play_btn;
    TextToSpeech t1;




    //Array of animal images
    Integer[] images={
            R.drawable.animal_1,
            R.drawable.animal_2,
            R.drawable.animal_3,
            R.drawable.animal_4,
            R.drawable.animal_5,
            R.drawable.animal_6,
            R.drawable.animal_7,
            R.drawable.animal_8,
            R.drawable.animal_9,
            R.drawable.animal_10,
            R.drawable.animal_11,
            R.drawable.animal_12,
            R.drawable.animal_13,
            R.drawable.animal_14,
            R.drawable.animal_15,
            R.drawable.animal_16,
            R.drawable.animal_17,
            R.drawable.animal_18,
            R.drawable.animal_19,
            R.drawable.animal_20

    };

    //Array of animal sounds
    Integer[] sounds={
            R.raw.animal_1,
            R.raw.animal_2,
            R.raw.animal_3,
            R.raw.animal_4,
            R.raw.animal_5,
            R.raw.animal_6,
            R.raw.animal_7,
            R.raw.animal_8,
            R.raw.animal_9,
            R.raw.animal_10,
            R.raw.animal_11,
            R.raw.animal_12,
            R.raw.animal_13,
            R.raw.animal_14,
            R.raw.animal_15,
            R.raw.animal_16,
            R.raw.animal_17,
            R.raw.animal_18,
            R.raw.animal_19,
            R.raw.animal_20,
    };
    Integer[] images_numbers={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};
    int turn=1;
    int correctAnswer=0;
    public static int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);
        //for shared value score
        SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        score = prefs.getInt("counter", 0);
        editor.putInt("counter", score);
        editor.apply();

        image1=(ImageView)findViewById(R.id.image1);
        image2=(ImageView)findViewById(R.id.image2);
        tv_status=(TextView)findViewById(R.id.tv_status);
        next_btn=(Button)findViewById(R.id.next_button);
        play_btn=(ImageButton) findViewById(R.id.media_btn);
        level_btn=(Button)findViewById(R.id.nextlevel_button);
        timer=(TextView)findViewById(R.id.timer) ;
        timer();




        //random shuffle the images
        Collections.shuffle(Arrays.asList(images_numbers));
        //set the images
        setImages();


        play_btn.setOnClickListener(this);
        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status!=TextToSpeech.ERROR)
                {
                    t1.setLanguage(Locale.ENGLISH);
                }

            }
        });
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaplayer!=null && mediaplayer.isPlaying())
                {
                    mediaplayer.stop();
                }
                //check if correct or wrong
                if(correctAnswer==1){
                    score++;
                  //  tv_status.setText("Correct");
                    t1.speak("Correct answer go to next animals",TextToSpeech.QUEUE_FLUSH,null);
                    next_btn.setVisibility(View.VISIBLE);

                }
                else{
                   // tv_status.setText("Wrong!");
                    t1.speak("Wrong answer  go to next animals",TextToSpeech.QUEUE_FLUSH,null);
                    next_btn.setVisibility(View.VISIBLE);

                }
                //disable images
                image1.setEnabled(false);
                image2.setEnabled(false);

            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if correct or wrong
                if(mediaplayer!=null && mediaplayer.isPlaying())
                {
                    mediaplayer.stop();
                }
                if(correctAnswer==2){
                    score++;
                    t1.speak("Correct answer go to next animals",TextToSpeech.QUEUE_FLUSH,null);
                   // tv_status.setText("Correct");
                    next_btn.setVisibility(View.VISIBLE);

                }
                else{
                   // tv_status.setText("Wrong!");
                    t1.speak("Wrong answer go to next animals",TextToSpeech.QUEUE_FLUSH,null);
                    next_btn.setVisibility(View.VISIBLE);

                }
                //disable images after wrong or correct messages and next button
                image1.setEnabled(false);
                image2.setEnabled(false);

            }
        });
        level_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.stop();

                if(turn==3)
                {
                    openLevel2();
                }
                else
                {
                    setImages();
                }
            }
        });

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //increase turn and finish game if turn equal 10
                turn++;
                if(turn==3)
                {
                    stopTimer();
                    next_btn.setVisibility(View.INVISIBLE);
                    level_btn.setVisibility(View.VISIBLE);
                    t1.speak("You finish level1 go to next level",TextToSpeech.QUEUE_FLUSH,null);
                }
                else
                {
                    setImages();
                }
            }
        });
    }

    private void setImages(){
        //Determine correct answer
        Random r=new Random();
        correctAnswer=r.nextInt(2)+1;

        //Generate random wrong answer
        int wrongAnswer1;

        do{

            wrongAnswer1=r.nextInt(20);
        }while(wrongAnswer1==images_numbers[turn]);

        switch(correctAnswer){
            case 1:
                image1.setImageResource(images[images_numbers[turn]]);
                image2.setImageResource(images[wrongAnswer1]);
                   break;
            case 2:
                image1.setImageResource(images[wrongAnswer1]);
                image2.setImageResource(images[images_numbers[turn]]);
                  break;
        }

        //null stuff
        tv_status.setText("");
        next_btn.setVisibility(View.INVISIBLE);
        level_btn.setVisibility(View.INVISIBLE);

        image1.setEnabled(true);
        image2.setEnabled(true);

    }

    private void openLevel2()
    {
        Intent intent=new Intent(this,Level2Activity.class);
        startActivity(intent);
    }

   @Override
   public void onClick(View v) {
       if(mediaplayer!=null)
       {
           mediaplayer.release();
       }
       switch(v.getId())
       {

           case R.id.media_btn:
               mediaplayer=MediaPlayer.create(this,sounds[images_numbers[turn]]);
               mediaplayer.seekTo(0);
               mediaplayer.start();
               break;



       }

   }
    @Override
    public void onPause() {
        super.onPause();
        // Release the MediaPlayer if going into background if it isn't null
        if(mediaplayer != null) mediaplayer.release();

    }
    public void timer()
    {
        countDownTimer=new CountDownTimer(timeLeftInMiliseconds,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMiliseconds=millisUntilFinished;
                updateTimer();

            }

            @Override
            public void onFinish() {

            }
        }.start();
        timerRunning=true;
    }
    public void updateTimer()
    {
        int minutes=(int)timeLeftInMiliseconds/20000;
        int seconds=(int)timeLeftInMiliseconds % 20000/1000;

        String timeLeftText;
        timeLeftText=""+minutes;
        timeLeftText+=":";

        if(seconds<10) timeLeftText+="0";
        timeLeftText+=seconds;
        timer.setText(timeLeftText);

        if(seconds==1)
        {
            gameOver();
        }

    }
    public void stopTimer()
    {
        countDownTimer.cancel();
        timer.setText("");
        timerRunning=false;
    }

    public void gameOver()
    {
        t1.speak("Time over! Score is "+score,TextToSpeech.QUEUE_FLUSH,null);
        AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(this);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setMessage("Time Over! Score: "+score);
        alertDialogBuilder.setPositiveButton("Best Point", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent=new Intent(getApplicationContext(),BestPointsActivity.class);
                intent.putExtra("SCORE",score);
                startActivity(intent);
            }
        });
        AlertDialog alertDialog=alertDialogBuilder.create();
        alertDialog.show();
    }
}
