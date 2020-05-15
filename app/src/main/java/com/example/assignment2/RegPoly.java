package com.example.assignment2;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class RegPoly {
    private float x0,y0,r;
    private int n;
    private float x[],y[];

    private Canvas c=null;
    private Paint p=null;
    Rect rect=new Rect();
    float textsixe=50f;

    public RegPoly(int n,float r,float x0,float y0,Canvas c,Paint p) {

    this.n=n;
    this.r=r;
    this.x0=x0;
    this.y0=y0;
    this.c=c;
    this.p=p;
    x=new float[n];
    y=new float[n];
        for(int i =0;i<n;i++)
        {

            x[i] = (float)(x0 + r * Math.cos(2*Math.PI*i/n));
            y[i] = (float)(y0 + r * Math.sin(2*Math.PI*i/n));
        }


    }

    public float getX(int i) {
        return x[i%n];
    }
    public float getY(int i) {
        return y[i%n];
    }
    public void drawRegPoly()
    {
        for(int i=0;i<n;i++)
        {
            c.drawLine(x[i], y[i], x[(i+1)%n], y[(i+1)%n], p);
        }
    }
    public void drawPoints()
    {
        for(int i=0;i<n;i++)
        {
            c.drawCircle(x[i], y[i], 4, p);

        }
    }

    public void drawRadius(int i)
    {
        c.drawLine(x0, y0, x[i%n], y[i%n], p);
    }


    public void numerals(){
        p.setTextSize(textsixe);
        p.setColor(Color.WHITE);
        for(int i=0;i<n;i++)
        {
            String[]  numbers = {"3","4","5","6","7","8","9","10","11","12","1","2"};
            String num=numbers[i];
            c.drawText(num,x[i],y[i],p);

        }
    }
}
