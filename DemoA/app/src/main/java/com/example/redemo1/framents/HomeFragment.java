package com.example.redemo1.framents;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.redemo1.ActivityHome;
import com.example.redemo1.LittleApp;
import com.example.redemo1.R;
import com.example.redemo1.lappAdapeter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    ViewPager viewPager;                        // 轮播图
    EditText seachstr;                          // 搜索框
    View [] news_poins;                         // 轮播图下方小圆点
    ImageButton btn_seach,btn_left,btn_right;   // 按钮
    ListView newslist;                 // 列表
    List<View> viewList;

    RecyclerView lapplist;
    List <LittleApp> list;
    lappAdapeter adapeter;

    private int vpIndex=0;
    // 页面计数器
    Timer timer=new Timer();
    // 计时器


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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        init(view);


        initImage(view);
        theViewPager();
        viewTimer();
        return view;
    }

    private void init(View view){
        // 控件绑定
        viewPager = view.findViewById(R.id.viewpager);
        seachstr = view.findViewById(R.id.seach_str);
        news_poins = new View[]{
          view.findViewById(R.id.news_poin1),
          view.findViewById(R.id.news_poin2),
          view.findViewById(R.id.news_poin3)
        };

        btn_left = view.findViewById(R.id.btn_lastnew);
        btn_right = view.findViewById(R.id.btn_nextnew);
        btn_seach = view.findViewById(R.id.btn_seach);

        lapplist = view.findViewById(R.id.lapp_list);
        newslist = view.findViewById(R.id.news_list);

        viewList=new ArrayList<>();

        btn_left.setOnClickListener(this::onClick);
        btn_seach.setOnClickListener(this::onClick);
        btn_right.setOnClickListener(this::onClick);

        GridLayoutManager manager=new GridLayoutManager(view.getContext(),5);
        lapplist.setLayoutManager(manager);
        list.add(new LittleApp(R.mipmap.subway,"地铁"));
        list.add(new LittleApp(R.mipmap.subway,"地铁2"));
        list.add(new LittleApp(R.mipmap.subway,"地铁3"));
        list.add(new LittleApp(R.mipmap.subway,"地铁4"));
        list.add(new LittleApp(R.mipmap.subway,"地铁5"));
        list.add(new LittleApp(R.mipmap.subway,"地铁6"));
        list.add(new LittleApp(R.mipmap.subway,"地铁7"));
        list.add(new LittleApp(R.mipmap.subway,"地铁8"));
        list.add(new LittleApp(R.mipmap.subway,"地铁9"));
        list.add(new LittleApp(R.mipmap.subway,"更多服务"));


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_lastnew:
                // 跳转到上一轮播图，首页则跳转到尾页
                if(vpIndex==0){
                    vpIndex=2;
                }else{
                    vpIndex-=1;
                }
                viewPager.setCurrentItem(vpIndex);
                Log.v("this index",vpIndex+"");
                break;
            case R.id.btn_nextnew:
                // 跳转到下一轮播图，尾页则跳转至首页
                if(vpIndex==2){
                    vpIndex=0;
                }else{
                    vpIndex+=1;
                }
                viewPager.setCurrentItem(vpIndex);
                Log.v("this index",vpIndex+"");
                break;
            case R.id.seach_str:
                String seach = seachstr.getText().toString();
                // 获取输入内容，向服务器端查询
                // startActivity(new Intent(v.getContext(),[跳转页面].class));
                // 然后跳转到详情页
                break;
        }
    }
    private void theViewPager(){
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return viewList.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view==object;
            }


            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                View view=viewList.get(position);
                container.removeView(view);
                return view;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView(viewList.get(position));
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // 页面跳转后切换下面小圆点状态
                for (int i = 0;i<news_poins.length;i++){
                    news_poins[i].setBackgroundResource((i==position) ? R.drawable.bg_point1 : R.drawable.bg_point2);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private void viewTimer(){
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                if(vpIndex==2){
                    vpIndex=0;
                }else{
                    vpIndex++;
                }
                viewPager.setCurrentItem(vpIndex);
                Log.v("index",vpIndex+"");

            }
        };
        timer.schedule(task,1000,2000);
    }
    private void initImage(View v){
        for(int i = 0;i<news_poins.length;i++){
            viewList.add(LayoutInflater.from(v.getContext()).inflate(R.layout.item_vp,null));
        }
        ((ImageView)viewList.get(0).findViewById(R.id.imageView)).setImageResource(R.drawable.ic_baseline_account_box_24);
        ((ImageView)viewList.get(1).findViewById(R.id.imageView)).setImageResource(R.drawable.ic_baseline_all_inclusive_24);
        ((ImageView)viewList.get(2).findViewById(R.id.imageView)).setImageResource(R.drawable.ic_baseline_accessibility_24);

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.v("now","stop");
    }

}