package com.moten.DemoA.aboutIntent;


import com.google.gson.Gson;
import com.moten.DemoA.func.TAFJ;
import com.moten.DemoA.func.TGAMSJ;
import com.moten.DemoA.func.TNLJ;
import com.moten.DemoA.func.TNTJ;

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

    List<TNTJ.Data>NTList=new ArrayList<>();
    public void getNewsType(){
        try{
            Request request = new Request.Builder()
                    .url(help.getHearUri()+help.getNewsType())
                    .get().build();
            Response response = new OkHttpClient().newCall(request).execute();
            String data = response.body().string();
            TNTJ tntj = new Gson().fromJson(data,TNTJ.class);
            for (int i = 0;i<tntj.getData().size(); i++){
                NTList.add(tntj.getData().get(i));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public List<TNTJ.Data> getNTList(){
        return NTList;
    }

    List<TNLJ.Rows> NList = new ArrayList<>();
    public List<TNLJ.Rows>getNList(){return NList;}
    public void getNewsListUrl(int pageNum,int pageSize,int pressCategory){
        try{
            Request request = new Request.Builder()
                    .url(help.getHearUri()+help.getNewsListUrl(pageNum,pageSize,pressCategory))
                    .get().build();
            Response response = new OkHttpClient().newCall(request).execute();
            String data = response.body().string();
            TNLJ tnlj = new Gson().fromJson(data,TNLJ.class);
            for (int i = 0; i<tnlj.getRows().size();i++){
                NList.add(tnlj.getRows().get(i));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
