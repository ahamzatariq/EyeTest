package com.example.hamza.eyetest;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Final extends AppCompatActivity implements View.OnClickListener{

    private static final int TIME_DELAY = 2000;
    private static long back_pressed;
    private ShareActionProvider mShareActionProvider;


    TextView display;
    Button share;
    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_final);
        changeText();

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    public void onMenu(View view)
    {
        Intent changeLevel = new Intent(Final.this,Menu.class);
        startActivity(changeLevel);
        //overridePendingTransition(0, 0);
        //finish();
    }

    public void onBackPressed() {
        if (back_pressed + TIME_DELAY > System.currentTimeMillis()) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else {
            Toast.makeText(getBaseContext(), "Press Back again to exit",
                    Toast.LENGTH_SHORT).show();
        }
        back_pressed = System.currentTimeMillis();
    }

    public void changeText()
    {
        share = (Button)findViewById(R.id.share);
        share.setOnClickListener(this);
        display = (TextView)findViewById(R.id.score);
        String s = String.format("Your Score: %d", Score.score);
        display.setText(s);
    }

    @Override
    public void onClick(View view)
    {
        message = "I scored "+Score.score+" on EyeTest.\n Check your eye level but not now since we haven't uploaded the application.";
        Intent fbIntent = new Intent(Intent.ACTION_SEND);
        fbIntent.putExtra(Intent.EXTRA_TEXT,message);
        fbIntent.setType("plain/text");
        startActivity(Intent.createChooser(fbIntent,"Share"));
    }

}
