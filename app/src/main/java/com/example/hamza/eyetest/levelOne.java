package com.example.hamza.eyetest;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;
import java.util.Random;
import static android.graphics.Color.argb;

public class levelOne extends AppCompatActivity
{
    int rows = 2;
    int columns = 2;
    Button[][] b = new Button[rows][columns];
    int[] color = new int[20];
    int[] fadedColor = new int[20];
    int random = new Random().nextInt(color.length);
    int[] fade = new int[2];

    TextView timerTextView;
    long startTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.level_one);
        initialiseAll();
        Score.score = 0;
        int num1 = 0;
        while(num1!=b.length)
        {
            int num2 = 0;
            while(num2!=b[0].length)
            {
                setColor(b[num1][num2],color[random]);
                num2++;
            }
            num1++;
        }

        setColor(b[fade[0]][fade[1]],fadedColor[random]);

        //if wrong button is pressed
        int num3 = 0;
        while(num3!=b.length)
        {
            int num4 = 0;
            while(num4!=b[0].length)
            {
                b[num3][num4].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        Intent wrong = new Intent(levelOne.this,levelTwo.class);
                        startActivity(wrong);
                        overridePendingTransition(0, 0);
                        //finish();

                    }
                });
                num4++;
            }
            num3++;
        }

        b[fade[0]][fade[1]].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Score.score++;
                Intent changeLevel = new Intent(levelOne.this,levelTwo.class);
                startActivity(changeLevel);
                overridePendingTransition(0, 0);
                //finish();
                //ViewFlipper vf = (ViewFlipper) findViewById(R.id.viewFlipper);
                //vf.showNext();

            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    public void onBackPressed()
    {
        return;
    }

    public void initialiseAll()
    {
        b[0][0]=(Button)findViewById(R.id.b11);
        b[0][1]=(Button)findViewById(R.id.b12);
        b[1][0]=(Button)findViewById(R.id.b21);
        b[1][1]=(Button)findViewById(R.id.b22);

        color[0] = Color.argb(250,113,198,113);
        color[1] = Color.argb(250,142,56,142);
        color[2] = Color.argb(250,255,64,64);
        color[3] = Color.argb(250,60,40,10);
        color[4] = Color.argb(250,238,106,167);
        color[5] = Color.argb(250,139,71,137);
        color[6] = Color.argb(250,75,0,130);
        color[7] = Color.argb(250,100,149,237);
        color[8] = Color.argb(250,99,184,255);
        color[9] = Color.argb(250,30,90,150);
        color[10] = Color.argb(250,128,128,0);
        color[11] = Color.argb(250,233,150,122);
        color[12] = Color.argb(250,47,79,79);
        color[13] = Color.argb(250,124,252,0);
        color[14] = Color.argb(250,0,255,255);
        color[15] = Color.argb(250,0,0,255);
        color[16] = Color.argb(250,255,0,0);
        color[17] = Color.argb(250,220,20,60);
        color[18] = Color.argb(250,85,107,47);
        color[19] = Color.argb(250,0,100,0);

        fade[0]= new Random().nextInt(b.length);
        fade[1]= new Random().nextInt(b[0].length);

        fadedColor[0] = Color.argb(100,113,198,113);
        fadedColor[1] = Color.argb(100,142,56,142);
        fadedColor[2] = Color.argb(100,255,64,64);
        fadedColor[3] = Color.argb(100,60,40,10);
        fadedColor[4] = Color.argb(100,238,106,167);
        fadedColor[5] = Color.argb(100,139,71,137);
        fadedColor[6] = Color.argb(100,75,0,130);
        fadedColor[7] = Color.argb(100,100,149,237);
        fadedColor[8] = Color.argb(100,99,184,255);
        fadedColor[9] = Color.argb(100,30,90,150);
        fadedColor[10] = Color.argb(100,128,128,0);
        fadedColor[11] = Color.argb(100,233,150,122);
        fadedColor[12] = Color.argb(100,47,79,79);
        fadedColor[13] = Color.argb(100,124,252,0);
        fadedColor[14] = Color.argb(100,0,255,255);
        fadedColor[15] = Color.argb(100,0,0,255);
        fadedColor[16] = Color.argb(100,255,0,0);
        fadedColor[17] = Color.argb(100,220,20,60);
        fadedColor[18] = Color.argb(100,85,107,47);
        fadedColor[19] = Color.argb(100,0,100,0);


    }

    public void setColor(Button b,int c)
    {
        b.setBackgroundColor(c);
    }
}
