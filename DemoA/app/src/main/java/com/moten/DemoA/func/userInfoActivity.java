package com.moten.DemoA.func;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.moten.DemoA.R;

import java.lang.ref.WeakReference;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class userInfoActivity extends AppCompatActivity {
    Toolbar toolbar;
    EditText user_info_newname,user_info_newsex,user_info_newphone;
    TextView user_info_paper;
    Button user_info_newicon,user_info_save;
    SharedPreferences sp;
    ImageView user_info_icon;
    String imgurl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        init();
        // 头像可修改-》相机权限，相册读取权限，文件上传
        // 所有数据上传后先储存在SQLite，然后再上传到服务器的数据库中
        // 获取网络资源（指头像）
        // 还没做
    }

    private void init(){
        toolbar = findViewById(R.id.this_subway_bar);
        setSupportActionBar(toolbar);
        setTitle("个人信息");
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        sp = getSharedPreferences("location", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();

        user_info_newname = findViewById(R.id.user_info_newname);
        user_info_newsex = findViewById(R.id.user_info_newsex);
        user_info_newphone = findViewById(R.id.user_info_newphone);

        user_info_paper = findViewById(R.id.user_info_paper);

        user_info_icon= findViewById(R.id.user_info_icon);

        user_info_newicon = findViewById(R.id.user_info_newicon);
        user_info_save = findViewById(R.id.user_info_save);

        user_info_icon.setImageResource(R.drawable.ic_baseline_account_box_24);

        user_info_newname.setText(sp.getString("user_info_name","默认昵称"));
        user_info_newsex.setText(sp.getString("user_info_sex","默认性别"));
        user_info_newphone.setText(sp.getString("user_info_phone","1234567890"));
        user_info_paper.setText("证件号码："+toId());// +存储的号码，但要打码

        user_info_newicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 打开相册
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,1);
            }
        });
        user_info_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 保存修改
                editor.putString("user_info_name",user_info_newname.getText().toString());
                editor.putString("user_info_sex",user_info_newsex.getText().toString());
                editor.putString("user_info_phone",user_info_newphone.getText().toString());
                editor.commit();
                Toast.makeText(userInfoActivity.this,"修改成功",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String toId(){
        String Id = sp.getString("user_paper","123456789012345678");
        // 别问我上传证件的功能在哪，没这需求，要有也容易,无非就是sp.edit().putString("user_paper",[imageid])，但不想做
        StringBuilder sb = new StringBuilder(Id);
        sb.replace(2,14,"**************");
        return sb.toString();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // 左上左箭头监听
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        // 读取相册图片文件
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            if (resultCode == RESULT_OK){
                Uri uri = data.getData();
                Log.e("URI",uri.toString());
                ContentResolver cr = this.getContentResolver();
                try {
                    Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                    user_info_icon.setImageBitmap(bitmap);
                }catch (Exception e){
                    Log.e("error",e.toString());
                }
            }
        }
    }


    private void sendOkHttp(final String imgurl){
        // okhttp读取网络图片文件
        this.imgurl=imgurl;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client =new OkHttpClient();
                    Request request = new Request.Builder().url(imgurl).build();
                    Response response = client.newCall(request).execute();
                    Bitmap bitmap = BitmapFactory.decodeStream(response.body().byteStream());
                    Message message = new Message();
                    message.what = 369;
                    message.obj = bitmap;
                    handler.sendMessage(message);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    class MyHandler extends Handler{
        WeakReference<userInfoActivity> myactivity;
        public MyHandler(userInfoActivity activity){
            myactivity = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            userInfoActivity activity = myactivity.get();
            if (activity != null){
                if (msg.what == 369){
                    Bitmap bitmap = (Bitmap)msg.obj;
                    user_info_icon.setImageBitmap(bitmap);
                }else{
                    return;
                }
            }
        }
    }
    MyHandler handler = new MyHandler(this);
}