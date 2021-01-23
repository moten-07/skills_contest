package com.example.redemo1.framents;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.redemo1.Adapeter.hottAdapeter;
import com.example.redemo1.Adapeter.lappAdapeter;
import com.example.redemo1.Adapeter.newsAdapeter;
import com.example.redemo1.aboutIntent.HttpHelp;
import com.example.redemo1.func.tojson;
import com.example.redemo1.type.Hot_theme;
import com.example.redemo1.type.LittleApp;
import com.example.redemo1.MainActivity;
import com.example.redemo1.R;
import com.example.redemo1.type.news;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerAdapter;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.RoundLinesIndicator;
import com.youth.banner.util.BannerUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment implements View.OnClickListener {

    Banner banner;                              // banner他来了，ohhhh
    String []images = new String []{"url"};
    String [] title_s = new String[]{"标题"};

    ViewPager news_lists;                       // 新闻视图控件
    EditText seach_str;                         // 搜索框
    ImageButton btn_seach;   // 按钮
    List<View> viewList,newsList;                // 轮播图页面的列表，新闻页面的列表

    TabLayout tabLayout;
    RecyclerView lapp_list,theme_list;
    // 应用列表控件,热门主题列表控件
    List <LittleApp> lappslist;                 // 应用列表
    List <Hot_theme> hott_list;                 // 热门主题列表
    List<Fragment> fragments;

    String [] titles;                           // 新闻分类标题

    lappAdapeter lappadapeter;                  // 绑定应用列表的适配器
    hottAdapeter hottadapeter;                  // 绑定热门主题的适配器

    private int vpIndex=0;                      // 页面计数器

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Object ActivityHome;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        // 碎片绑定
        init(view);
        // 初始化控件绑定
        insertData(view);
        // 数据处理
        initImage(view);
        // 图片添加
        return view;
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

        lappslist = new ArrayList<>();
        hott_list = new ArrayList<>();

        fragments = new ArrayList<>();

        btn_seach.setOnClickListener(this::onClick);
        // 点击监听
    }
    private void insertData(View view){
        // 加判断，平板模式下spanCount要大于5（为4）?没反应？？全™认为是平板？
//        if (isPad(view.getContext())){
//            lapp_list.setLayoutManager(new GridLayoutManager(view.getContext(),6));
//            theme_list.setLayoutManager(new GridLayoutManager(view.getContext(),4));
//        }else {
            lapp_list.setLayoutManager(new GridLayoutManager(view.getContext(),5));
            theme_list.setLayoutManager(new GridLayoutManager(view.getContext(),2));
//        }

        // 列表绑定网格布局/线性布局

        // 添加列表数据
        // 数据应该是从服务器端传来的
        // 应用领域
        String [] littie_app=view.getContext().getResources().getStringArray(R.array.littie_app);
        for(String title:littie_app){
            lappslist.add(new LittleApp(R.mipmap.subway,title));
        }
        // 热门主题
        for (int i = 0 ; i < 4 ; i++){
            hott_list.add(new Hot_theme("热门主题"+(i+1)));
        }
        // 新闻分类
        titles = view.getContext().getResources().getStringArray(R.array.newsType);
        // 添加多页新闻列表

        // 绑定适配器
        lappadapeter=new lappAdapeter(view.getContext(),lappslist);
        lapp_list.setAdapter(lappadapeter);
        indexe indexe=new indexe(2);
        lapp_list.addItemDecoration(indexe);

        hottadapeter=new hottAdapeter(view.getContext(),hott_list);
        theme_list.setAdapter(hottadapeter);
        indexe indexe1=new indexe(8);
        theme_list.addItemDecoration(indexe1);

        List<news>list =new ArrayList<>();
        for (int i = 0; i<5;i++){
            list.add(new news(R.mipmap.newa_in,
                    "title"+(i+1),
                    "content"+(i+1),
                    ""+(i+1)*10,
                    (i+1)+"天前"));
        }
        newsAdapeter newsAdapeter =new newsAdapeter(view.getContext(),list);
        for (int i = 0;i<titles.length;i++){
            View view1 =LayoutInflater.from(view.getContext()).inflate(R.layout.item_news,null);
            newsList.add(view1);
            RecyclerView recyclerView =newsList.get(i).findViewById(R.id.newone_list);
            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
            recyclerView.setAdapter(newsAdapeter);
        }

        news_lists.setAdapter(new PagerAdapter() {
            @Override
            public int getCount(){return titles.length;}
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
        tabLayout.setupWithViewPager(news_lists);
        for (int i = 0 ;i<titles.length;i++){
            tabLayout.getTabAt(i).setText(titles[i]);
        }
        HttpHelp help = new HttpHelp();
        List<tojson.RowsBean>imglist = new ArrayList<>();
        // 应该通过HttpHelp的getMainImg（1,10）获取，然后解析、绑定到imglist中
        // 暂时先这样
        imglist.add(new tojson.RowsBean(10,
                help.getHearUri()+"/profile/home2.png",
                "45",
                "2020-10-12T22:55:17.000+0800",
                "2","N"));
        imglist.add(new tojson.RowsBean(11,
                help.getHearUri()+"/profile/home3.png",
                "45",
                "2020-10-12T22:55:17.000+0800",
                "3","N"));
        imglist.add(new tojson.RowsBean(12,
                help.getHearUri()+"/profile/home4.png",
                "45",
                "2020-10-12T22:55:17.000+0800",
                "4","N"));
        imglist.add(new tojson.RowsBean(13,
                help.getHearUri()+"/profile/home1.png",
                "45",
                "2020-10-12T22:55:17.000+0800",
                "1","N"));
        banner.setAdapter(new BannerImageAdapter<tojson.RowsBean>(imglist) {
            @Override
            public void onBindView(BannerImageHolder holder, tojson.RowsBean data, int position, int size) {
                Glide.with(view.getContext())
                        .load(data.imgUrl)
                        .into(holder.imageView);
            }
        });
        banner.setIndicator(new RoundLinesIndicator(view.getContext()));
        banner.setIndicatorSelectedWidth((int) BannerUtils.dp2px(15));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_seach:
                seach(v);
                break;
        }
    }

    private void initImage(View v){
        // 轮播页面设置

        // 添加多新闻列表


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

    @Override
    public void onStart() {
        super.onStart();
        Log.v("now","start");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.v("now","stop");
    }
    protected boolean isDestroy(Activity activity) {
        return activity == null || activity.isFinishing() ||
                (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1 && activity.isDestroyed());
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

    private static boolean isPad(Context context){
        return (context.getResources().getConfiguration().screenLayout
        & Configuration.SCREENLAYOUT_LAYOUTDIR_MASK)>=Configuration.SCREENLAYOUT_SIZE_LARGE;
    }


}