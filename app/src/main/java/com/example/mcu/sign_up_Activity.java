package com.example.mcu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class sign_up_Activity extends AppCompatActivity {


    TextInputLayout username,password,confirm_password,phone_number,e_mail;
    Button sign_up_btn,back_to_login;
    FirebaseDatabase  rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_);

        // hooks
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        confirm_password = findViewById(R.id.confirm_password);
        phone_number = findViewById(R.id.phone_number);
        e_mail = findViewById(R.id.e_mail);
        sign_up_btn = findViewById(R.id.sign_up_btn);
        back_to_login = findViewById(R.id.back_to_login);




            }




    }
