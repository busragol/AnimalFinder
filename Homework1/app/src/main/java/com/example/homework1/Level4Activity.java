package com.example.homework1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

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
import static com.example.homework1.Level1Activity.score;

import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;

public class Level4Activity extends AppCompatActivity implements View.OnClickListener {

    private CountDownTimer countDownTimer;
    private long timeLeftInMiliseconds=11000;
    private boolean timerRunning;
    ImageView image1,image2,image3,image4,image5,image6;
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
    //int score=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level4);

        image1=(ImageView)findViewById(R.id.image1);
        image2=(ImageView)findViewById(R.id.image2);
        image3=(ImageView)findViewById(R.id.image3);
        image4=(ImageView)findViewById(R.id.image4);
        image5=(ImageView)findViewById(R.id.image5);
        image6=(ImageView)findViewById(R.id.image6);
        tv_status=(TextView)findViewById(R.id.tv_status);
        next_btn=(Button)findViewById(R.id.next_button);
        play_btn=(ImageButton)findViewById(R.id.media_btn);
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
                   // tv_status.setText("Correct");
                    t1.speak("Correct answer go to next animals",TextToSpeech.QUEUE_FLUSH,null);
                    next_btn.setVisibility(View.VISIBLE);

                }
                else{
                    //tv_status.setText("Wrong!");
                    t1.speak("Wrong answer go to next animals",TextToSpeech.QUEUE_FLUSH,null);
                    next_btn.setVisibility(View.VISIBLE);

                }
                //disable images
                image1.setEnabled(false);
                image2.setEnabled(false);
                image3.setEnabled(false);
                image4.setEnabled(false);
                image5.setEnabled(false);
                image6.setEnabled(false);

            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaplayer!=null && mediaplayer.isPlaying())
                {
                    mediaplayer.stop();
                }
                //check if correct or wrong
                if(correctAnswer==2){
                    score++;
                    //tv_status.setText("Correct");
                    t1.speak("Correct answer go to next animals",TextToSpeech.QUEUE_FLUSH,null);
                    next_btn.setVisibility(View.VISIBLE);

                }
                else{
                    //tv_status.setText("Wrong!");
                    t1.speak("Wrong answer go to next animals",TextToSpeech.QUEUE_FLUSH,null);
                    next_btn.setVisibility(View.VISIBLE);

                }
                //disable images
                image1.setEnabled(false);
                image2.setEnabled(false);
                image3.setEnabled(false);
                image4.setEnabled(false);
                image5.setEnabled(false);
                image6.setEnabled(false);

            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaplayer!=null && mediaplayer.isPlaying())
                {
                    mediaplayer.stop();
                }
                //check if correct or wrong
                if(correctAnswer==3){
                    score++;
                    //tv_status.setText("Correct");
                    t1.speak("Correct answer go to next animals",TextToSpeech.QUEUE_FLUSH,null);
                    next_btn.setVisibility(View.VISIBLE);

                }
                else{
                   // tv_status.setText("Wrong!");
                    t1.speak("Wrong answer go to next animals",TextToSpeech.QUEUE_FLUSH,null);
                    next_btn.setVisibility(View.VISIBLE);

                }
                //disable images
                image1.setEnabled(false);
                image2.setEnabled(false);
                image3.setEnabled(false);
                image4.setEnabled(false);
                image5.setEnabled(false);
                image6.setEnabled(false);

            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaplayer!=null && mediaplayer.isPlaying())
                {
                    mediaplayer.stop();
                }
                //check if correct or wrong
                if(correctAnswer==4){
                    score++;
                   // tv_status.setText("Correct");
                    t1.speak("Correct answer go to next animals",TextToSpeech.QUEUE_FLUSH,null);
                    next_btn.setVisibility(View.VISIBLE);

                }
                else{
                    //tv_status.setText("Wrong!");
                    t1.speak("Wrong answer go to next animals",TextToSpeech.QUEUE_FLUSH,null);
                    next_btn.setVisibility(View.VISIBLE);

                }
                //disable images
                image1.setEnabled(false);
                image2.setEnabled(false);
                image3.setEnabled(false);
                image4.setEnabled(false);
                image5.setEnabled(false);
                image6.setEnabled(false);

            }
        });
        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaplayer!=null && mediaplayer.isPlaying())
                {
                    mediaplayer.stop();
                }
                //check if correct or wrong
                if(correctAnswer==5){
                    score++;
                   // tv_status.setText("Correct");
                    t1.speak("Correct answer go to next animals",TextToSpeech.QUEUE_FLUSH,null);
                    next_btn.setVisibility(View.VISIBLE);

                }
                else{
                    //tv_status.setText("Wrong!");
                    t1.speak("Wrong answer go to next animals",TextToSpeech.QUEUE_FLUSH,null);
                    next_btn.setVisibility(View.VISIBLE);

                }
                //disable images
                image1.setEnabled(false);
                image2.setEnabled(false);
                image3.setEnabled(false);
                image4.setEnabled(false);
                image5.setEnabled(false);
                image6.setEnabled(false);

            }
        });
        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaplayer!=null && mediaplayer.isPlaying())
                {
                    mediaplayer.stop();
                }
                //check if correct or wrong
                if(correctAnswer==6){
                    score++;
                  //  tv_status.setText("Correct");
                    t1.speak("Correct answer go to next animals",TextToSpeech.QUEUE_FLUSH,null);
                    next_btn.setVisibility(View.VISIBLE);

                }
                else{
                   // tv_status.setText("Wrong!");
                    t1.speak("Wrong answer go to next animals",TextToSpeech.QUEUE_FLUSH,null);
                    next_btn.setVisibility(View.VISIBLE);

                }
                //disable images
                image1.setEnabled(false);
                image2.setEnabled(false);
                image3.setEnabled(false);
                image4.setEnabled(false);
                image5.setEnabled(false);
                image6.setEnabled(false);

            }
        });
        level_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.stop();
                if(turn==3)
                {
                    openLevel5();
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
                    t1.speak("You finish level4 go to next level",TextToSpeech.QUEUE_FLUSH,null);
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
        correctAnswer=r.nextInt(6)+1;

        //Generate random wrong answer
        int wrongAnswer1;
        int wrongAnswer2;
        int wrongAnswer3;
        int wrongAnswer4;
        int wrongAnswer5;

        do{

            wrongAnswer1=r.nextInt(20);
        }while(wrongAnswer1==images_numbers[turn]);

        do{
            wrongAnswer2=r.nextInt(20);
        }while(wrongAnswer2==images_numbers[turn] || wrongAnswer2==wrongAnswer1);

        do{
            wrongAnswer3=r.nextInt(20);
        }while(wrongAnswer3==images_numbers[turn] || wrongAnswer3==wrongAnswer2 || wrongAnswer3==wrongAnswer1);
        do{
            wrongAnswer4=r.nextInt(20);
        }while(wrongAnswer4==images_numbers[turn] || wrongAnswer4==wrongAnswer3 || wrongAnswer4==wrongAnswer2 || wrongAnswer4==wrongAnswer1);
        do{
            wrongAnswer5=r.nextInt(20);
        }while(wrongAnswer5==images_numbers[turn] || wrongAnswer5==wrongAnswer4 || wrongAnswer5==wrongAnswer3 || wrongAnswer5==wrongAnswer2 || wrongAnswer5==wrongAnswer1);

        switch(correctAnswer){
            case 1:
                image1.setImageResource(images[images_numbers[turn]]);
                image2.setImageResource(images[wrongAnswer1]);
                image3.setImageResource(images[wrongAnswer2]);
                image4.setImageResource(images[wrongAnswer3]);
                image5.setImageResource(images[wrongAnswer4]);
                image6.setImageResource(images[wrongAnswer5]);
                break;
            case 2:
                image1.setImageResource(images[wrongAnswer1]);
                image2.setImageResource(images[images_numbers[turn]]);
                image3.setImageResource(images[wrongAnswer2]);
                image4.setImageResource(images[wrongAnswer3]);
                image5.setImageResource(images[wrongAnswer4]);
                image6.setImageResource(images[wrongAnswer5]);
                break;
            case 3:
                image1.setImageResource(images[wrongAnswer1]);
                image2.setImageResource(images[wrongAnswer2]);
                image3.setImageResource(images[images_numbers[turn]]);
                image4.setImageResource(images[wrongAnswer3]);
                image5.setImageResource(images[wrongAnswer4]);
                image6.setImageResource(images[wrongAnswer5]);
                break;
            case 4:
                image1.setImageResource(images[wrongAnswer1]);
                image2.setImageResource(images[wrongAnswer2]);
                image3.setImageResource(images[wrongAnswer3]);
                image4.setImageResource(images[images_numbers[turn]]);
                image5.setImageResource(images[wrongAnswer4]);
                image6.setImageResource(images[wrongAnswer5]);
                break;
            case 5:
                image1.setImageResource(images[wrongAnswer1]);
                image2.setImageResource(images[wrongAnswer2]);
                image3.setImageResource(images[wrongAnswer3]);
                image4.setImageResource(images[wrongAnswer4]);
                image5.setImageResource(images[images_numbers[turn]]);
                image6.setImageResource(images[wrongAnswer5]);
                break;
            case 6:
                image1.setImageResource(images[wrongAnswer1]);
                image2.setImageResource(images[wrongAnswer2]);
                image3.setImageResource(images[wrongAnswer3]);
                image4.setImageResource(images[wrongAnswer4]);
                image5.setImageResource(images[wrongAnswer5]);
                image6.setImageResource(images[images_numbers[turn]]);
                break;
        }

        //null stuff
        tv_status.setText("");
        next_btn.setVisibility(View.INVISIBLE);
        level_btn.setVisibility(View.INVISIBLE);

        image1.setEnabled(true);
        image2.setEnabled(true);
        image3.setEnabled(true);
        image4.setEnabled(true);
        image5.setEnabled(true);
        image6.setEnabled(true);

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
                break;

        }
        mediaplayer.seekTo(0);
        mediaplayer.start();
    }
    @Override
    public void onPause() {
        super.onPause();
        // Release the MediaPlayer if going into background if it isn't null
        if(mediaplayer != null) mediaplayer.release();
    }



   private void openLevel5()
    {
        Intent intent=new Intent(this,Level5Activity.class);
        startActivity(intent);
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
        int minutes=(int)timeLeftInMiliseconds/11000;
        int seconds=(int)timeLeftInMiliseconds % 11000/1000;

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
