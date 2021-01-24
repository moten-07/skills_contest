package com.moten.DemoA.aboutIntent;

import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;
import com.moten.DemoA.func.TAFJ;
import com.moten.DemoA.func.TGAMSJ;
import com.moten.DemoA.jGuideActivity;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class UserOkhttp {
    // 数据解析类
    HttpHelp help = new HttpHelp();

    List<TGAMSJ.RowsDTO>TRlist = new ArrayList<>();
    public void getGAMImg(int pageNum,int pageSize,int type){
        // 解析引导页和首页的数据
        try {
            Request request = new Request
                    .Builder()
                    .url(help.getHearUri()+help.getGAMImg(pageNum,pageSize,type))
                    .get().build();
            Response response = new OkHttpClient()
                    .newCall(request).execute();
            String data = response.body().string();
            TGAMSJ tgamsj = new Gson().fromJson(data, TGAMSJ.class);
            for (int i = 0;i< tgamsj.getRows().size();i++){
                TRlist.add(tgamsj.getRows().get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<TGAMSJ.RowsDTO>getTRList(){
        // 返回引导页和首页的数据组
        return TRlist;
    }

    List<TAFJ.Rows> TRlist2 = new ArrayList<>();
    public void getRecommendedUrl(int pageNum,int pageSize){
        // 解析推荐服务
        try{
            Request request = new Request.Builder()
                    .url(help.getHearUri()+help.getRecommendedUrl(pageNum,pageSize))
                    .get().build();
            Response response = new OkHttpClient().newCall(request).execute();
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
        // 解析推荐服务
        try{
            Request request = new Request.Builder()
                    .url(help.getHearUri()+help.getAllServe())
                    .get().build();
            Response response = new OkHttpClient().newCall(request).execute();
            String data = response.body().string();
            TAFJ tafj = new Gson().fromJson(data,TAFJ.class);
            for(TAFJ.Rows tr : tafj.getRows()){
                TRlist2.add(tr);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public List<TAFJ.Rows>getTRList2(){
        // 返回引导页和首页的数据组
        return TRlist2;
    }


}
