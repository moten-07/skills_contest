package com.moten.DemoA.framents;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.moten.DemoA.ActivityHome;
import com.moten.DemoA.MainActivity;
import com.moten.DemoA.R;
import com.moten.DemoA.aboutIntent.HttpHelp;
import com.moten.DemoA.aboutIntent.UserOkhttp;
import com.moten.DemoA.func.TALJ;
import com.moten.DemoA.func.TPIJFT;

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
    SharedPreferences.Editor editor;

    OkHttpClient client;
    Call call;
    HttpHelp help;

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
        editor = sp.edit();

        client= new OkHttpClient();
        help = new HttpHelp();

        siup = (sp.getString("token",null)!=null);
        if(siup){
            // 获取个人信息
            getUserInfo(view);
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
                // 个人信息
                if (siup){
                    intent = new Intent(v.getContext(), MainActivity.class);
                    intent.putExtra("type","user_info");
                    startActivity(intent);
                }else{
                    Toast.makeText(v.getContext(),"请先登录",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.user_order_list:
                // 订单列表
                if (siup){
                    intent = new Intent(v.getContext(), MainActivity.class);
                    intent.putExtra("type","user_order");
                    startActivity(intent);
                }else{
                    Toast.makeText(v.getContext(),"请先登录",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.update_pass:
                // 修改密码
                if (siup){
                    intent = new Intent(v.getContext(), MainActivity.class);
                    intent.putExtra("type","user_update_pass");
                    startActivity(intent);
                }else{
                    Toast.makeText(v.getContext(),"请先登录",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.feed:
                // 意见反馈
                if (siup){
                    intent = new Intent(v.getContext(), MainActivity.class);
                    intent.putExtra("type","user_feed");
                    startActivity(intent);
                }else{
                    Toast.makeText(v.getContext(),"请先登录",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.user_out:
                editor.putString("token",null);
                editor.commit();
                Toast.makeText(v.getContext(),"已清空本地信息并退出登录",Toast.LENGTH_LONG).show();
                ((ActivityHome)getActivity()).refreshFragment();
                // 页面刷新的方法,自定义的，雷电模拟器上倒是可以用（相对还算流畅）
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
        // 登录的弹窗
        AlertDialog dialog1 = new AlertDialog.Builder(getActivity())
                .setView(view1)
                .setTitle("登录你的账户")
                .create();
        // 注册的弹窗
        AlertDialog dialog2 = new AlertDialog.Builder(getActivity())
                .setView(view2)
                .setTitle("注册你的账户")
                .create();
        dialog1.show();

        view1.findViewById(R.id.goToSign).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { dialog2.show(); }         // 跳到注册
        });
        view1.findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = ((EditText)view1.findViewById(R.id.username)).getText().toString();
                String password = ((EditText)view1.findViewById(R.id.password)).getText().toString();
                if (username.isEmpty() || username.equals("") || password.isEmpty() || password.equals("")){
                    // 判空免崩
                    Toast.makeText(requireActivity(),"你TM怎么写的！",Toast.LENGTH_SHORT).show();
                }else{
                    dialogLogin(view1,dialog1);
                }
            }
        });
        view1.findViewById(R.id.noLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { dialog1.dismiss(); }      // 登录取消
        });

        view2.findViewById(R.id.siup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { dialog2Run(view2,dialog2); }  // 注册按钮
        });
        view2.findViewById(R.id.noSiup).setOnClickListener(new View.OnClickListener() {
            // 注册取消
            @Override
            public void onClick(View v) {
                dialog2.dismiss();
            }
        });

    }

    private void dialog2Run(View view,AlertDialog dialog) {
        // 注册,一个搞事情的
        String userName = ((EditText)view.findViewById(R.id.userName)).getText().toString();
        String nickName = ((EditText)view.findViewById(R.id.nickName)).getText().toString();
        String phonenumber = ((EditText)view.findViewById(R.id.phonenumber)).getText().toString();
        String sex = (((RadioButton)view.findViewById(R.id.sex_man)).isChecked()) ? "1" : "0";
        String password = ((EditText)view.findViewById(R.id.password)).getText().toString();
        String json = "{\"userName\":\""+userName+"\"," +
                "\"nickName\":\""+nickName+"\"," +
                "\"phonenumber\":\""+phonenumber+"\"," +
                "\"sex\":\""+sex+"\"," +
                "\"password\":\""+password+"\"}";
        RequestBody body = RequestBody.create(json, MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .url("http://dasai.sdvcst.edu.cn:8080/system/user/register")
                .post(body)
                .build();
        call = client
                // 暂时没打算用单例模式
                .newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) { e.printStackTrace(); }
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String result2 = response.body().string();
                TALJ talj = new Gson().fromJson(result2, TALJ.class);
//                Log.d("msg", talj.getMsg());
//                Log.d("code", talj.getCode() + "");
//                if (talj.getToken() != null) {
//                    Log.d("token", talj.getToken());
//                }
                requireActivity().runOnUiThread(() -> {
                    if (talj.getCode()==200){
                        dialog.dismiss();
                    }
                    Toast.makeText(requireActivity(), talj.getMsg(), Toast.LENGTH_SHORT).show();
                });
            }
        });
    }

    private void dialogLogin(View view,AlertDialog dialog){
        // 登录
        UserOkhttp userOkhttp = new UserOkhttp();
        userOkhttp.dialogLogin(view,requireActivity(),dialog);

    }

    private void getUserInfo(View view){

        Request request = new Request.Builder()
                .url(help.getHearUri()+help.getUserInfo())
                .get()
                .addHeader("authorization",sp.getString("token","null"))
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) { e.printStackTrace(); }
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String result  = response.body().string();
                TPIJFT tpijft = new Gson().fromJson(result,TPIJFT.class);
                // 失策了，当时没做大致先解析数据来着，名字没统一
                requireActivity().runOnUiThread(()->{
                    user_id.setText("账号："+tpijft.user.userName);
                    user_name.setText("昵称："+tpijft.user.nickName);
                    Glide.with(view.getContext())
                            .load((tpijft.user.avatar==null || tpijft.user.avatar.equals(""))
                                    ? R.mipmap.kls
                                    : help.getHearUri()+tpijft.user.avatar)
                            .into(user_icon);

                    editor.putString("user_info_name",tpijft.user.nickName);
                    editor.putString("user_info_sex",(tpijft.user.sex.equals("1"))?"男":"女");
                    editor.putString("user_id",tpijft.user.userName);
                    editor.putString("user_info_phone",tpijft.user.phonenumber);
                    editor.putString("user_paper",(tpijft.user.idCard==null || tpijft.user.idCard.equals(""))?
                            "123456789876543210":tpijft.user.idCard);
                    editor.commit();
                });
            }
        });
    }
}