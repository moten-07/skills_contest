package com.moten.DemoA.func;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.moten.DemoA.Adapeter.newsAdapeter;
import com.moten.DemoA.R;
import com.moten.DemoA.aboutIntent.UserOkhttp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewActivity extends AppCompatActivity implements View.OnClickListener{
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    List<View> list;
    UserOkhttp userOkhttp;
    Intent intent ;
    int newsID;

    TextView new_title,new_details,new_date,new_viewNumber,like_number;
    ImageView like_this_new_icon;
    LinearLayout cal,write_comm,go_to_comment,like_this_new;
    RecyclerView recyclerView,recyclerView1;
    EditText comm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        intent =getIntent();
        toolbar = findViewById(R.id.newBar);
        setSupportActionBar(toolbar);
        setTitle("新闻详情");
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        tabLayout = findViewById(R.id.tab_rac);
        viewPager = findViewById(R.id.vp_rac);
        list = new ArrayList<>();
        userOkhttp = new UserOkhttp();

        list.add(LayoutInflater.from(this).inflate(R.layout.item_news,null));
        list.add(LayoutInflater.from(this).inflate(R.layout.item_news,null));

        init();
        initDate();
        aboutViewPager();

        newsID=intent.getIntExtra("newsId",0);
        getNewsList();//推荐新闻
        new UserOkhttp().getCommentsList(1,100,newsID,recyclerView1);     // 本条新闻的评论

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("推荐");
        tabLayout.getTabAt(1).setText("评论");
    }

    private void getNewsList(){
        List<TNLJ.Rows>list = new ArrayList<>();
        new Thread(()->{
            userOkhttp.getNewsLists(1,100);
            runOnUiThread(()->{
                int [] ran = new int[3];
                for (int i = 0;i<3;i++){
                    ran[i] = new Random().nextInt(userOkhttp.getNList().size());
                    TNLJ.Rows tr = userOkhttp.getNList().get(ran[i]);
                    if (tr.getId()!=newsID && i!=0 && i!=i-1){
                        list.add(tr);
                    }
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(new newsAdapeter(this,/*推荐新闻列表*/list));
            });
        }).start();

    }

    private void aboutViewPager(){
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount(){return list.size();}
            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) { return view == object; }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                View view1 = list.get(position);
                container.addView(view1);
                return view1;
            }
            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                if (list.size()>0){
                    container.removeView(list.get(position));
                }
            }
        });
    }

    Boolean like = false;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.like_this_new:
                // 这个点赞假的哟，没接口，只有效果
                if (!like){
                    like_this_new_icon.setImageResource(R.drawable.ic_baseline_favorite_24);
                    like = true;
                    Toast.makeText(NewActivity.this,"没给接口，点了没有用的，就只有效果",Toast.LENGTH_SHORT).show();
                    like_number.setText(Integer.valueOf(like_number.getText().toString())+1+"");
                }else {
                    like_this_new_icon.setImageResource(R.drawable.ic_baseline_favorite_border_24);
                    like = false;
                    like_number.setText(Integer.valueOf(like_number.getText().toString())-1+"");
                }
                break;
            case R.id.go_to_comment:
                // 写评论
                cal.setVisibility(View.GONE);
                write_comm.setVisibility(View.VISIBLE);
                break;
            case R.id.get_comm:
                // 发送评论
                cal.setVisibility(View.VISIBLE);
                write_comm.setVisibility(View.GONE);
                Toast.makeText(this,"发送成功",Toast.LENGTH_SHORT).show();
                break;
            case R.id.no_comm:
                cal.setVisibility(View.VISIBLE);
                write_comm.setVisibility(View.GONE);
                break;
        }
    }

    public void init(){
        new_title = findViewById(R.id.new_title);
        new_details = findViewById(R.id.new_details);
        new_date = findViewById(R.id.new_date);
        new_viewNumber = findViewById(R.id.new_viewNumber);
        like_number = findViewById(R.id.like_number);
        like_this_new_icon =findViewById(R.id.like_this_new_icon);
        cal = findViewById(R.id.cal);
        write_comm = findViewById(R.id.write_comm);
        go_to_comment = findViewById(R.id.go_to_comment);
        like_this_new = findViewById(R.id.like_this_new);
        comm = findViewById(R.id.comm);

        recyclerView = list.get(0).findViewById(R.id.newone_list);
        recyclerView1 = list.get(1).findViewById(R.id.newone_list);

        like_this_new.setOnClickListener(this);
        go_to_comment.setOnClickListener(this);
        (findViewById(R.id.get_comm)).setOnClickListener(this);
        (findViewById(R.id.no_comm)).setOnClickListener(this);
    }

    public void initDate(){

        new_title.setText(intent.getStringExtra("title"));
        new_details.setText(intent.getStringExtra("news_content"));
        new_date.setText(intent.getStringExtra("news_date"));
        new_viewNumber.setText("观看人数："+intent.getStringExtra("news_views_number"));
        Glide.with(this).load(intent.getStringExtra("news_imgUrl")).into((ImageView) findViewById(R.id.new_icon));
        like_number.setText(intent.getStringExtra("news_like_number"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));// 绑定其布局管理器（此处使用线性布局）
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));// 绑定其布局管理器（此处使用线性布局）

        comm.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    // 失去焦点，好像没啥用
                    cal.setVisibility(View.VISIBLE);
                    write_comm.setVisibility(View.GONE);
                }
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
}