package com.moten.DemoA;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.moten.DemoA.aboutIntent.HttpHelp;
import com.moten.DemoA.aboutIntent.UserOkhttp;
import com.moten.DemoA.func.TGAMSJ;
import com.moten.DemoA.type.limts;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class jGuideActivity extends AppCompatActivity {
    // 引导页主活动（Java版本）
    public ViewPager viewPager;
    // viewPager:可滑动视图
    List<View> viewList=new ArrayList<View>();
    // 视图列表
    private View[] points;
    // 小图标列表
    Button button,button2;
    // 按钮
    private int vpIndex=0;
    // 页面计数器
    Timer timer=new Timer();
    // 计时器，在onDestroy()中注销
    SharedPreferences sp;
    SharedPreferences.Editor editor;

    UserOkhttp userOkhttp = new UserOkhttp();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            limts limts = new limts(jGuideActivity.this);
            limts.getInternet();
        };

        sp=jGuideActivity.this.getSharedPreferences("config", Context.MODE_PRIVATE);
        editor = sp.edit();
        // 初始化数据存储接口

        if(sp.getBoolean("first_time",false)) {
            finish();
            // 关闭此页面
            startActivity(new Intent(jGuideActivity.this,ActivityHome.class));
        }
        // 如果first_time不存在或格式错误，返回false,继续执行下面的代码
        // 如果存在且，则返回其值：true》关闭页面，并跳转到主页；false》继续执行

        initImage();

        viewPager.setAdapter(new PagerAdapter() {
            // 绑定适配器
            @Override
            public int getCount() {
                return viewList.size();
            }
            // 返回可用的视图数量.
            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view==object;
                // 确定一个页面视图是否与instantiateItem(ViewGroup, int)返回的特定关键对象相关联。
            }
            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                View view=viewList.get(position);
                container.addView(view);
                return view;
                // 根据指定的位置创建一个page item
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView(viewList.get(position));
                // 移除给定位置的页面
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // 滑动停止时……
            }

            @Override
            public void onPageSelected(int position) {
                // 页面跳转完成后
                for(int i=0;i<points.length;i++){
                    points[i].setBackgroundResource(i==position ? R.drawable.bg_point1 : R.drawable.bg_point2);
                    // 循环更改下方图标，使之与页面一致
                }
                button.setVisibility((position == 4) ? View.VISIBLE :View.GONE) ;
                button2.setVisibility((position == 4) ? View.VISIBLE :View.GONE) ;
                // 按钮的可见性，仅在最后一页可见
            }
            @Override
            public void onPageScrollStateChanged(int state) {
                // 页面滚动状态改变
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            // 按钮单击事件(进入主页)
            @Override
            public void onClick(View v) {
                // 单击后
                if (sp.getString("IP","").equals("")){
                    Toast.makeText(jGuideActivity.this,"请先填写网络设置",Toast.LENGTH_SHORT).show();
                }else{
                    editor.putBoolean("first_time",true);
                    editor.commit();
                    // 将first_time改为true,并提交
                    finish();
                    startActivity(new Intent(jGuideActivity.this,ActivityHome.class));
                    // 跳转到下一个页面
                }

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog();
            }
            // 弹窗
        });

        TimerTask timerTask=new TimerTask() {
            // 创建计时器事件
            @Override
            public void run() {
                jGuideActivity.this.runOnUiThread(new Runnable() {
                    // 在ui线程上运行
                  @Override
                    public void run() {
                        if(vpIndex==4){
                            // viewPager.setCurrentItem(0);
                            // 页面绑定为第一个
                            // vpIndex=0;
                            // 重置计数器
                            // 轮播时设置，引导页不需要轮播,后面轮播改用banner了
                        }else{
                            viewPager.setCurrentItem(vpIndex+1);
                            // 绑定为下一个页面
                            vpIndex++;
                            // 计数器自增
                        }
                    }
                });
            }
        };

        timer.schedule(timerTask,2000,3000);
        // 触发计时器，timerTask:触发事件，delay:延迟时间，period:持续时间
    }

    private void initImage(){
        // 图片绑定
        for(int i=0;i<5;i++){
            viewList.add(LayoutInflater.from(this).inflate(R.layout.item_vp,null));
            // 往视图列表中添加视图
        }

        doImgUrlGet();

        points=new View[]{findViewById(R.id.poin1), findViewById(R.id.poin2),
                findViewById(R.id.poin3),findViewById(R.id.poin4), findViewById(R.id.poin5)
        };
        viewPager=(ViewPager) findViewById(R.id.vp);
        button=findViewById(R.id.btn_skip);
        button2=findViewById(R.id.btn_web);
        // 按钮绑定
        // 控件绑定
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
        // 注销计时器
    }

    private void MyDialog(){
        // 自定义弹窗
        AlertDialog.Builder builder=new AlertDialog.Builder(jGuideActivity.this);
        AlertDialog dialog=builder.create();
        // 创建弹窗
        View view=LayoutInflater.from(jGuideActivity.this).inflate(R.layout.dialog_guide,null);
        // 绑定弹窗视图
        dialog.setView(view);
        dialog.show();

        Button btn_save=view.findViewById(R.id.btn_Save);
        EditText ip1,ip2,ip3,ip4,webconfig;
        ip1 = view.findViewById(R.id.ip1);
        ip2 = view.findViewById(R.id.ip2);
        ip3 = view.findViewById(R.id.ip3);
        ip4 = view.findViewById(R.id.ip4);

        webconfig=view.findViewById(R.id.webconfig);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取输入值
                Integer ip1str = Integer.valueOf(ip1.getText().toString());
                Integer ip2str =  Integer.valueOf(ip2.getText().toString());
                Integer ip3str =  Integer.valueOf(ip3.getText().toString());
                Integer ip4str =  Integer.valueOf(ip4.getText().toString());
                if (ip1str>255 || ip2str >255 || ip3str >255 || ip4str >255){
                    Toast.makeText(jGuideActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                }else {
                    String ipconfig=ip1str +"."+ip2str +"."+ip3str +"."+ip4str;
                    editor.putString("IP",ipconfig+":"+webconfig.getText().toString());
                    editor.commit();
                    dialog.dismiss();
                    // 关闭弹窗
                }
            }
        });
    }

    public void doImgUrlGet(){
        // 数据解析
        new Thread(new Runnable() {
            // 新建一个线程用来解析数据
            // 解析数据不能放在主线程中,TMD,烦死了[doge]
            // 但ui 操作必须在主线程中使用
            @Override
            public void run() {
                userOkhttp.getGAMImg(1,10,47);
                showResult(userOkhttp.getTRList());
            }
        }).start();
    }

    public void showResult(List<TGAMSJ.RowsDTO> result){
        // ui更新
        runOnUiThread(new Runnable() {
            // 返回主线程进行ui操作
            @Override
            public void run() {
                for(int i = 0;i<result.size(); i++){
                    String url =new HttpHelp().getHearUri()+result.get(i).getImgUrl();
                    // 只要数据集中的ImgUrl,别的净TM扯淡
                    Glide.with(jGuideActivity.this)
                            .load(url)
//                            .placeholder(R.drawable.ic_baseline_all_inclusive_24)
                            // 缓存图片，但还是不要了，报一堆蓝跟一堆红一样难受
                            .into((ImageView)viewList.get(i).findViewById(R.id.imageView));
                }
            }
        });
    }

}