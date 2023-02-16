package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class TeamsActivity extends AppCompatActivity {

    Button btn_teams_back, btn_teams_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);

        btn_teams_back = findViewById(R.id.btn_teams_back);
        btn_teams_next = findViewById(R.id.btn_teams_next);

        btn_teams_back.setOnClickListener(v -> {
            Intent intent = new Intent(TeamsActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
        btn_teams_next.setOnClickListener(v -> {
            Intent intent = new Intent(TeamsActivity.this, LifeCycleActivity.class);
            startActivity(intent);
            finish();
        });
    }
}