package com.moten.DemoA.func;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.moten.DemoA.Adapeter.ordsAdapeter;
import com.moten.DemoA.R;
import com.moten.DemoA.type.Orders;

import java.util.ArrayList;
import java.util.List;

public class userOrderActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView user_order_recy;
    List<Orders> list=new ArrayList<>();

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

        for (int i=0;i<50;i++){
            list.add(new Orders(""+i,""+i,"+i"));
        }
        user_order_recy = findViewById(R.id.user_order_recy);
        user_order_recy.setLayoutManager(new GridLayoutManager(this,5));
        user_order_recy.setAdapter(new ordsAdapeter(this,list));
       indexe indexe=new indexe(10);
       user_order_recy.addItemDecoration(indexe);

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

    class indexe extends RecyclerView.ItemDecoration{
        // 设置图标的间隔
        int space;
        public indexe(int space){
            this.space=space;
        }
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.bottom=space;
            outRect.left=space;
            outRect.right=space;
            outRect.top=space;
        }
    }
}