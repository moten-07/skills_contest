package com.moten.DemoA.aboutIntent;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.moten.DemoA.func.TMSJ;

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
                            .url(help.getHearUri()+help.getGuideImg(1,10))
                            .get().build();
                    Response response = new OkHttpClient()
                            .newCall(request).execute();
                    String data = response.body().string();
                    TMSJ t = new Gson().fromJson(data,TMSJ.class);
                    Message message = new Message();
                    message.what = 001;
                    message.obj = new ArrayList<String>();
                    for (int i = 0;i<t.rows.size();i++){
                        ((List<String>)message.obj).add(t.rows.get(i).imgUrl);
                    }
                    handler.sendMessage(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void getMainImg(Handler handler){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Request request = new Request
                            .Builder()
                            .url(help.getHearUri()+help.getMainImg(1,10))
                            .get().build();
                    Response response = new OkHttpClient()
                            .newCall(request).execute();
                    String data = response.body().string();
                    TMSJ t = new Gson().fromJson(data,TMSJ.class);
                    Message message = new Message();
                    message.what = 002;
                    message.obj = new ArrayList<String>();
                    for (int i = 0;i<t.rows.size();i++){
                        ((List<String>)message.obj).add(t.rows.get(i).imgUrl);
                    }
                    handler.sendMessage(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
