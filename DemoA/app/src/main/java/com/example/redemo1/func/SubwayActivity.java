package com.example.redemo1.func;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.example.redemo1.Adapeter.subwAdapeter;
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
        limts limts=new limts(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            limts.getGPS(this);
            // 获取定位
        };
        // 根据经纬度信息判断城市，仅精确到小数点后2位，数据稍作处理(重庆可能得再加个海拔😂)
        switch (limts.getToGps()){
            // case "E:-122.08,N:37.42":
            //     // 01.14测试结果
            //     textView.setText("美国旧金山");
            //     break;
            default:
                textView.setText("北京建国门站");
                break;
        }
        getMap();
    }

    private void init(){
        toolbar = findViewById(R.id.subway_bar);
        setSupportActionBar(toolbar);

        subway_list = findViewById(R.id.subway_list);
        textView = findViewById(R.id.subway_where);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        list=new ArrayList<Subway>();

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
        switch (textView.getText().toString()){
            case "北京建国门站":
                for(int i=1;i<=4;i++){
                    list.add(new Subway("T"+i,"ts"+i,"sn"+i,"st"+i));
                }
                adapeter=new subwAdapeter(this,list);
                subway_list.setAdapter(adapeter);
                break;
        }
    }
}