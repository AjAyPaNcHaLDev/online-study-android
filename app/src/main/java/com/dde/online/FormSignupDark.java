package com.dde.online;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class FormSignupDark extends AppCompatActivity {
    private AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_signup_dark);
    }
    @SuppressLint("InflateParams")
    void verification(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.verification_otp, null));
        builder.setCancelable(false);
        dialog = builder.create();
        dialog.show();
    }
    void dismissdialog() {
        dialog.dismiss();
    }

    public void SignUp(View view) {
        verification(this);
    }

    public void verifyOtp(View view) {
        dismissdialog();
        startActivity(new Intent( FormSignupDark.this,MainActivity.class));

    }

    public void otpResend(View view) {
        Toast .makeText(FormSignupDark.this,"resending...",Toast.LENGTH_SHORT).show();
        Toast .makeText(FormSignupDark.this,"resend success",Toast.LENGTH_SHORT).show();
    }

    public void linkSinIn(View view) {
        startActivity(new Intent( FormSignupDark.this,LoginSimpleDark.class));

    }
}