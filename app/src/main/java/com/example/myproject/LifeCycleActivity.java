package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class LifeCycleActivity extends AppCompatActivity {

    Button btn_life_back, btn_life_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);

        btn_life_back = findViewById(R.id.btn_life_back);
        btn_life_next = findViewById(R.id.btn_life_next);

        btn_life_back.setOnClickListener(v -> {
            Intent intent = new Intent(LifeCycleActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
        btn_life_next.setOnClickListener(v -> {
            Intent intent = new Intent(LifeCycleActivity.this, PreImplicitActivity.class);
            startActivity(intent);
            finish();
        });


        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }
}