package com.example.redemo1.func;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.redemo1.Adapeter.subnAdapeter;
import com.example.redemo1.R;
import com.example.redemo1.type.One_subway;

import java.util.ArrayList;
import java.util.List;

public class Subway2Activity extends AppCompatActivity {
    // 单条地铁线路的页面
    TextView textView;
    Toolbar toolbar;
    RecyclerView recyclerView;
    subnAdapeter adapeter;
    List<One_subway> subwatList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subway2);

        Intent intent=getIntent();
        setTitle(intent.getStringExtra("title"));

        init();

    }

    private void init(){
        textView = findViewById(R.id.textView2);
        toolbar = findViewById(R.id.this_subway_bar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        SharedPreferences sp=this.getSharedPreferences("location", Context.MODE_PRIVATE);
        String mylocation = sp.getString("mylocation","北京");
        // 当前地理位置获取,暂存在location.xml文件中
        textView.setText(mylocation/*+"\n"+sp2.getString("IP","no")*/);
        String [] city=mylocation.split("市");
        Log.d("城市",city[0]);
        Log.d("站点",city[1]);
        String [] names=new String[]{
                "第1站",
                "第2站",
                "建国门站",
                "第4站",
                "第5站"
        };
        subwatList=new ArrayList<>();
        for(String name:names){
            subwatList.add(new One_subway(R.mipmap.sss,R.mipmap.sss,((name.equals(city[1])) ? R.drawable.bg_point1 : R.drawable.bg_point2),name));
}
        recyclerView = findViewById(R.id.recy);
                LinearLayoutManager manager=new LinearLayoutManager(this);
                manager.setOrientation(RecyclerView.HORIZONTAL);
                recyclerView.setLayoutManager(manager);
                adapeter=new subnAdapeter(this,subwatList);
                recyclerView.setAdapter(adapeter);
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