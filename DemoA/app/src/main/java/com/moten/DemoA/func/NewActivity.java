package com.moten.DemoA.func;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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
import com.moten.DemoA.framents.PersonFragment;

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


    SharedPreferences sp ;
    int userId;

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

        newsID=intent.getIntExtra("newsId",0);
        Log.d("newsId",newsID+"");

        init();
        initDate();
        aboutViewPager();
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

    public void init(){
        new_title = findViewById(R.id.new_title);
        new_details = findViewById(R.id.new_details);
        new_date = findViewById(R.id.new_date);
        new_viewNumber = findViewById(R.id.new_viewNumber);

        cal = findViewById(R.id.cal);

        like_number = findViewById(R.id.like_number);
        like_this_new_icon =findViewById(R.id.like_this_new_icon);
        like_this_new = findViewById(R.id.like_this_new);

        write_comm = findViewById(R.id.write_comm);
        go_to_comment = findViewById(R.id.go_to_comment);
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

        sp = this.getSharedPreferences("location", Context.MODE_PRIVATE);
        userId  = sp.getInt("UserId",0);
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
                if (userId!=0){
                    pressComment();
                    Toast.makeText(this,"发送成功",Toast.LENGTH_SHORT).show();
                    cal.setVisibility(View.VISIBLE);
                    write_comm.setVisibility(View.GONE);
                }else {
                    Toast.makeText(this,"请先登录",Toast.LENGTH_SHORT).show();
                    new PersonFragment().siupDialog(this);
                }
                break;
            case R.id.no_comm:
                cal.setVisibility(View.VISIBLE);
                write_comm.setVisibility(View.GONE);
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

    public void refresh() {
        finish();
        Intent intent2 = new Intent(NewActivity.this,NewActivity.class);
        intent2.putExtra("newsId",newsID);
        intent2.putExtra("title",intent.getStringExtra("title"));
        intent2.putExtra("news_content",intent.getStringExtra("news_content"));
        intent2.putExtra("news_date",intent.getStringExtra("news_date"));
        intent2.putExtra("news_views_number",intent.getStringExtra("news_views_number"));
        intent2.putExtra("news_imgUrl",intent.getStringExtra("news_imgUrl"));
        intent2.putExtra("news_like_number",intent.getStringExtra("news_like_number"));
        Log.d("newsId",newsID+"");
        startActivity(intent2);
    }

    public void pressComment(){
        // 评论功能
        SharedPreferences sp = this.getSharedPreferences("location", Context.MODE_PRIVATE);
        int userId  = sp.getInt("UserId",1);
        String newComment = comm.getText().toString();
        if (newComment == null || newComment.equals("")){
            Toast.makeText(this,"不能为空",Toast.LENGTH_SHORT).show();
        }else {
            userOkhttp.pressComment(userId,newsID,newComment,this);
        }

    }
}