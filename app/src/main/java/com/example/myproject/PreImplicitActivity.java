package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PreImplicitActivity extends AppCompatActivity implements View.OnClickListener {
    Intent intent;
    Button button1, button2, button3, btn_implicit_back, btn_implicit_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_implicit);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 =  findViewById(R.id.button3);
        btn_implicit_back =  findViewById(R.id.btn_implicit_back);
        btn_implicit_next =  findViewById(R.id.btn_implicit_next);


        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        btn_implicit_back.setOnClickListener(this);
        btn_implicit_next.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com"));
                startActivity(intent);
                break;
            case R.id.button2:
                intent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:(+2)01554111002"));
                startActivity(intent);
                break;
            case R.id.button3:
                try {
                    intent = new Intent(Intent.ACTION_SEND);
                    intent.setData(Uri.parse("mailto:"));
                    intent.setType("text/plain");
                    String[] TO = {"omar.ameer244@gmail.com"};
                    String[] CC = {"omar.ameer2333@gmail.com"};
                    intent.putExtra(Intent.EXTRA_EMAIL, TO);
                    intent.putExtra(Intent.EXTRA_CC, CC);
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Mess Subject");
                    intent.putExtra(Intent.EXTRA_TEXT, "Mess Body");
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(this, "Error, There's no email app existed on your phone!", Toast.LENGTH_LONG).show();
                }
                break;
        }

        btn_implicit_back.setOnClickListener(v1 -> {
            Intent intent = new Intent(PreImplicitActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
        btn_implicit_next.setOnClickListener(v1 -> {
            Intent intent = new Intent(PreImplicitActivity.this, SharedPrefActivity.class);
            startActivity(intent);
            finish();
        });
    }
}