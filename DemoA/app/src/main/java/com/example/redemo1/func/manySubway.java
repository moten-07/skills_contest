package com.example.redemo1.func;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.redemo1.Adapeter.sub3Adapeter;
import com.example.redemo1.R;

public class manySubway extends AppCompatActivity {
    ListView listView;
    ImageView imageView;
    sub3Adapeter adapeter;
    String []list;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_many_subway);

        toolbar = findViewById(R.id.subway_bar);
        setSupportActionBar(toolbar);
        setTitle("地铁总览");
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        SharedPreferences sp=this.getSharedPreferences("location", Context.MODE_PRIVATE);
        String mylocation = sp.getString("mylocation","北京");
        String [] city=mylocation.split("市");
        listView=findViewById(R.id.subway_overList);
        imageView = findViewById(R.id.subway_overview);
        switch (city[0]){
            case "北京":
                imageView.setImageResource(R.mipmap.subway_beijin);
                list=this.getResources().getStringArray(R.array.sub_beijing);
                adapeter = new sub3Adapeter(list,this);
                listView.setAdapter(adapeter);
                break;
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