package com.example.redemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LittleAppActivity extends AppCompatActivity {
    TextView textView;
    // 模块功能
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_little_app);

        textView=findViewById(R.id.textView);
        Intent intent=getIntent();
        textView.setText(intent.getStringExtra("title"));
    }
}