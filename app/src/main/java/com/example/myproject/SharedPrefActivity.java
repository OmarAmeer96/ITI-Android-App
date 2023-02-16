package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SharedPrefActivity extends AppCompatActivity {
    EditText etName;
    EditText etPassword;

    Button btn_shared_back, btn_shared_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);

        btn_shared_back = findViewById(R.id.btn_shared_back);
        btn_shared_next = findViewById(R.id.btn_shared_next);

        etName = findViewById(R.id.et_name);
        etPassword = findViewById(R.id.et_pass);

        btn_shared_back.setOnClickListener(v -> {
            Intent intent = new Intent(SharedPrefActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
        btn_shared_next.setOnClickListener(v -> {
            Intent intent = new Intent(SharedPrefActivity.this, FileActivity.class);
            startActivity(intent);
            finish();
        });
    }

    public void openActivityB(View view) {
        Intent intent = new Intent(SharedPrefActivity.this, SharedPrefActivity2.class);
        startActivity(intent);
        finish();
    }

    public void storeData(View view) {
        String name = etName.getText().toString();
        String password = etPassword.getText().toString();

        if (name.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Both fields must be filled!", Toast.LENGTH_SHORT).show();
        } else {
            SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("Name", name);
            editor.putString("Password", password);
            editor.apply();
            Toast.makeText(this, "Data is stored successfully!", Toast.LENGTH_SHORT).show();
        }
    }
}

