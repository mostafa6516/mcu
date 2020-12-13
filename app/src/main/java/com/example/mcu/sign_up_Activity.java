package com.example.mcu;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class sign_up_Activity extends AppCompatActivity {


    // variables
    TextInputLayout username, password, confirm_password, phone_number, e_mail;
    Button sign_up_btn, back_to_login;



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


        findViewById(sign_up_btn).setOnClickListener(v -> {
          validationData();
        });


    }


    private void validationData() {

        String userna = username.getEditText().toString().trim();
        String pass = password.getEditText().toString().trim();
        String conpass = confirm_password.getEditText().toString().trim();
        String phone = phone_number.getEditText().toString().trim();
        String email = e_mail.getEditText().toString().trim();




        //trust data

        if (userna.isEmpty()){
            username.requestFocus();
            Toast.makeText(this, "User name is required", Toast.LENGTH_SHORT).show();
            return;
        }

        if (pass.isEmpty()) {
            password.requestFocus();
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
            return;
        }

          if (pass.length()<8){
              password.requestFocus();
              Toast.makeText(this, "Password must be 8 digit", Toast.LENGTH_SHORT).show();
              return;
          }

        if (conpass.isEmpty()) {
            confirm_password.requestFocus();
            Toast.makeText(this, "Confirm Password is required", Toast.LENGTH_SHORT).show();
            return;
        }

        if (conpass.length()<8){
            confirm_password.requestFocus();
            Toast.makeText(this, "Confirm Password must be 8 digit", Toast.LENGTH_SHORT).show();
            return;
        }

          if (! pass.equals(conpass)){
              Toast.makeText(this, "Password not equals Confirm Password !", Toast.LENGTH_SHORT).show();
              return;

          }

        if (phone.isEmpty()){
            phone_number.requestFocus();
            Toast.makeText(this, "Phone is required", Toast.LENGTH_SHORT).show();
            return;
        }

        if (phone.length()<11){
            phone_number.requestFocus();
            Toast.makeText(this, "Invalid Phone Number \nmust be like 01*********", Toast.LENGTH_SHORT).show();
            return;
        }


        if (email.isEmpty()){
            e_mail.requestFocus();
            Toast.makeText(this, "Email is required", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            e_mail.requestFocus();
            Toast.makeText(this, "Invalid Email address \nEmail must be like example@company.com", Toast.LENGTH_SHORT).show();
            return;
        }


        Toast.makeText(this, "valid", Toast.LENGTH_SHORT).show();

    }


}
