package com.moten.DemoA;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.moten.DemoA.func.UpPassActivity;
import com.moten.DemoA.func.Subway2Activity;
import com.moten.DemoA.func.SubwayActivity;
import com.moten.DemoA.func.manySubway;
import com.moten.DemoA.func.userInfoActivity;
import com.moten.DemoA.func.userOrderActivity;

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
            case "newsViewPager":
                textView.setText("首页轮播图:\n" + intent.getStringExtra("where"));
                break;
            case "subway":
                textView.setText("跳转到：" + intent.getStringExtra("title"));
                finish();
                Intent intentsubway = new Intent(MainActivity.this, Subway2Activity.class);
                intentsubway.putExtra("title", intent.getStringExtra("title"));
                startActivity(intentsubway);
                break;
            case "manySubway":
                textView.setText("跳转到地铁列表……");
                finish();
                startActivity(new Intent(this, manySubway.class));
                break;
            case "user_info":
                textView.setText("跳转到个人中心……");
                finish();
                startActivity(new Intent(this, userInfoActivity.class));
                break;
            case "user_order":
                textView.setText("跳转到订单列表……");
                finish();
                startActivity(new Intent(this, userOrderActivity.class));
                break;
            case "user_update_pass":
                textView.setText("跳转到修改密码……");
                finish();
                startActivity(new Intent(this, UpPassActivity.class));
                break;
            case "user_feed":
                textView.setText("跳转到意见反馈……");
                break;
            case "user_out":
                textView.setText("跳转到退出登录……");
                break;
        }

        // 没有finish()的页面会在这里处理
        switch (textView.getText().toString()) {
            case "城市地铁":
                finish();
                startActivity(new Intent(MainActivity.this, SubwayActivity.class));
                break;
            case "更多服务":
                finish();
                Intent intent1=new Intent(MainActivity.this,ActivityHome.class);
                intent1.putExtra("choose",5);
                startActivity(intent1);
                break;
        }
        // 根据传过来的title跳转到正确的activity，未完成
    }
}