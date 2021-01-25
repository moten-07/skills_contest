package com.moten.DemoA.framents;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.moten.DemoA.Adapeter.hottAdapeter;
import com.moten.DemoA.Adapeter.lappAdapeter;
import com.moten.DemoA.Adapeter.newsAdapeter;
import com.moten.DemoA.aboutIntent.HttpHelp;
import com.moten.DemoA.aboutIntent.Indexe;
import com.moten.DemoA.aboutIntent.UserOkhttp;
import com.moten.DemoA.func.TAFJ;
import com.moten.DemoA.func.TGAMSJ;
import com.moten.DemoA.type.Hot_theme;
import com.moten.DemoA.MainActivity;
import com.moten.DemoA.R;
import com.moten.DemoA.type.news;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.RoundLinesIndicator;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.util.BannerUtils;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements View.OnClickListener {

    Banner banner;                              // banner他来了，ohhhh

    ViewPager news_lists;                       // 新闻视图控件
    EditText seach_str;                         // 搜索框
    ImageButton btn_seach;   // 按钮

    TabLayout tabLayout;
    RecyclerView lapp_list,theme_list;
    // 应用列表控件,热门主题列表控件

    List<View> viewList,newsList;                // 轮播图页面的列表，新闻页面的列表
    List <Hot_theme> hott_list;                 // 热门主题列表
    List<Fragment> fragments;
    List<String>titles;                           // 新闻分类标题

    lappAdapeter lappadapeter;                  // 绑定应用列表的适配器
    hottAdapeter hottadapeter;                  // 绑定热门主题的适配器

    private Context context;

    public HomeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        // 下面使用getActivity()的地方全部用(Activity)context代替，确保不会为空，避免闪退
        // 闪退原因：见私人日志1.24
    }

    private  View view = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_home, null);
        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent!=null){
            parent.removeView(view);
        }
        // 清空、重载，不过好像没什么用

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init(view);
        // 初始化控件绑定
        insertData(view);
        // 数据处理
    }

    private void init(View view){
        banner = view.findViewById(R.id.banner);

        news_lists = view.findViewById(R.id.news_lists);
        seach_str = view.findViewById(R.id.seach_str);

        seach_str.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH){
                    // 软键盘的回车键
                    seach(view);
                    return true;
                }
                return false;
            }
        });
        // 在Edittext中重写软键盘的回车键,仅此处有效,在此之前要在edittext加上
        // android:singleLine="true"(单行文本输入)
        // android:imeOptions="actionSearch"(回车键样式，可不加)
        btn_seach = view.findViewById(R.id.btn_seach);

        lapp_list = view.findViewById(R.id.lapp_list);
        theme_list = view.findViewById(R.id.theme_list);
        tabLayout = view.findViewById(R.id.news_type_list);

        viewList  = new ArrayList<>();
        newsList = new ArrayList<>();
        hott_list = new ArrayList<>();
        fragments = new ArrayList<>();
        titles = new ArrayList<>();

        btn_seach.setOnClickListener(this::onClick);
        // 点击监听
    }
    private void insertData(View view){
        // 绑定网格布局，加判断，平板模式下spanCount要大于5（为4）
        // 简（单）（粗）暴处理，屏幕宽度比长度大就算平板,横屏使用我也算你平板
        if (isPad(view.getContext())){
            lapp_list.setLayoutManager(new GridLayoutManager(view.getContext(),6));
            theme_list.setLayoutManager(new GridLayoutManager(view.getContext(),4));
        }else {
            lapp_list.setLayoutManager(new GridLayoutManager(view.getContext(),5));
            theme_list.setLayoutManager(new GridLayoutManager(view.getContext(),2));
        }
        // 添加列表数据
        // 应用领域
        theLApp(view);
        // banner轮播图
        theBanner(view);

        // 新闻列表
        theNews(view);
        for (int i = 0;i<titles.size();i++){
            View view1 =LayoutInflater.from(view.getContext()).inflate(R.layout.item_news,null);
            // 单个新闻视图绑定新闻布局
            newsList.add(view1);        // 视图添加到视图列表（Viewpager）中
            RecyclerView recyclerView =newsList.get(i).findViewById(R.id.newone_list);// 绑定recyclerview
            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));// 绑定其布局管理器（此处使用线性布局）
            List<news>list =new ArrayList<>();
            for (int j = 0; j<5;j++){
                list.add(new news(R.mipmap.newa_in,
                        titles.get(i)+(j+1),
                        "content"+(j+1),
                        ""+(j+1)*10,
                        (j+1)+"天前"));
            }
            recyclerView.setAdapter(new newsAdapeter(view.getContext(),list));
        }
        aboutViewPager();
        // tabLayout绑定ViewPager
        tabLayout.setupWithViewPager(news_lists);
        for (int i = 0 ;i<titles.size();i++){
            tabLayout.getTabAt(i).setText(titles.get(i));
        }

        // 热门主题
        for (int i = 0 ; i < 4 ; i++){
            hott_list.add(new Hot_theme("热门主题"+(i+1)));
        }
        if (theme_list.getItemDecorationCount()==0){
            theme_list.addItemDecoration(new Indexe(8));
        }
        // 绑定适配器

        hottadapeter=new hottAdapeter(view.getContext(),hott_list);
        theme_list.setAdapter(hottadapeter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_seach:
                seach(v);
                break;
        }
    }

    private void seach(View view){
        // 搜索功能（软键盘重写事件要用，从onClick()移到这里来）
        String seach = seach_str.getText().toString();
        // 获取输入内容，向服务器端查询
        Intent intent= new Intent(view.getContext(), MainActivity.class);
        intent.putExtra("type","news");
        intent.putExtra("where",seach);
        startActivity(intent);
        // 然后跳转到详情页
    }

    public static boolean isPad(Context context){
        WindowManager windowManager = (WindowManager)context.getSystemService(context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        Log.d("x",size.x+"");
        Log.d("y",size.y+"");
        if (size.x>size.y){
            return true;
        }else {
            return false;
        }
    }

    UserOkhttp userOkhttp = new UserOkhttp();
    private void theBanner(View view){
        // banner相关
        userOkhttp.getTRList().clear();
        //先清空，免得重复加载，越来越多
        new Thread(new Runnable() {
            @Override
            public void run() {
                userOkhttp.getGAMImg(1,10,45);
                ((Activity)context).runOnUiThread(new Runnable() {
                    // 为什么不能直接在子控件使用啊！！！！！
                    @Override
                    public void run() {
                        banner.setAdapter(new BannerImageAdapter<TGAMSJ.RowsDTO>(userOkhttp.getTRList()) {
                            // banner绑定默认适配器，传入参数为图片列表
                            @Override
                            public void onBindView(BannerImageHolder holder, TGAMSJ.RowsDTO data, int position, int size) {
                                Glide.with(view.getContext())           // 此处为父控件，
                                        .load(new HttpHelp().getHearUri()+data.getImgUrl())         // 此处为图片url
                                        .into(holder.imageView);        // 没什么好说的。
                            }
                        });
                        banner.setLoopTime(2500);                                               // 轮播间隔，文档谬误
                        banner.setScrollTime(500);                                              // 动画时长
                        banner.setIndicator(new RoundLinesIndicator(view.getContext()));        // 设置指示器
                        banner.setIndicatorSelectedWidth((int) BannerUtils.dp2px(15));          // 设置指示器选中的宽度
                        banner.setOnBannerListener(new OnBannerListener() {                     // 点击事件
                            @Override
                            public void OnBannerClick(Object data, int position) {
                                data = userOkhttp.getTRList().get(position);
                                Intent intent = new Intent(view.getContext(),MainActivity.class);
                                intent.putExtra("type","newsViewPager");
                                intent.putExtra("where",((TGAMSJ.RowsDTO)data).toString());
                                startActivity(intent);
                            }
                        });
                    }
                });
            }
        }).start();
    }

    private void theLApp(View view){
        // 应用领域相关
        userOkhttp.getTRList2().clear();
        // 同理
        new Thread(new Runnable() {
            @Override
            public void run() {
                userOkhttp.getRecommendedUrl(1,10);
                ((Activity)context).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        List<TAFJ.Rows>list = userOkhttp.getTRList2();
                        TAFJ.Rows TR = new TAFJ.Rows();
                        TR.setImgUrl(R.mipmap.more+"");
                        TR.setServiceName("更多服务");
                        list.add(TR);
                        lappadapeter=new lappAdapeter(view.getContext(),list);
                        lapp_list.setAdapter(lappadapeter);
                    }
                });
            }
        }).start();
        if (lapp_list.getItemDecorationCount()==0){
            lapp_list.addItemDecoration(new Indexe(10));
        }
    }

    private void theNews(View view){
        // 新闻相关
        userOkhttp.getNTList().clear();
        titles.clear();
        new Thread(new Runnable() {
            @Override
            public void run() {
                userOkhttp.getNewsType();
                ((Activity)context).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        titles = userOkhttp.getNTList();
                    }
                });
            }
        }).start();
    }

    private void aboutViewPager(){
        news_lists.setAdapter(new PagerAdapter() {
            @Override
            public int getCount(){return titles.size();}
            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) { return view == object; }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                View view1 = newsList.get(position);
                container.addView(view1);
                return view1;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView(newsList.get(position));
            }
        });
    }
}