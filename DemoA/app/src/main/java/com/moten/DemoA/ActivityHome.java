package com.moten.DemoA;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.moten.DemoA.framents.AllFragment;
import com.moten.DemoA.framents.HomeFragment;
import com.moten.DemoA.framents.NewsFragment;
import com.moten.DemoA.framents.PersonFragment;
import com.moten.DemoA.framents.PartyFragment;
import com.moten.DemoA.type.limts;

import java.util.ArrayList;
import java.util.List;

public class ActivityHome extends AppCompatActivity implements View.OnClickListener {
    // 主页
    Toolbar toolbar;
    // 注意，需加载androidx下的toolbar包，一般是第二个
    View person,news,home,party,all;
    TextView t_person,t_news,t_home,t_party,t_all;
    String [] title;
    private List<Fragment>list=new ArrayList<>();
    // 帧布局列表，用于绑定碎片
    PersonFragment personFragment;
    NewsFragment newsFragment;
    HomeFragment homeFragment;
    PartyFragment partyFragment;
    AllFragment allFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // 更改标题栏
        init();

        personFragment = new PersonFragment();
        newsFragment = new NewsFragment();
        homeFragment = new HomeFragment();
        partyFragment = new PartyFragment();
        allFragment = new AllFragment();

        list.add(personFragment);
        list.add(newsFragment);
        list.add(homeFragment);
        list.add(partyFragment);
        list.add(allFragment);
        // 添加碎片

        start();

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            new limts(this).getInternet();
            // 获取网络权限
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
        // 事件
        if (i!=0){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame,list.get(i-1))
                    .commit();
        }
        switch (i){
            case 1:
                person.setBackgroundResource(R.mipmap.personage_in);
                t_person.setTextColor(getResources().getColor(R.color.btn_in));
                setTitle("个人中心");
                break;
            case 2:
                news.setBackgroundResource(R.mipmap.newa_in);
                t_news.setTextColor(getResources().getColor(R.color.btn_in));
                setTitle("新闻");
                break;
            case 3:
                home.setBackgroundResource(R.mipmap.home_in);
                t_home.setTextColor(getResources().getColor(R.color.btn_in));
                setTitle("首页");
                break;
            case 4:
                party.setBackgroundResource(R.mipmap.party_in);
                t_party.setTextColor(getResources().getColor(R.color.btn_in));
                setTitle("智慧党建");
                break;
            case 5:
                all.setBackgroundResource(R.mipmap.all_in);
                t_all.setTextColor(getResources().getColor(R.color.btn_in));
                setTitle("全部服务");
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
        Intent intent=getIntent();
        choose(intent.getIntExtra("choose",3));
        // 如果没有传过来的数据，就默认为3（主页面）
    }

    private long exitTime=0;
    // 点击时间
    @Override
    public void onBackPressed() {
        // 复写返回键点击事件
        // 两秒内点击两次即退出，仅在当前页面有效
        if((System.currentTimeMillis()-exitTime)>2000){
            Toast.makeText(ActivityHome.this,"再次点击返回键退出应用",Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        }else{
            super.onBackPressed();
        }
        Log.d("time",exitTime+"");
    }

    @Override
    protected void onUserLeaveHint() {
        // home键的监听
        super.onUserLeaveHint();
    }

    public void refreshFragment(){
        // 刷新页面用的
        if (list.contains(personFragment)){
            list.remove(personFragment);
            // 先从列表移除
        }
        getSupportFragmentManager().beginTransaction().remove(personFragment);
        //
        personFragment = new PersonFragment();
        list.add(0,personFragment);
        choose(1);
    }

}