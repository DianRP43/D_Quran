package com.example.cobaquran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splashscreen_activty extends AppCompatActivity {

    private static  int SPLASH_SCREEN = 4000;
    // variables
    Animation topAnim, botAnim;
    ImageView image;
    TextView tittle, desc;

    private static int SPLASH_TIME_OUT = 4500;
    SharedPreferences mshared;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splashscreen);

        //Animation
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        botAnim = AnimationUtils.loadAnimation(this, R.anim.bot_anim);

        //Hooks
        image = findViewById(R.id.ss_header);
        tittle = findViewById(R.id.ss_tittle);
        desc = findViewById(R.id.ss_descr1);


        image.setAnimation(topAnim);
        tittle.setAnimation(botAnim);
        desc.setAnimation(botAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
//            public void run() {
//                Intent intent = new Intent(splashscreen_activty.this,viewpager.class);
//                startActivity(intent);
//                finish();
//            }
//        },SPLASH_SCREEN);
        public void run() {
                mshared = getSharedPreferences("shared",MODE_PRIVATE);
                boolean isFirstTime = mshared.getBoolean("firstTime", true);

                if(isFirstTime){
                    SharedPreferences.Editor editor = mshared.edit();
                    editor.putBoolean("firstTime", false);
                    editor.commit();
                    Intent intent = new Intent(splashscreen_activty.this,viewpager.class);
                startActivity(intent);
                finish();
                } else {
                    Intent intent = new Intent(splashscreen_activty.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }


        }
    },SPLASH_TIME_OUT);
    }
}