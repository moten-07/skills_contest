package com.example.redemo1.func;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.redemo1.R;

public class SubwayActivity extends AppCompatActivity {
    Toolbar toolbar;
    ListView subway_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subway);
        setTitle("地铁查询");
        init();

    }

    private void init(){
        toolbar = findViewById(R.id.subway_bar);
        setSupportActionBar(toolbar);

        subway_list = findViewById(R.id.subway_list);

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