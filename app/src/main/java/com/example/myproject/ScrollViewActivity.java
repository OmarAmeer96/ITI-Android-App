package com.example.myproject;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ScrollViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);
    }

    public void back2widget(View view) {
        Intent i = new Intent(ScrollViewActivity.this, ControlsActivity.class);
        startActivity(i);
        finish();
    }
}
