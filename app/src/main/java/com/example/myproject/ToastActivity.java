package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {

    Button btn_toast1, btn_toast2, btn_toast3, btn_toast_back, btn_toast_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        btn_toast1 = findViewById(R.id.btn_toast1);
        btn_toast2 = findViewById(R.id.btn_toast2);
        btn_toast3 = findViewById(R.id.btn_toast3);
        btn_toast_back = findViewById(R.id.btn_toast_back);
        btn_toast_next = findViewById(R.id.btn_toast_next);

        btn_toast1.setOnClickListener(v -> Toast.makeText(this, "This is Button 1!", Toast.LENGTH_SHORT).show());
        btn_toast2.setOnClickListener(v -> Toast.makeText(this, "This is Button 2!", Toast.LENGTH_SHORT).show());
        btn_toast3.setOnClickListener(v -> Toast.makeText(this, "This is Button 3!", Toast.LENGTH_SHORT).show());

        btn_toast_back.setOnClickListener(v -> {
            Intent intent = new Intent(ToastActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
        btn_toast_next.setOnClickListener(v -> {
            Intent intent = new Intent(ToastActivity.this, LogActivity.class);
            startActivity(intent);
            finish();
        });

    }
}