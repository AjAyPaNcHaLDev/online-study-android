package com.study.online;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.study.online.R;
import com.study.online.utils.Tools;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;



public class LoginSimpleDark extends AppCompatActivity {

    private View parent_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_simple_dark);
        parent_view = findViewById(android.R.id.content);

        Tools.setSystemBarColor(this, R.color.overlay_light_80);

        ((View) findViewById(R.id.forgot_password)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(parent_view, "Forgot Password", Snackbar.LENGTH_SHORT).show();
            }
        });
        ((View) findViewById(R.id.sign_up)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(parent_view, "Sign Up", Snackbar.LENGTH_SHORT).show();
                startActivity(new Intent(LoginSimpleDark.this,FormSignupDark.class));

            }
        });
        ((View) findViewById(R.id.btn_login)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(parent_view, "Login Success", Snackbar.LENGTH_SHORT).show();
                startActivity(new Intent(LoginSimpleDark.this,MainActivity.class));
            }
        });
    }
}
