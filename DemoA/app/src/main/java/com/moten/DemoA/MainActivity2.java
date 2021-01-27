package com.moten.DemoA;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.moten.DemoA.func.TALJ;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity2 extends AppCompatActivity {
    // 工具人
    String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        login();
    }
    private void login(){
        String loginJson = "{\"username\":\"nameIsPi\"," +
                "\"password\":\"897946\"\n}";
        RequestBody body = RequestBody.create(loginJson, MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .url("http://dasai.sdvcst.edu.cn:8080/login")
                .post(body)
                .build();
        Call call = new OkHttpClient().newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) { e.printStackTrace(); }
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String result = response.body().string();
                TALJ talj = new Gson().fromJson(result,TALJ.class);
                Log.d("msg", talj.getMsg());
                Log.d("code",talj.getCode()+"");
                Log.d("token",talj.getToken());
                runOnUiThread(()->{
                    if (talj.getCode() == 200){
                        token = talj.getToken();
                        run();
                    }
                });
            }
        });
    }
    private void run(){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://dasai.sdvcst.edu.cn:8080/system/user/"+Integer.valueOf("668"))
                .get()
                .addHeader("authorization",token)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) { e.printStackTrace();}
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String result = response.body().string();
                Log.d("result",result);
                MainActivity2.this.runOnUiThread(()->{
                    ((TextView)findViewById(R.id.textView3)).setText(result);
                });
            }
        });
    }
}