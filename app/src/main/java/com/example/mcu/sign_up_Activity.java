package com.example.mcu;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class sign_up_Activity extends AppCompatActivity {


    // variables
    EditText username, password, confirm_password, phone_number, e_mail, id;
    Button sign_up_btn, back_login;
    // firebase
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_);


        // hooks
        username = findViewById(R.id.username_sign_up);
        password = findViewById(R.id.password_sign_up);
        confirm_password = findViewById(R.id.confirm_password_sign_up);
        phone_number = findViewById(R.id.phone_number_sign_up);
        e_mail = findViewById(R.id.e_mail_sign_up);
        sign_up_btn = findViewById(R.id.sign_up_btn);
        back_login = findViewById(R.id.back_to_login);
        id = findViewById(R.id.id_manager_sign_up);

        // firebase
        firebaseAuth = FirebaseAuth.getInstance();

        findViewById(R.id.sign_up_btn).setOnClickListener(v ->
                sign_up_Activity.this.validationData());
        // link from sign_up_Activity to login_Activity

        back_login.setOnClickListener(v -> {
            Intent intent = new Intent(sign_up_Activity.this, login_Activity.class);
            startActivity(intent);

        });

    }


    private void validationData() {

        String userna = username.getText().toString().trim();
        String pass = password.getText().toString().trim();
        String conpass = confirm_password.getText().toString().trim();
        String phone = phone_number.getText().toString().trim();
        String email = e_mail.getText().toString().trim();
        String idmanger = id.getText().toString().trim();


        //trust data
        // user name
        if (userna.isEmpty()) {
            username.requestFocus();
            // first option
            // Toast.makeText(this, "User name is required", Toast.LENGTH_SHORT).show();


            // change to Alert
            showAlert("User name is required");
            return;
        }
        // password
        if (pass.isEmpty()) {
            password.requestFocus();
            // first option
            //Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();


            // change to Alert
            showAlert("Password is required");
            return;

        }

        if (pass.length() < 8) {
            password.requestFocus();
            //Toast.makeText(this, "Password must be 8 digits", Toast.LENGTH_SHORT).show();


            // change to Alert
            showAlert("Password must be 8 digits");
            return;
        }

        if (conpass.isEmpty()) {
            confirm_password.requestFocus();
           // Toast.makeText(this, "Confirm Password is required", Toast.LENGTH_SHORT).show();


            // change to Alert
            showAlert("Confirm Password is required");
            return;
        }

        if (conpass.length() < 8) {
            confirm_password.requestFocus();
            //Toast.makeText(this, "Confirm Password must be 8 digit", Toast.LENGTH_SHORT).show();


            // change to Alert
            showAlert("Confirm Password must be 8 digit");
            return;
        }

        if (!pass.equals(conpass)) {
            //Toast.makeText(this, "Password not like Confirm Password !", Toast.LENGTH_SHORT).show();


            // change to Alert
            showAlert("Password not like Confirm Password !");
            return;

        }
        // email
        if (email.isEmpty()) {
            e_mail.requestFocus();
            //Toast.makeText(this, "Email is required", Toast.LENGTH_SHORT).show();


            // change to Alert
            showAlert("Email is required");
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            e_mail.requestFocus();
           // Toast.makeText(this, "Invalid Email address \nEmail must be like example@company.com", Toast.LENGTH_SHORT).show();


            // change to Alert
            showAlert("Invalid Email address \nEmail must be like example@company.com");
            return;
        }


        // phone
        if (phone.isEmpty()) {
            phone_number.requestFocus();
           // Toast.makeText(this, "Phone is required", Toast.LENGTH_SHORT).show();


            // change to Alert
            showAlert("Phone is required");
            return;
        }

        if (phone.length() < 11) {
            phone_number.requestFocus();
            //Toast.makeText(this, "Invalid Phone Number \nmust be like 01*********", Toast.LENGTH_SHORT).show();

            // change to Alert
            showAlert("Invalid Phone Number \nmust be like 01*********");
            return;
        }

        // id manager
        if (idmanger.isEmpty()) {
            id.requestFocus();
            //Toast.makeText(this, "ID is required", Toast.LENGTH_SHORT).show();

            // change to Alert
            showAlert("ID is required");
            return;
        }

        if (idmanger.length() < 14) {
            id.requestFocus();
            //Toast.makeText(this, "Invalid ID ", Toast.LENGTH_SHORT).show();


            // change to Alert
            showAlert("Invalid ID");
            return;
        }


       
        // Toast.makeText(this, "valid", Toast.LENGTH_SHORT).show();
        
        
        // to sign up from fire base
        signupwithfirebase(userna,pass);

        {


        }


    }

    private void signupwithfirebase(String userna, String pass) {

        firebaseAuth.createUserWithEmailAndPassword(userna, pass)
                .addOnCompleteListener(new OnCompleteListener< AuthResult >() {
                    @Override
                    public void onComplete(@NonNull Task< AuthResult > task) {

                        if (task.isSuccessful()){


                        }else {
                            showAlert(task.getException().getMessage());
                        }
                    }
                });

    }

    void showAlert(String msg) {
        new AlertDialog.Builder(this)
                .setTitle("attention!")
                .setMessage(msg)
                .setIcon(R.drawable.ic_attention)
                .setPositiveButton("Okay!", null)
                .create().show();
    }
}


