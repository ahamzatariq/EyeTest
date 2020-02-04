package com.example.hamza.eyetest;

        import android.content.Intent;
        import android.graphics.Color;
        import android.support.v7.app.ActionBar;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.view.Window;
        import android.view.WindowManager;
        import android.widget.Button;

        import java.util.Random;

public class levelSixteen extends AppCompatActivity {

    int rows = 5;
    int columns = 5;
    int originalColor = 250;
    int fadeColor = 200;
    Button[][] b = new Button[rows][columns];
    int[] color = new int[20];
    int[] fadedColor = new int[20];
    int random = new Random().nextInt(color.length);
    int[] fade = new int[2];
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_level_sixteen);
        initialiseAll();
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
                        Intent wrong = new Intent(levelSixteen.this,levelSeventeen.class);
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
                Intent changeLevel = new Intent(levelSixteen.this,levelSeventeen.class);
                startActivity(changeLevel);
                //overridePendingTransition(0, 0);
                //finish();

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
        b[0][2]=(Button)findViewById(R.id.b13);
        b[0][3]=(Button)findViewById(R.id.b14);
        b[0][4]=(Button)findViewById(R.id.b15);
        b[1][0]=(Button)findViewById(R.id.b21);
        b[1][1]=(Button)findViewById(R.id.b22);
        b[1][2]=(Button)findViewById(R.id.b23);
        b[1][3]=(Button)findViewById(R.id.b24);
        b[1][4]=(Button)findViewById(R.id.b25);
        b[2][0]=(Button)findViewById(R.id.b31);
        b[2][1]=(Button)findViewById(R.id.b32);
        b[2][2]=(Button)findViewById(R.id.b33);
        b[2][3]=(Button)findViewById(R.id.b34);
        b[2][4]=(Button)findViewById(R.id.b35);
        b[3][0]=(Button)findViewById(R.id.b41);
        b[3][1]=(Button)findViewById(R.id.b42);
        b[3][2]=(Button)findViewById(R.id.b43);
        b[3][3]=(Button)findViewById(R.id.b44);
        b[3][4]=(Button)findViewById(R.id.b45);
        b[4][0]=(Button)findViewById(R.id.b51);
        b[4][1]=(Button)findViewById(R.id.b52);
        b[4][2]=(Button)findViewById(R.id.b53);
        b[4][3]=(Button)findViewById(R.id.b54);
        b[4][4]=(Button)findViewById(R.id.b55);

        color[0] = Color.argb(originalColor,113,198,113);
        color[1] = Color.argb(originalColor,142,56,142);
        color[2] = Color.argb(originalColor,255,64,64);
        color[3] = Color.argb(originalColor,60,40,10);
        color[4] = Color.argb(originalColor,238,106,167);
        color[5] = Color.argb(originalColor,139,71,137);
        color[6] = Color.argb(originalColor,75,0,130);
        color[7] = Color.argb(originalColor,100,149,237);
        color[8] = Color.argb(originalColor,99,184,255);
        color[9] = Color.argb(originalColor,30,90,150);
        color[10] = Color.argb(originalColor,128,128,0);
        color[11] = Color.argb(originalColor,233,150,122);
        color[12] = Color.argb(originalColor,47,79,79);
        color[13] = Color.argb(originalColor,124,252,0);
        color[14] = Color.argb(originalColor,0,255,255);
        color[15] = Color.argb(originalColor,0,0,255);
        color[16] = Color.argb(originalColor,255,0,0);
        color[17] = Color.argb(originalColor,220,20,60);
        color[18] = Color.argb(originalColor,85,107,47);
        color[19] = Color.argb(originalColor,0,100,0);

        fade[0]= new Random().nextInt(b.length);
        fade[1]= new Random().nextInt(b[0].length);

        fadedColor[0] = Color.argb(fadeColor,113,198,113);
        fadedColor[1] = Color.argb(fadeColor,142,56,142);
        fadedColor[2] = Color.argb(fadeColor,255,64,64);
        fadedColor[3] = Color.argb(fadeColor,60,40,10);
        fadedColor[4] = Color.argb(fadeColor,238,106,167);
        fadedColor[5] = Color.argb(fadeColor,139,71,137);
        fadedColor[6] = Color.argb(fadeColor,75,0,130);
        fadedColor[7] = Color.argb(fadeColor,100,149,237);
        fadedColor[8] = Color.argb(fadeColor,99,184,255);
        fadedColor[9] = Color.argb(fadeColor,30,90,150);
        fadedColor[10] = Color.argb(fadeColor,128,128,0);
        fadedColor[11] = Color.argb(fadeColor,233,150,122);
        fadedColor[12] = Color.argb(fadeColor,47,79,79);
        fadedColor[13] = Color.argb(fadeColor,124,252,0);
        fadedColor[14] = Color.argb(fadeColor,0,255,255);
        fadedColor[15] = Color.argb(fadeColor,0,0,255);
        fadedColor[16] = Color.argb(fadeColor,255,0,0);
        fadedColor[17] = Color.argb(fadeColor,220,20,60);
        fadedColor[18] = Color.argb(fadeColor,85,107,47);
        fadedColor[19] = Color.argb(fadeColor,0,100,0);

    }

    public void setColor(Button b,int c)
    {
        b.setBackgroundColor(c);
    }
}
