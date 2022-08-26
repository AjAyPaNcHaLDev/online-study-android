package com.dde.online;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
    }

    public void SignIn(View view) {


        startActivity(new Intent(WelcomeScreen.this,LoginSimpleDark.class));
    }

    public void startWithFree(View view) {

        startActivity(new Intent(WelcomeScreen.this,FormSignupDark.class));
    }


}