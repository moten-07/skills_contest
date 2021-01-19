package com.example.redemo1.func;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.redemo1.R;

public class userInfoActivity extends AppCompatActivity {
    Toolbar toolbar;
    EditText user_info_newname,user_info_newsex,user_info_new;
    TextView user_info_paper;
    Button user_info_newicon,user_info_save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        init();
        // 头像可修改-》相机权限，相册读取权限，文件上传
        // 所有数据上传后先储存在SQLite，然后再上传到服务器的数据库中
        // 获取网络资源（指头像）
    }

    private void init(){
        toolbar = findViewById(R.id.this_subway_bar);
        setSupportActionBar(toolbar);
        setTitle("个人信息");
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        user_info_newname = findViewById(R.id.user_info_newname);
        user_info_newsex = findViewById(R.id.user_info_newsex);
        user_info_new = findViewById(R.id.user_info_new);
        user_info_paper = findViewById(R.id.user_info_paper);
        user_info_newicon = findViewById(R.id.user_info_newicon);
        user_info_save = findViewById(R.id.user_info_save);

        user_info_paper.setText("证件号码：");// +存储的号码，但要打码

        user_info_newicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 修改头像（获取相册权限，读取及上传）
            }
        });
        user_info_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 保存修改
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