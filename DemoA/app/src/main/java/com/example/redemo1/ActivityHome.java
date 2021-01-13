package com.example.redemo1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.redemo1.framents.AllFragment;
import com.example.redemo1.framents.HomeFragment;
import com.example.redemo1.framents.NewsFragment;
import com.example.redemo1.framents.PersonFragment;
import com.example.redemo1.framents.PartyFragment;

import java.util.ArrayList;
import java.util.List;

public class ActivityHome extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbar;
    // 注意，需加载androidx下的toolbar包，一般是第二个
    View person,news,home,party,all;
    TextView t_person,t_news,t_home,t_party,t_all;
    String [] title;
    List<Fragment>list=new ArrayList<>();
    // 帧布局列表，用于绑定碎片
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle(R.string.title);
        // 更改标题栏
        init();
        start();
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET)!= PackageManager.PERMISSION_GRANTED){
            // 申请手机网络访问权限
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.INTERNET},1);
        }
    }
    private void init(){
        toolbar=findViewById(R.id.newBar);
        setSupportActionBar(toolbar);
        // Toolbar代替原标题栏
        title=this.getResources().getStringArray(R.array.bottom_home);
        // 绑定文本数组

        person=findViewById(R.id.icon_person);
        news=findViewById(R.id.icon_news);
        home=findViewById(R.id.icon_home);
        party=findViewById(R.id.icon_party);
        all=findViewById(R.id.icon_all);

        t_person=findViewById(R.id.title_person);
        t_news=findViewById(R.id.title_news);
        t_home=findViewById(R.id.title_home);
        t_party=findViewById(R.id.title_subway);
        t_all=findViewById(R.id.title_all);
        // 控件绑定

        person.setOnClickListener(this);
        news.setOnClickListener(this);
        home.setOnClickListener(this);
        party.setOnClickListener(this);
        all.setOnClickListener(this);
        // 按钮监听

        t_person.setText(title[0]);
        t_news.setText(title[1]);
        t_home.setText(title[2]);
        t_party.setText(title[3]);
        t_all.setText(title[4]);
        // 文本绑定

        list.add(new PersonFragment());
        list.add(new NewsFragment());
        list.add(new HomeFragment());
        list.add(new PartyFragment());
        list.add(new AllFragment());
    }

    @Override
    public void onClick(View v) {
        // 点击事件
        switch (v.getId()){
            case R.id.icon_person:
                choose(0);
                choose(1);
                break;
            case R.id.icon_news:
                choose(0);
                choose(2);
                break;
            case R.id.icon_home:
                choose(0);
                choose(3);
                break;
            case R.id.icon_party:
                choose(0);
                choose(4);
                break;
            case R.id.icon_all:
                choose(0);
                choose(5);
                break;
        }
    }
    private void choose(int i){
        switch (i){
            case 1:
                person.setBackgroundResource(R.mipmap.personage_in);
                t_person.setTextColor(getResources().getColor(R.color.btn_in));
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,list.get(0)).commit();
                break;
            case 2:
                news.setBackgroundResource(R.mipmap.newa_in);
                t_news.setTextColor(getResources().getColor(R.color.btn_in));
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,list.get(1)).commit();
                break;
            case 3:
                home.setBackgroundResource(R.mipmap.home_in);
                t_home.setTextColor(getResources().getColor(R.color.btn_in));
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,list.get(2)).commit();
                break;
            case 4:
                party.setBackgroundResource(R.mipmap.party_in);
                t_party.setTextColor(getResources().getColor(R.color.btn_in));
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,list.get(3)).commit();
                break;
            case 5:
                all.setBackgroundResource(R.mipmap.all_in);
                t_all.setTextColor(getResources().getColor(R.color.btn_in));
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,list.get(4)).commit();
                break;
            case 0:
                person.setBackgroundResource(R.mipmap.personage);
                news.setBackgroundResource(R.mipmap.newa);
                home.setBackgroundResource(R.mipmap.home);
                party.setBackgroundResource(R.mipmap.party);
                all.setBackgroundResource(R.mipmap.all);
                t_person.setTextColor(getResources().getColor(R.color.black));
                t_news.setTextColor(getResources().getColor(R.color.black));
                t_home.setTextColor(getResources().getColor(R.color.black));
                t_party.setTextColor(getResources().getColor(R.color.black));
                t_all.setTextColor(getResources().getColor(R.color.black));
                break;
        }
    }

    private void start(){
        // 初始绑定
        choose(3);
    }
}