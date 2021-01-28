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
import com.moten.DemoA.aboutIntent.UserOkhttp;
import com.moten.DemoA.func.TALJ;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Random;

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
        ((TextView)findViewById(R.id.textView3)).setText(new Random().nextInt(10)+"");
    }
    private void login() {
        UserOkhttp userOkhttp = new UserOkhttp();
//        userOkhttp.getCommentsList(1,100,15);
    }
}