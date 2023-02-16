package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button_toast, button_log, btn_calc, btn_transfer, btn_toast_user, btn_teams, btn_life, btn_implicit, btn_shared, btn_file, btn_controls, button_close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_toast = findViewById(R.id.btn_1);
        button_close = findViewById(R.id.btn_close);
        button_log = findViewById(R.id.btn_log);
        btn_calc = findViewById(R.id.btn_calc);
        btn_transfer = findViewById(R.id.btn_transfer);
        btn_toast_user = findViewById(R.id.btn_toast_user);
        btn_teams = findViewById(R.id.btn_teams);
        btn_life = findViewById(R.id.btn_life);
        btn_implicit = findViewById(R.id.btn_implicit);
        btn_shared = findViewById(R.id.btn_shared);
        btn_file = findViewById(R.id.btn_file);
        btn_controls = findViewById(R.id.btn_controls);


        button_toast.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ToastActivity.class);
            startActivity(intent);
            finish();
        });
        button_log.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LogActivity.class);
            startActivity(intent);
            finish();
        });
        btn_calc.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PreCalcActivity.class);
            startActivity(intent);
            finish();
        });
        btn_transfer.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PreTransferActivity.class);
            startActivity(intent);
            finish();
        });
        btn_toast_user.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ToastUserActivity.class);
            startActivity(intent);
            finish();
        });
        btn_teams.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TeamsActivity.class);
            startActivity(intent);
            finish();
        });
        btn_life.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LifeCycleActivity.class);
            startActivity(intent);
            finish();
        });
        btn_implicit.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PreImplicitActivity.class);
            startActivity(intent);
            finish();
        });
        btn_shared.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SharedPrefActivity.class);
            startActivity(intent);
            finish();
        });
        btn_file.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FileActivity.class);
            startActivity(intent);
            finish();
        });
        btn_controls.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ControlsActivity.class);
            startActivity(intent);
            finish();
        });
        button_close.setOnClickListener(v -> {
            finish();
            System.exit(0);
        });
    }
}