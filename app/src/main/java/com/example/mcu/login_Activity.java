package com.example.mcu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class login_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // for full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login_);


        // link from login to sign up
        View callsign_up_Activity = findViewById(R.id.sign_up);
        callsign_up_Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login_Activity.this, sign_up_Activity.class);
                startActivity(intent);

            }
        });
        {

            // link from login to forget password
            View callforgetpassword_Activity = findViewById(R.id.forget_password);
            callforgetpassword_Activity.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(login_Activity.this, forgetpassword_Activity.class);
                    startActivity(intent);
                }
            });
        }

    }
}
