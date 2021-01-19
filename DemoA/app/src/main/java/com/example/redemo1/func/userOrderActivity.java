package com.example.redemo1.func;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.redemo1.R;
import com.example.redemo1.type.Orders;

import java.util.List;

public class userOrderActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView user_order_recy;
    List<Orders> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_order);
        init();
    }

    private void init(){
        toolbar = findViewById(R.id.this_subway_bar);
        setSupportActionBar(toolbar);
        setTitle("订单列表");
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        user_order_recy = findViewById(R.id.user_order_recy);
        user_order_recy.setLayoutManager(new GridLayoutManager(this,4));

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