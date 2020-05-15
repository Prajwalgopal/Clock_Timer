package com.example.assignment2;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

import java.util.Calendar;

import static android.content.Context.MODE_PRIVATE;
import static android.graphics.Color.BLACK;
import static android.graphics.Color.BLUE;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static android.graphics.Color.WHITE;
import static android.widget.Toast.*;

public class MynewSurfaceView extends SurfaceView implements Runnable {
    private Thread thread = null;
    private SurfaceHolder surfaceHolder;
    private boolean running = false;

    Paint p;
    Canvas c;



    private float length;

    public MynewSurfaceView(Context context, float length) {
        super(context);
        this.length = length;
    }

    public void onResumeSurfaceView() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public void onPauseSurfaceView() {
        boolean retry = true;
        running = false;
        while (retry) {
            try {

                thread.join();
                retry = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public void run() {

        int hour = 0, min = 0, sec = 0, milsec = 0;

        while (running) {
            surfaceHolder = getHolder();

            SharedPreferences sp=this.getContext().getSharedPreferences("mysp", MODE_PRIVATE);

            int mincolor=sp.getInt("mincolor", WHITE);
            if(mincolor==0)
            {
                mincolor=WHITE;
            }

            int hrcolor=sp.getInt("hourcolor", WHITE);
            if(hrcolor==0)
            {
                hrcolor=WHITE;
            }

            int seccolor=sp.getInt("seccolor", WHITE);
            if(seccolor==0)
            {
                seccolor=WHITE;
            }

            int milcolor=sp.getInt("milseccolor", WHITE);
            if(milcolor==0)
            {
                milcolor=WHITE;
            }

            if (surfaceHolder.getSurface().isValid()) {
                Paint paint = new Paint();
                Paint paint1 = new Paint();
                paint1.setColor((Color.BLACK));

                paint.setColor(Color.GREEN);
                paint.setStrokeWidth(5);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStyle(Paint.Style.FILL_AND_STROKE);

                Paint paint2=new Paint();
                paint2.setColor(mincolor);
                paint2.setStrokeWidth(5);

                Paint paint3=new Paint();
                paint3.setColor(hrcolor);
                paint3.setStrokeWidth(5);

                Paint paint4=new Paint();
                paint4.setColor(seccolor);
                paint4.setStrokeWidth(5);

                Paint paint5=new Paint();
                paint5.setColor(milcolor);
                paint5.setStrokeWidth(5);


                Canvas c = surfaceHolder.lockCanvas();
                c.drawPaint(paint1);




                RegPoly secMarks = new RegPoly(60, length -20, getWidth() / 2, getHeight() / 2, c, paint);
                RegPoly hourMarks = new RegPoly(12, length -100, getWidth() / 2, getHeight() / 2, c, paint);
                RegPoly hourHand = new RegPoly(60, length - 200, getWidth() / 2, getHeight() / 2, c, paint3);
                RegPoly minHand = new RegPoly(60, length - 90, getWidth() / 2, getHeight() / 2, c, paint2);
                RegPoly secHand = new RegPoly(60, length - 50, getWidth() / 2, getHeight() / 2, c, paint4);
                RegPoly milhand = new RegPoly(60, length - 600, getWidth() / 3, getHeight() / 2, c, paint5);
                RegPoly milMarks = new RegPoly(60, length -600, getWidth() / 3, getHeight() / 2, c, paint);


                secMarks.drawPoints();
               // hourMarks.drawPoints();
                hourMarks.numerals();
                milMarks.drawPoints();




                // delay 1 sec
                try {
                    Thread.sleep(1000/60);
                    milsec++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
// get the date
                Calendar calendar = Calendar.getInstance();
                hour = calendar.get(Calendar.HOUR);
                min = calendar.get(Calendar.MINUTE);
                sec = calendar.get(Calendar.SECOND);
               // milsec=calendar.get(Calendar.MILLISECOND);
// draw the hands
                secHand.drawRadius(sec + 45);
                minHand.drawRadius(min + 45);
                hourHand.drawRadius(45 + hour * 5 + min / 12);
                milhand.drawRadius(milsec+45);

                surfaceHolder.unlockCanvasAndPost(c);
            }
        }


    }


}


