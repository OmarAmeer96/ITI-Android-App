package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class TransferActivity extends AppCompatActivity {

    EditText et;
    Button btn2;
    Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);

        et = (EditText) findViewById(R.id.et_1);
        btn2 = (Button) findViewById(R.id.bt_2);
        btn3 = (Button) findViewById(R.id.bt_3);

        btn2.setOnClickListener(v -> {
            Intent i = new Intent();
            i.putExtra("data", et.getText().toString());
            setResult(RESULT_OK, i);
            finish();
        });
        btn3.setOnClickListener(v -> finish());
    }
}