package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class login extends AppCompatActivity {
    TextInputEditText EditTextEmail, EditTextPass;
    AppCompatButton login;
    Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login=findViewById(R.id.logIn_btn);
        signup=findViewById(R.id.signup_screen);
         EditTextEmail=findViewById(R.id.email4);
        EditTextPass=findViewById(R.id.password10);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(com.example.test.login.this, signup.class);
                startActivity(intent);

            }
        });

    }
}