package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ToastUserActivity extends AppCompatActivity {

    Button button1, button2, button3, btn_toast_user_back, btn_toast_user_next;
    EditText et_1, et_2, et_3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_user);

        button1 = findViewById(R.id.btn_name);
        button2 = findViewById(R.id.btn_pass);
        button3 = findViewById(R.id.btn_email);
        btn_toast_user_back = findViewById(R.id.btn_toast_user_back);
        btn_toast_user_next = findViewById(R.id.btn_toast_user_next);

        et_1 = findViewById(R.id.et_name);
        et_2 = findViewById(R.id.et_pass);
        et_3 = findViewById(R.id.et_email);


        button1.setOnClickListener(v -> {
            Toast.makeText(this, "Your Name is: " + et_1.getText().toString(), Toast.LENGTH_SHORT).show();
        });
        button2.setOnClickListener(v -> {
            Toast.makeText(this, "Your Password is: " + et_2.getText().toString(), Toast.LENGTH_SHORT).show();
        });
        button3.setOnClickListener(v -> {
            Toast.makeText(this, "Your Email is: " + et_3.getText().toString(), Toast.LENGTH_SHORT).show();
        });
        btn_toast_user_back.setOnClickListener(v -> {
            Intent intent = new Intent(ToastUserActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
        btn_toast_user_next.setOnClickListener(v -> {
            Intent intent = new Intent(ToastUserActivity.this, TeamsActivity.class);
            startActivity(intent);
            finish();
        });
    }
}