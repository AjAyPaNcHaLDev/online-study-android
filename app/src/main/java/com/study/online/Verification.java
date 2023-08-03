package com.study.online;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Verification extends AppCompatActivity {
    TextInputEditText t1,t2,t3,t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);

        t1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (t1.getText().length() == 1)
                    t2.requestFocus();

                return false;
            }
        });
        t2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (t2.getText().length() == 1)
                    t3.requestFocus();
                else
                if (t2.getText().toString().isEmpty())
                    t1.requestFocus();
                return false;
            }
        });
        t3.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (t3.getText().length() == 1)
                    t4.requestFocus();else
                if (t3.getText().toString().isEmpty())
                    t2.requestFocus();
                return false;
            }
        });
        t4.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (t4.getText().length() == 0)
                    t3.requestFocus();

                return false;
            }
        });
    }



    public void verifyOtp(View view) {
//        dismissdialog();
        startActivity(new Intent( Verification.this,MainActivity.class));

    }

    public void otpResend(View view) {
        Toast.makeText(Verification.this,"resending...",Toast.LENGTH_SHORT).show();
        Toast .makeText(Verification.this,"resend success",Toast.LENGTH_SHORT).show();
    }

}