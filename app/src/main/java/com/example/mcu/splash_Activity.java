package com.example.mcu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splash_Activity extends AppCompatActivity {


    //variables
    Animation up_animation,text_animation;
    ImageView splash_logo;
    TextView welcome,to,mcu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_splash_);

        //animation
        up_animation = AnimationUtils.loadAnimation(this,R.anim.up_animation);
        text_animation = AnimationUtils.loadAnimation(this,R.anim.up_animation);


        //hooks
        splash_logo = findViewById(R.id.splash_logo);
        welcome = findViewById(R.id.welcome);
        to = findViewById(R.id.to);
        mcu = findViewById(R.id.mcu);

        splash_logo.setAnimation(up_animation);
        welcome.setAnimation(text_animation);
        to.setAnimation(text_animation);
        mcu.setAnimation(text_animation);

        int SPLASH_SCREEN = 5;
        new Handler().postDelayed(() -> {
            Intent intent= new Intent(splash_Activity.this,login_Activity.class );
            startActivity(intent);
            finish();
        }, SPLASH_SCREEN);
    }
}