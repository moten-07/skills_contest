package com.example.redemo1.func;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.redemo1.Adapeter.subwAdapeter;
import com.example.redemo1.MainActivity;
import com.example.redemo1.R;
import com.example.redemo1.type.Subway;
import com.example.redemo1.type.limts;

import java.util.ArrayList;
import java.util.List;

public class SubwayActivity extends AppCompatActivity {
    Toolbar toolbar;
    ListView subway_list;
    TextView textView;
    List<Subway> list;
    subwAdapeter adapeter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subway);
        setTitle("地铁查询");
        init();
        limts limts = new limts(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            limts.getGPS(this);
            // 获取定位
        };
//        textView.setText(limts.getToGps());// 根据经纬度信息判断城市
        where(limts.getE(),limts.getN());

        SharedPreferences sp=this.getSharedPreferences("location", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("mylocation",textView.getText().toString());
        editor.commit();
        // 把地理位置存储在location.xml文件中，文件在data/data/com.example.redemo1/shared_prefs文件夹中
    }

    private void init(){
        toolbar = findViewById(R.id.subway_bar);
        setSupportActionBar(toolbar);


        subway_list = findViewById(R.id.subway_list);
        textView = findViewById(R.id.subway_where);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        list=new ArrayList<Subway>();

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.more:
                        Intent intent = new Intent(SubwayActivity.this, MainActivity.class);
                        intent.putExtra("type","manySubway");
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });
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

    private void getMap(){
        // 地铁线路应该在网络中访问得到结果，此处简化
        switch (textView.getText().toString()){
            case "北京市建国门站":
            case "珠海市金湾区":
                for(int i=1;i<10;i++){
                    list.add(new Subway("地铁示例"+i,
                            "地铁路线"+i,
                            "示例"+i,
                            "示例"+i));
                }
                adapeter=new subwAdapeter(this,list);
                subway_list.setAdapter(adapeter);
                break;

        }
    }

    private void where(double e,double n){
        // 地理位置判断应该在网络中访问得到结果
        if((e>135 || e<79) || (n>53 || n<3)){
            Toast.makeText(this,"为您切换至默认位置：北京市建国门站",Toast.LENGTH_LONG).show();
            textView.setText("北京市建国门站");
        }else if(e>113 && n>22){
            textView.setText("珠海市金湾区");
            Toast.makeText(this,"您的当前位置："+textView.getText(),Toast.LENGTH_SHORT).show();
        }
        getMap();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolmenu,menu);
        return true;
    }

}