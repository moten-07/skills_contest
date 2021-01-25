package com.moten.DemoA.framents;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.moten.DemoA.Adapeter.lappAdapeter;
import com.moten.DemoA.R;
import com.moten.DemoA.aboutIntent.HttpHelp;
import com.moten.DemoA.aboutIntent.Indexe;
import com.moten.DemoA.aboutIntent.UserOkhttp;
import com.moten.DemoA.func.TAFJ;
import com.moten.DemoA.type.LittleApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AllFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AllFragment extends Fragment {
    // 全部服务的碎片
    private ImageView seach_icon;
    private EditText seach_str;

    private RecyclerView recyclerView;
    private lappAdapeter adapeter;

    Context context;

//    private SQLiteDatabase db;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AllFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AllFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AllFragment newInstance(String param1, String param2) {
        AllFragment fragment = new AllFragment();
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
        context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_all, container, false);
        init(view);
        return view;
    }

    private void init(View view){
        recyclerView = view.findViewById(R.id.lapps);
        seach_icon = view.findViewById(R.id.btn_seach);
        seach_str = view.findViewById(R.id.seach_str);
        if (HomeFragment.isPad(view.getContext())){
            recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(),6));
        }else{
            recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(),5));
        }

//        help = new MyOpenHelp(view.getContext(),"demoA.db",null,1);
//        db = help.getWritableDatabase();
        addLapp(view);

        seach_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                selectLapp(view);
            }
        });


    }

    private void selectLapp(View view){
        // 查询小程序的
        String where = seach_str.getText().toString();
        ArrayList <Map<String,String>> result = new ArrayList<Map<String,String>>();
        if (result == null || result.size() == 0){
            Toast.makeText(view.getContext(),"查无此服务",Toast.LENGTH_SHORT).show();;
        }else{
            // 显示结果,弹窗
        }
    }
    UserOkhttp userOkhttp = new UserOkhttp();
    private void addLapp(View view){
        // 添加一大堆东东
        userOkhttp.getTRList2().clear();
        new Thread(()-> {
                userOkhttp.getAllServe();
                requireActivity().runOnUiThread(()->{
                    List<TAFJ.Rows>list = userOkhttp.getTRList2();
                    adapeter=new lappAdapeter(view.getContext(),list);
                    recyclerView.setAdapter(adapeter);
                });
        }).start();
        if (recyclerView.getItemDecorationCount()==0){
            recyclerView.addItemDecoration(new Indexe(10));
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        if (db!=null){
//            db.close();
//        }
    }

    private void mydiag(){
        // 搜索结果弹窗
    }
}