package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private ImageButton button1;
    private ImageButton button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1=(ImageButton)findViewById(R.id.play_button);
        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                openLevel1Activity();

            }


        });

        button2=(ImageButton)findViewById(R.id.best_points_button);
        button2.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                openBestPointsActivity();
            }
        });
    }
    public void openLevel1Activity(){
        Intent intent=new Intent(this,Level1Activity.class);
        startActivity(intent);
    }
    public void openBestPointsActivity()
    {
        Intent intent=new Intent(this,BestPointsActivity.class);
        startActivity(intent);
    }

}
