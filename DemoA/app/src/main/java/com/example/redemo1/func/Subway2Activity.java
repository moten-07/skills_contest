package com.example.redemo1.func;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.redemo1.R;

public class Subway2Activity extends AppCompatActivity {
    // 单条地铁线路的页面
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subway2);

        Intent intent=getIntent();
        SharedPreferences sp=this.getSharedPreferences("location", Context.MODE_PRIVATE);
        String mylocation = sp.getString("mylocation","北京");

        textView=findViewById(R.id.textView2);
        // SharedPreferences sp2=this.getSharedPreferences("config", Context.MODE_PRIVATE);
        // 端口获取测试
        textView.setText(mylocation+intent.getStringExtra("title")/*+"\n"+sp2.getString("IP","no")*/);

    }
}