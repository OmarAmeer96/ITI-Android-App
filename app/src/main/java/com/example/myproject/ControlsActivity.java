package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ControlsActivity extends AppCompatActivity {

    Button btn_controls_back, btn_scroll_view, btn_buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controls);

        btn_controls_back = findViewById(R.id.btn_controls_back);
        btn_scroll_view = findViewById(R.id.btn_scroll_view);
        btn_buttons = findViewById(R.id.btn_buttons);

        btn_scroll_view.setOnClickListener(v -> {
            Intent intent = new Intent(ControlsActivity.this, ScrollViewActivity.class);
            startActivity(intent);
            finish();
        });
        btn_buttons.setOnClickListener(v -> {
            Intent intent = new Intent(ControlsActivity.this, ButtonsActivity.class);
            startActivity(intent);
            finish();
        });
        btn_controls_back.setOnClickListener(v -> {
            Intent intent = new Intent(ControlsActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}