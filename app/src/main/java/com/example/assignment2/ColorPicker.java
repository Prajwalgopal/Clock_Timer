package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import yuku.ambilwarna.AmbilWarnaDialog;

public class ColorPicker extends AppCompatActivity {

    private Button mincolor;
    private Button sav,clr;
    private int initialColor;
    private int mininitialColor;
    private int hrinitialColor;
    private int secinitialColor;
    private int milinitialColor;
    private Button hrcolor;
    private Button seccolor;
    private Button milcolor;


    SharedPreferences sp;
    public static final String mysp="mysp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);

        mincolor=findViewById(R.id.Minute);
        hrcolor=findViewById(R.id.hour);
        seccolor=findViewById(R.id.sec);
        milcolor=findViewById(R.id.mil);

        sav=findViewById(R.id.Save);
        clr=findViewById(R.id.clrbutton);
        initialColor= ContextCompat.getColor(ColorPicker.this, R.color.colorPrimary);
        sp=getSharedPreferences(mysp,MODE_PRIVATE);


        mincolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mincolorPicker();
            }
        });
        hrcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hrcolorPicker();
            }
        });

        seccolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seccolorPicker();
            }
        });

        milcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                milcolorPicker();
            }
        });

        sav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor e= sp.edit();
                e.putInt("mincolor", mininitialColor);
                e.putInt("hourcolor", hrinitialColor);
                e.putInt("seccolor", secinitialColor);
                e.putInt("milseccolor", milinitialColor);
                e.commit();
                Toast.makeText(ColorPicker.this, "Saved", Toast.LENGTH_SHORT).show();

            }
        });

        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor e= sp.edit();
                e.clear();
                e.commit();
                Toast.makeText(ColorPicker.this, "All settings cleared", Toast.LENGTH_SHORT).show();

            }
        });

    }


    public void mincolorPicker(){
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, initialColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
                // cancel was selected by the user
            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                // color is the color selected by the user.
                initialColor=color;
                mincolor.setBackgroundColor(initialColor);
                mininitialColor = initialColor;


            }
        });

        colorPicker.show();
    }

    public void hrcolorPicker(){
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, initialColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
                // cancel was selected by the user
            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                // color is the color selected by the user.
                initialColor=color;
                hrcolor.setBackgroundColor(initialColor);
                hrinitialColor=initialColor;


            }
        });

        colorPicker.show();
    }
    public void seccolorPicker(){
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, initialColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
                // cancel was selected by the user
            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                // color is the color selected by the user.
                initialColor=color;
                seccolor.setBackgroundColor(initialColor);
                secinitialColor = initialColor;


            }
        });

        colorPicker.show();
    }
    public void milcolorPicker(){
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, initialColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
                // cancel was selected by the user
            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                // color is the color selected by the user.
                initialColor=color;
                milcolor.setBackgroundColor(initialColor);
                milinitialColor=initialColor;

            }
        });

        colorPicker.show();
    }



}
