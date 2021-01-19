package com.example.redemo1.framents;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.redemo1.Adapeter.lappAdapeter;
import com.example.redemo1.R;
import com.example.redemo1.type.LittleApp;
import com.example.redemo1.type.MyOpenHelp;

import java.util.ArrayList;
import java.util.HashMap;
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
    private List<LittleApp> list;
    private lappAdapeter adapeter;

//    private SQLiteDatabase db;
//    private MyOpenHelp help;


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

        list = new ArrayList<>();
        GridLayoutManager manager=new GridLayoutManager(view.getContext(),5);
        recyclerView.setLayoutManager(manager);

//        help = new MyOpenHelp(view.getContext(),"demoA.db",null,1);
//        db = help.getWritableDatabase();

        for(int i = 0;i < 50;i++){
            // addLapp(help.getReadableDatabase(),"应用"+i,R.mipmap.subway_in);
            list.add(new LittleApp(R.mipmap.subway,"应用"+i));
        }
        adapeter = new lappAdapeter(view.getContext(),list);
        recyclerView.setAdapter(adapeter);

        seach_str.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                selectLapp(view);
            }
        });

    }

    private void selectLapp(View view){
        // 查询小程序的
        String where = seach_str.getText().toString();
//        Cursor cursor=help.getReadableDatabase().query("Little_app",null,"title=?",
//                new String[]{where},null,null,null);
        ArrayList <Map<String,String>> result = new ArrayList<Map<String,String>>();
//        while (cursor.moveToNext()){
//            Map<String,String> map = new HashMap<>();
//            map.put("title",cursor.getString(1));
//            map.put("icon",cursor.getString(2));
            // 获取第二列的值
//            result.add(map);
//        }
        if (result == null || result.size() == 0){
            Toast.makeText(view.getContext(),"查无此服务",Toast.LENGTH_SHORT).show();;
        }else{
            // 显示结果,弹窗
        }
    }

    private void addLapp(SQLiteDatabase db,String title,int icon){
        // 添加
        ContentValues values =  new ContentValues();
        values.put("title",title);  // 保存标题
        values.put("icon",icon);    // 保存图标
        db.insert("Little_app",null,values);
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