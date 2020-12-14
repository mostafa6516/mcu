package com.example.mcu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class forgetpassword_Activity extends AppCompatActivity {
    ImageView iconback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword_);


        iconback = findViewById(R.id.forget_password_back);

        iconback.setOnClickListener(v -> {
            Intent intent = new Intent(forgetpassword_Activity.this, login_Activity.class);
            startActivity(intent);

        });


    }
}


