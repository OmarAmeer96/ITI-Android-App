package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CalcActivity extends AppCompatActivity {

    Button equal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        equal = findViewById(R.id.button_21);

        equal.setOnClickListener(v -> {
            Intent intent = new Intent(CalcActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }


    public void button1_action(View v) {
        Toast.makeText(this, "You Pressed: %", Toast.LENGTH_SHORT).show();
    }

    public void button2_action(View v) {
        Toast.makeText(this, "You Pressed: CE", Toast.LENGTH_SHORT).show();
    }

    public void button3_action(View v) {
        Toast.makeText(this, "You Pressed: C", Toast.LENGTH_SHORT).show();
    }

    public void button4_action(View v) {
        Toast.makeText(this, "You Pressed: bs", Toast.LENGTH_SHORT).show();
    }

    public void button5_action(View v) {
        Toast.makeText(this, "You Pressed: /", Toast.LENGTH_SHORT).show();
    }

    public void button6_action(View v) {
        Toast.makeText(this, "You Pressed: 7", Toast.LENGTH_SHORT).show();
    }

    public void button7_action(View v) {
        Toast.makeText(this, "You Pressed: 8", Toast.LENGTH_SHORT).show();
    }

    public void button8_action(View v) {
        Toast.makeText(this, "You Pressed: 9", Toast.LENGTH_SHORT).show();
    }

    public void button9_action(View v) {
        Toast.makeText(this, "You Pressed: x", Toast.LENGTH_SHORT).show();
    }

    public void button10_action(View v) {
        Toast.makeText(this, "You Pressed: 4", Toast.LENGTH_SHORT).show();
    }

    public void button11_action(View v) {
        Toast.makeText(this, "You Pressed: 5", Toast.LENGTH_SHORT).show();
    }

    public void button12_action(View v) {
        Toast.makeText(this, "You Pressed: 6", Toast.LENGTH_SHORT).show();
    }

    public void button13_action(View v) {
        Toast.makeText(this, "You Pressed: -", Toast.LENGTH_SHORT).show();
    }

    public void button14_action(View v) {
        Toast.makeText(this, "You Pressed: 1", Toast.LENGTH_SHORT).show();
    }

    public void button15_action(View v) {
        Toast.makeText(this, "You Pressed: 2", Toast.LENGTH_SHORT).show();
    }

    public void button16_action(View v) {
        Toast.makeText(this, "You Pressed: 3", Toast.LENGTH_SHORT).show();
    }

    public void button17_action(View v) {
        Toast.makeText(this, "You Pressed: +", Toast.LENGTH_SHORT).show();
    }

    public void button18_action(View v) {
        Toast.makeText(this, "You Pressed: +/-", Toast.LENGTH_SHORT).show();
    }

    public void button19_action(View v) {
        Toast.makeText(this, "You Pressed: 0", Toast.LENGTH_SHORT).show();
    }

    public void button20_action(View v) {
        Toast.makeText(this, "You Pressed: .", Toast.LENGTH_SHORT).show();
    }
}