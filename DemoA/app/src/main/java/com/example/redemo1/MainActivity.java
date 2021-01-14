package com.example.redemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

import com.example.redemo1.func.SubwayActivity;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    // 模块功能
    // 当个中转点，在其他页面没写之前统一传到这里，后续再删除以提高性能（虽然也提高不了多少）
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        Intent intent = getIntent();
        switch (intent.getStringExtra("type")) {
            case "littleApp":
                textView.setText(intent.getStringExtra("title"));
                break;
            case "news":
                textView.setText(intent.getStringExtra("where"));
                break;
            case "newsViewPager":
                textView.setText("首页轮播图" + intent.getStringExtra("where"));
                break;
            case "subway":
                textView.setText("地铁：" + intent.getStringExtra("title"));
                break;
        }
        switch (textView.getText().toString()) {
            case "地铁查询":
                finish();
                startActivity(new Intent(MainActivity.this, SubwayActivity.class));
                break;
            case "更多服务":
                break;
        }
        // 根据传过来的title跳转到正确的activity，未完成
    }
}