package com.example.mcu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class login_Activity extends AppCompatActivity {

    Button callsignup, login_btn, forgetpasswod;
    ImageView loginlogo;
    TextView welcomeback, sign_in_to_continue;
    TextInputLayout username, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // for full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login_);


        //HOOKS
        callsignup = findViewById(R.id.sign_up);
        login_btn = findViewById(R.id.login_btn);
        forgetpasswod = findViewById(R.id.forget_password);
        loginlogo = findViewById(R.id.login_logo);
        welcomeback = findViewById(R.id.welcome_back);
        sign_in_to_continue = findViewById(R.id.sign_in_to_continue);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);


        // link from login to sign up
        callsignup.setOnClickListener(v -> {
            Intent intent = new Intent(login_Activity.this, sign_up_Activity.class);

            Pair[] pairs = new Pair[7];

            pairs[0] = new Pair< View, String >(loginlogo, "logo_image");
            pairs[1] = new Pair< View, String >(welcomeback, "logo_text");
            pairs[2] = new Pair< View, String >(sign_in_to_continue, "logo_desc");
            pairs[3] = new Pair< View, String >(username, "username_tran");
            pairs[4] = new Pair< View, String >(password, "password_tran");
            pairs[5] = new Pair< View, String >(forgetpasswod, "forget_tran");
            pairs[6] = new Pair< View, String >(login_btn, "button_tran");

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(login_Activity.this, pairs);
                startActivity(intent, options.toBundle());
            }

        });
        {


            // link from login to forget password

            forgetpasswod.setOnClickListener(v -> {
                Intent intent = new Intent(login_Activity.this, forgetpassword_Activity.class);
                login_Activity.this.startActivity(intent);
            });
        }

    }
}
