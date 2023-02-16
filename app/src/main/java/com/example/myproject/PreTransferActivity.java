package com.example.myproject;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class PreTransferActivity extends AppCompatActivity {

    Button btn_transfer, btn_transfer_back, btn_transfer_next;
    TextView tv_transfer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_transfer);
        btn_transfer = (Button) findViewById(R.id.btn_transfer);
        tv_transfer = (TextView) findViewById(R.id.tv_transfer);
        btn_transfer_back = (Button) findViewById(R.id.btn_transfer_back);
        btn_transfer_next = (Button) findViewById(R.id.btn_transfer_next);

        @SuppressLint("SetTextI18n") ActivityResultLauncher<Intent> launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            String s = data.getStringExtra("data");
                            tv_transfer.setText("The text you entered is: " + s);
                        }
                    }
                });
        btn_transfer.setOnClickListener(v -> launcher.launch(new Intent(PreTransferActivity.this, TransferActivity.class)));

        btn_transfer_back.setOnClickListener(v -> {
            Intent intent = new Intent(PreTransferActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
        btn_transfer_next.setOnClickListener(v -> {
            Intent intent = new Intent(PreTransferActivity.this, ToastUserActivity.class);
            startActivity(intent);
            finish();
        });
    }
}