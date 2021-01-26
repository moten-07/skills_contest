package com.moten.DemoA.framents;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.moten.DemoA.MainActivity;
import com.moten.DemoA.R;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PersonFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PersonFragment extends Fragment implements View.OnClickListener{
   ImageView user_icon;
   TextView user_name,user_id;
   Button user_out,user_siup;
   LinearLayout user_info_list,user_order_list,update_pass,feed;
   Boolean siup = false;                // 判断是否登录
   SharedPreferences sp;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PersonFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PersonFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PersonFragment newInstance(String param1, String param2) {
        PersonFragment fragment = new PersonFragment();
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
        View view=inflater.inflate(R.layout.fragment_person, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view){
        user_icon = view.findViewById(R.id.user_icon);
        user_id = view.findViewById(R.id.user_id);
        user_name = view.findViewById(R.id.user_name);
        user_info_list = view.findViewById(R.id.user_info_list);
        user_order_list = view.findViewById(R.id.user_order_list);
        update_pass = view.findViewById(R.id.update_pass);
        feed = view.findViewById(R.id.feed);
        user_out = view.findViewById(R.id.user_out);
        user_siup = view.findViewById(R.id.user_siup);

        user_info_list.setOnClickListener(this::onClick);
        user_order_list.setOnClickListener(this::onClick);
        update_pass.setOnClickListener(this::onClick);
        feed.setOnClickListener(this::onClick);
        user_out.setOnClickListener(this::onClick);
        user_siup.setOnClickListener(this::onClick);

        sp = view.getContext().getSharedPreferences("location", Context.MODE_PRIVATE);
        siup = (sp.getString("token",null)!=null);
        Log.d("siup",siup+"");
        if(siup){
            user_siup.setVisibility(View.GONE);
        }else{
            user_icon.setImageResource(R.drawable.ic_baseline_account_box_24);
            user_name.setText("未登录");
            user_id.setVisibility(View.INVISIBLE);
            user_out.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.user_info_list:
                if (siup){
                    intent = new Intent(v.getContext(), MainActivity.class);
                    intent.putExtra("type","user_info");
                    startActivity(intent);
                }else{
                    Toast.makeText(v.getContext(),"请先登录",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.user_order_list:
                if (siup){
                    intent = new Intent(v.getContext(), MainActivity.class);
                    intent.putExtra("type","user_order");
                    startActivity(intent);
                }else{
                    Toast.makeText(v.getContext(),"请先登录",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.update_pass:
                if (siup){
                    intent = new Intent(v.getContext(), MainActivity.class);
                    intent.putExtra("type","user_update_pass");
                    startActivity(intent);
                }else{
                    Toast.makeText(v.getContext(),"请先登录",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.feed:
                if (siup){
                    intent = new Intent(v.getContext(), MainActivity.class);
                    intent.putExtra("type","user_feed");
                    startActivity(intent);
                }else{
                    Toast.makeText(v.getContext(),"请先登录",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.user_out:
                sp.edit().putString("token",null);
                Toast.makeText(v.getContext(),"已清空本地信息并退出登录",Toast.LENGTH_LONG).show();
                onResume();
                break;
            case R.id.user_siup:
                // 弹出登录信息框
                siupDialog();
                break;
        }
    }

    private void siupDialog(){
        //登录及注册弹窗
        View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_login,null);
        View view2 = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_sign,null);
        AlertDialog dialog2 = new AlertDialog.Builder(getActivity())
                .setView(view2)
                .setTitle("注册你的账户")
                .create();
        AlertDialog dialog1 = new AlertDialog.Builder(getActivity())
                .setView(view1)
                .setTitle("登录你的账户")
                .create();
        dialog1.show();
        view1.findViewById(R.id.goToSign).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog2.show();
            }
        });
        view1.findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 登录
                //{
                //    "msg": "操作成功",
                //    "code": 200,
                //    "token": "eyJhbGciOiJIUzUxMiJ9.eyJsb2dpbl91c2VyX2tleSI6IjgyZTk1MzBhLTEzYWQtNDNmNC04MzMyLTU3YmI2MjllOTRhZCJ9.77F4YRkPUaTT7N-Ks63FHSzwAwdaUJEu3xwHwV2llM8GB0Bf_YUW6pAS08g_EPtQiYNqXe_Uav8AVby3naFxpg"
                //}
                Toast.makeText(getActivity(),"登录成功",Toast.LENGTH_SHORT).show();
                dialog1.dismiss();
            }
        });
        view1.findViewById(R.id.noLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.dismiss();
            }
        });

        view2.findViewById(R.id.siup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dialog2Run()){
                    dialog2.dismiss();
                    dialog1.dismiss();
                }else {
                    Toast.makeText(getActivity(),"注册失败,换个账号或手机号码试试？",Toast.LENGTH_SHORT).show();
                }
            }
        });
        view2.findViewById(R.id.noSiup).setOnClickListener(new View.OnClickListener() {
            // 注册取消
            @Override
            public void onClick(View v) {
                dialog2.dismiss();
                dialog1.show();
            }
        });

    }

    private Boolean dialog2Run(){
        // 注册一个搞事情的
        final Boolean[] a = {false};
        final String[] result = {""};
        String json = "";
        json = "{\"userName\":\"nameIsPi\"," +
                "\"nickName\":\"pi\"," +
                "\"phonenumber\":\"31415926535\"," +
                "\"sex\":\"1\"," +
                "\"password\":\"897946\"}";
        RequestBody body = RequestBody.create(json, MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .url("http://dasai.sdvcst.edu.cn:8080/system/user/register")
                .post(body)
                .build();
        Call call = new OkHttpClient()
                // 暂时没打算用单例模式
                .newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) { e.printStackTrace(); }
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                result[0] = response.body().string();
                Log.d("msg", result[0]);
                // {"msg": "操作成功","code": 200,"token": "……"}
                // {"msg":"新增用户'nameIsPi'失败，登录账号已存在","code":500}
                if (result[0].split(",")[0].split(":")[1].equals("\"操作成功\"")){
                    a[0] = true;
                }
            }
        });
        return a[0];
    }
}