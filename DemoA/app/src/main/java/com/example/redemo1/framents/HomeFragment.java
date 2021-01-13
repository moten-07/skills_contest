package com.example.redemo1.framents;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.redemo1.R;

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
    ListView lapplist,newslist;                 // 列表


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

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

        btn_left.setOnClickListener(this::onClick);
        btn_seach.setOnClickListener(this::onClick);
        btn_right.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_lastnew:
                // 跳转到上一轮播图，首页则跳转到尾页
                break;
            case R.id.btn_nextnew:
                // 跳转到下一轮播图，尾页则跳转至首页
                break;
            case R.id.seach_str:
                String seach = seachstr.getText().toString();
                // 获取输入内容，向服务器端查询
                // startActivity(new Intent(v.getContext(),[跳转页面].class));
                // 然后跳转到详情页
                break;
        }
    }
}