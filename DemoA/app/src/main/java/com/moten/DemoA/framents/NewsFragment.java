package com.moten.DemoA.framents;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.moten.DemoA.Adapeter.newsAdapeter;
import com.moten.DemoA.R;
import com.moten.DemoA.aboutIntent.UserOkhttp;
import com.moten.DemoA.func.TNLJ;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsFragment extends Fragment {
    TabLayout news_type_list;
    ViewPager news_viewpager;
    List<View> news_List;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NewsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewsFragment newInstance(String param1, String param2) {
        NewsFragment fragment = new NewsFragment();
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
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        news_type_list = view.findViewById(R.id.news_type_list);
        news_viewpager = view.findViewById(R.id.news_viewpager);
        news_List = new ArrayList<>();
        theNews(view);
    }

    private void theNews(View view){
        // 新闻相关
        UserOkhttp userOkhttp = new UserOkhttp();
        userOkhttp.getNTList().clear();
        new Thread(()->{
            userOkhttp.getNewsType();
            for (int i = 0;i<userOkhttp.getNTList().size();i++){
                userOkhttp.getNewsListUrl(1,100,userOkhttp.getNTList().get(i).getDictCode());
                List<TNLJ.Rows>list = new ArrayList<>();
                list.addAll(userOkhttp.getNList());
                int i1=i;
                requireActivity().runOnUiThread(()->{
                    news_List.add(LayoutInflater.from(view.getContext()).inflate(R.layout.item_news,null));
                    news_viewpager.getAdapter().notifyDataSetChanged();
                    RecyclerView recyclerView =news_List.get(i1).findViewById(R.id.newone_list);// 绑定recyclerview
                    recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));// 绑定其布局管理器（此处使用线性布局）
                    recyclerView.setAdapter(new newsAdapeter(view.getContext(),list));// 隔壁复制的

                });
                userOkhttp.getNList().clear();
            }
            requireActivity().runOnUiThread(()-> {
                for (int i = 0 ;i<userOkhttp.getNTList().size();i++){
                    news_type_list.getTabAt(i).setText(userOkhttp.getNTList().get(i).getDictLabel());
                }
            });
        }).start();

        aboutViewPager();
        news_type_list.setupWithViewPager(news_viewpager);
    }

    private void aboutViewPager(){
        news_viewpager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount(){return news_List.size();}
            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) { return view == object; }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                View view1 = news_List.get(position);
                container.addView(view1);
                return view1;
            }
            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                if (news_List.size()>0){
                    container.removeView(news_List.get(position));
                }
            }
        });
    }
}