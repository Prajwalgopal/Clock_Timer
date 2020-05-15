package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private Button timerbtn;
    private Button settings;



    MynewSurfaceView surfView = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        surfView = new MynewSurfaceView(this, 500);
       // setContentView(surfView);

        frameLayout=findViewById(R.id.frame1);
        frameLayout.addView(surfView);

        timerbtn=findViewById(R.id.timer);
        settings=findViewById(R.id.button7);


        timerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Hiii","Checkkkk");
                Intent i = new Intent(MainActivity.this, TimerActivity.class);
                startActivity(i);
                Log.e("Hiii","Checkkkk2");


    }
});
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(MainActivity.this,ColorPicker.class);
                startActivity(i1);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        surfView.onResumeSurfaceView();
    }

    @Override
    protected void onPause() {
        super.onPause();
        surfView.onPauseSurfaceView();
    }
}



