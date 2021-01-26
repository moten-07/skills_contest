package com.moten.DemoA.func;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

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

public class signActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        run();
    }
    private void run(){
        String json = "";
        json = "{\"userName\":\"nameIsPi\"," +
                "\"nickName\":\"pi\"," +
                "\"phonenumber\":\"31415926535\"," +
                "\"sex\":\"1\"," +
                "\"password\":\"897946\"}";
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(json, MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .url("http://dasai.sdvcst.edu.cn:8080/system/user/register")
                .post(body)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) { e.printStackTrace(); }
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String result = response.body().string();
                Log.d("result",result);
            }
        });
    }
}