package com.moten.DemoA.aboutIntent;

import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;
import com.moten.DemoA.func.TGAMSJ;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class UserOkhttp {
    // 数据解析类
    HttpHelp help = new HttpHelp();
    public void getGuideImg(Handler handler){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Request request = new Request
                            .Builder()
                            .url(help.getHearUri()+help.getGAMImg(1,10,45))
                            .get().build();
                    Response response = new OkHttpClient()
                            .newCall(request).execute();
                    String data = response.body().string();
                    TGAMSJ t = new Gson().fromJson(data, TGAMSJ.class);
                    Message message = new Message();
                    message.what = 001;
                    message.obj = new ArrayList<String>();
                    for (int i = 0;i<t.getRows().size();i++){
                        ((List<String>)message.obj).add(t.getRows().get(i).getImgUrl());
                    }
                    handler.sendMessage(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public List<TGAMSJ.RowsDTO> getGAMImg(int pageNum,int pageSize,int type){
        List<TGAMSJ.RowsDTO>list = new ArrayList<>();
        try {
            Request request = new Request
                    .Builder()
                    .url(help.getHearUri()+help.getGAMImg(pageNum,pageSize,type))
                    .get().build();
            Response response = new OkHttpClient()
                    .newCall(request).execute();
            String data = response.body().string();
            TGAMSJ t = new Gson().fromJson(data, TGAMSJ.class);
            Message message = new Message();
            message.what = 002;
            message.obj = t;
            list=t.getRows();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


}
