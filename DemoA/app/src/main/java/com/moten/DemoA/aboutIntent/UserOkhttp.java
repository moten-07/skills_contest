package com.moten.DemoA.aboutIntent;

import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;
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
    List<TGAMSJ.RowsDTO>list = new ArrayList<>();
    public void getGAMImg(int pageNum,int pageSize,int type){
        try {
            Request request = new Request
                    .Builder()
                    .url(help.getHearUri()+help.getGAMImg(pageNum,pageSize,type))
                    .get().build();
            Response response = new OkHttpClient()
                    .newCall(request).execute();
            String data = response.body().string();
            TGAMSJ t = new Gson().fromJson(data, TGAMSJ.class);
            for (int i = 0;i< t.getRows().size();i++){
                list.add(t.getRows().get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<TGAMSJ.RowsDTO>getTRList(){
        // 返回数据组
        return list;
    }


}
