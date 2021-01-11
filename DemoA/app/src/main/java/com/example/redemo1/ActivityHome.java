package com.example.redemo1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

public class ActivityHome extends AppCompatActivity {
    Toolbar toolbar;
    // 注意，需加载androidx下的toolbar包，一般是第二个
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("Home");
        // 更改标题栏
        toolbar=findViewById(R.id.newBar);
        setSupportActionBar(toolbar);
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET)!= PackageManager.PERMISSION_GRANTED){
            // 申请手机网络访问权限
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.INTERNET},1);
        }

    }
}