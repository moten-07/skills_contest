package com.example.redemo1.func;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.redemo1.R;

public class Subway2Activity extends AppCompatActivity {
    // 单条地铁线路的页面
    TextView textView;
    Toolbar toolbar;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subway2);


        Intent intent=getIntent();
        setTitle(intent.getStringExtra("title"));

        init();

        SharedPreferences sp=this.getSharedPreferences("location", Context.MODE_PRIVATE);
        String mylocation = sp.getString("mylocation","北京");
        // 当前地理位置获取
        textView.setText(mylocation/*+"\n"+sp2.getString("IP","no")*/);
        String [] city=mylocation.split("市");
        Log.d("城市",city[0]);
        Log.d("站点",city[1]);
    }

    private void init(){
        textView = findViewById(R.id.textView2);
        toolbar = findViewById(R.id.this_subway_bar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recy);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // 左上左箭头监听
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return false;
    }

}