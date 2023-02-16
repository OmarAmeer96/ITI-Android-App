package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class PreCalcActivity extends AppCompatActivity {
    Button btn_calc, btn_calc_back, btn_calc_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_calc);

        btn_calc = findViewById(R.id.btn_calc);
        btn_calc_back = findViewById(R.id.btn_calc_back);
        btn_calc_next = findViewById(R.id.btn_calc_next);

        btn_calc.setOnClickListener(v -> {
            Intent intent = new Intent(PreCalcActivity.this, CalcActivity.class);
            startActivity(intent);
            finish();
        });
        btn_calc_back.setOnClickListener(v -> {
            Intent intent = new Intent(PreCalcActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
        btn_calc_next.setOnClickListener(v -> {
            Intent intent = new Intent(PreCalcActivity.this, PreTransferActivity.class);
            startActivity(intent);
            finish();
        });
    }
}