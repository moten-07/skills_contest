package com.moten.DemoA.aboutIntent;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.google.gson.Gson;
import com.moten.DemoA.ActivityHome;
import com.moten.DemoA.R;
import com.moten.DemoA.func.TAFJ;
import com.moten.DemoA.func.TALJ;
import com.moten.DemoA.func.TGAMSJ;
import com.moten.DemoA.func.TNLJ;
import com.moten.DemoA.func.TNTJ;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UserOkhttp {
    // 数据解析类
    private HttpHelp help = new HttpHelp();
    private OkHttpClient client =new OkHttpClient();
    private Request request;
    private Call call;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    private List<TGAMSJ.RowsDTO>TRlist = new ArrayList<>();
    public List<TGAMSJ.RowsDTO>getTRList(){return TRlist; }// 返回引导页和首页的数据组
    public void getGAMImg(int pageNum,int pageSize,int type){
        // 解析引导页和首页的数据
        try {
            request = new Request
                    .Builder()
                    .url(help.getHearUri()+help.getGAMImg(pageNum,pageSize,type))
                    .get().build();
            Response response = client.newCall(request).execute();
            String data = response.body().string();
            TGAMSJ tgamsj = new Gson().fromJson(data, TGAMSJ.class);
            for (int i = 0;i< tgamsj.getRows().size();i++){
                TRlist.add(tgamsj.getRows().get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private List<TAFJ.Rows> TRlist2 = new ArrayList<>();
    public List<TAFJ.Rows>getTRList2(){ return TRlist2; } // 返回引导页和首页的数据组
    public void getRecommendedUrl(int pageNum,int pageSize){
        // 解析推荐服务
        try{
            request = new Request.Builder()
                    .url(help.getHearUri()+help.getRecommendedUrl(pageNum,pageSize))
                    .get().build();
            Response response = client.newCall(request).execute();
            String data = response.body().string();
            TAFJ tafj = new Gson().fromJson(data,TAFJ.class);
            for(TAFJ.Rows tr : tafj.getRows()){
                TRlist2.add(tr);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void getAllServe(){
        try{
            request = new Request.Builder()
                    .url(help.getHearUri()+help.getAllServe())
                    .get().build();
            Response response = client.newCall(request).execute();
            String data = response.body().string();
            TAFJ tafj = new Gson().fromJson(data,TAFJ.class);
            for(TAFJ.Rows tr : tafj.getRows()){
                TRlist2.add(tr);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private List<TNTJ.Data>NTList=new ArrayList<>();
    public List<TNTJ.Data> getNTList(){ return NTList; }// 返回新闻类别的数据组
    public void getNewsType(){
        try{
            request = new Request.Builder()
                    .url(help.getHearUri()+help.getNewsType())
                    .get().build();
            Response response = client.newCall(request).execute();
            String data = response.body().string();
            TNTJ tntj = new Gson().fromJson(data,TNTJ.class);
            for (int i = 0;i<tntj.getData().size(); i++){
                NTList.add(tntj.getData().get(i));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private List<TNLJ.Rows> NList = new ArrayList<>();
    public List<TNLJ.Rows>getNList(){return NList;}
    public void getNewsListUrl(int pageNum,int pageSize,int pressCategory){
        try{
            request = new Request.Builder()
                    .url(help.getHearUri()+help.getNewsListUrl(pageNum,pageSize,pressCategory))
                    .get().build();
            Response response = client.newCall(request).execute();
            String data = response.body().string();
            TNLJ tnlj = new Gson().fromJson(data,TNLJ.class);
            for (int i = 0; i<tnlj.getRows().size();i++){
                NList.add(tnlj.getRows().get(i));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private TALJ talj= new TALJ();
    public void dialogLogin(View view, Activity activity,AlertDialog dialog){
        // 登录
        sp = activity.getSharedPreferences("location", Context.MODE_PRIVATE);
        editor = sp.edit();
        String username = ((EditText)view.findViewById(R.id.username)).getText().toString();
        String password = ((EditText)view.findViewById(R.id.password)).getText().toString();

        String loginJson = "{\"username\":\""+username+"\",\"password\":\""+password+"\"\n}";
        RequestBody body = RequestBody.create(loginJson, MediaType.parse("application/json"));
        request = new Request.Builder()
                .url(help.getHearUri()+help.PostLogin())
                .post(body)
                .build();
        call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) { e.printStackTrace(); }
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String result = response.body().string();
                    TALJ talj = new Gson().fromJson(result,TALJ.class);
                    if (talj.getToken()!=null){
                        activity.runOnUiThread(()->{
                            if (talj.getCode() == 200){
                                editor.putString("token",talj.getToken());
                                editor.commit();
                                Toast.makeText(activity,talj.getMsg(),Toast.LENGTH_SHORT).show();
                                // 乱七八糟的异常，应该是Toast位置的原因，报的是蓝色
                                // 先不管他，能正常跑，后面再来搞掉它
                                dialog.dismiss();
                                ((ActivityHome)activity).refreshFragment();
                            }
                        });
                    }else{
                        activity.runOnUiThread(()->{ Toast.makeText(activity,talj.getMsg(),Toast.LENGTH_SHORT).show(); });
                    }
            }
        });
    }

    public void dialog2Run(View view,AlertDialog dialog,Activity activity) {
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
        call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) { e.printStackTrace(); }
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String result2 = response.body().string();
                TALJ talj = new Gson().fromJson(result2, TALJ.class);
                activity.runOnUiThread(() -> {
                    if (talj.getCode()==200){ dialog.dismiss(); }
                    Toast.makeText(activity, talj.getMsg(), Toast.LENGTH_SHORT).show();
                });
            }
        });
    }
}
