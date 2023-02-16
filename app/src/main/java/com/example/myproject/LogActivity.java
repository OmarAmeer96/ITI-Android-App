package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class LogActivity extends AppCompatActivity {
    Button btn_log_v, btn_log_i, btn_log_d, btn_log_e, btn_log_w, btn_log_back, btn_log_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        btn_log_v = findViewById(R.id.btn_log_v);
        btn_log_i = findViewById(R.id.btn_log_i);
        btn_log_d = findViewById(R.id.btn_log_d);
        btn_log_e = findViewById(R.id.btn_log_e);
        btn_log_w = findViewById(R.id.btn_log_w);

        btn_log_back = findViewById(R.id.btn_log_back);
        btn_log_next = findViewById(R.id.btn_log_next);

        btn_log_v.setOnClickListener(v -> {
            Log.v("Omar", "This is V Log");
            Toast.makeText(this, "Log V has Done Successfully!", Toast.LENGTH_SHORT).show();
        });
        btn_log_i.setOnClickListener(v -> {
            Log.i("Omar", "This is I Log");
            Toast.makeText(this, "Log I has Done Successfully!", Toast.LENGTH_SHORT).show();
        });
        btn_log_d.setOnClickListener(v -> {
            Log.d("Omar", "This is D Log");
            Toast.makeText(this, "Log D has Done Successfully!", Toast.LENGTH_SHORT).show();
        });
        btn_log_e.setOnClickListener(v -> {
            Log.e("Omar", "This is E Log");
            Toast.makeText(this, "Log E has Done Successfully!", Toast.LENGTH_SHORT).show();
        });
        btn_log_w.setOnClickListener(v -> {
            Log.w("Omar", "This is W Log");
            Toast.makeText(this, "Log W has Done Successfully!", Toast.LENGTH_SHORT).show();
        });

        btn_log_back.setOnClickListener(v -> {
            Intent intent = new Intent(LogActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
        btn_log_next.setOnClickListener(v -> {
            Intent intent = new Intent(LogActivity.this, PreCalcActivity.class);
            startActivity(intent);
            finish();
        });
    }
}