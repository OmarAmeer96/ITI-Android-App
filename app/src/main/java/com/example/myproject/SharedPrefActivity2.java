package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SharedPrefActivity2 extends AppCompatActivity {

    final String DEFAULT = "Default Value";
    TextView text_view_name, text_view_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref2);

        text_view_name = findViewById(R.id.text_view_name);
        text_view_pass = findViewById(R.id.text_view_pass);
    }

    public void openActivityA(View view) {
        Intent intent = new Intent(SharedPrefActivity2.this, SharedPrefActivity.class);
        startActivity(intent);
        finish();
    }

    public void loadData(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("Name", DEFAULT);
        String password = sharedPreferences.getString("Password", DEFAULT);

        if (name.equals(DEFAULT) || password.equals(DEFAULT)) {
            Toast.makeText(this, "Default data are loaded.", Toast.LENGTH_SHORT).show();
        } else {
            text_view_name.setText(name);
            text_view_pass.setText(password);
            Toast.makeText(this, "Data has loaded successfully!", Toast.LENGTH_SHORT).show();
        }
    }
}
