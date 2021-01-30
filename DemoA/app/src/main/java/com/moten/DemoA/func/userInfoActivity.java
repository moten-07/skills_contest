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
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
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

import com.bumptech.glide.Glide;
import com.moten.DemoA.R;
import com.moten.DemoA.aboutIntent.UserOkhttp;
import com.moten.DemoA.type.limts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
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
    File file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        init();
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


        ((TextView)findViewById(R.id.user_icon_id)).setText("账号："+sp.getString("user_id","..."));
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
                // 本地数据修改

                editor.putString("user_paper","123456789987654321");
                editor.putString("email","123@45.com");
                editor.putString("remark","hhhh");

                editor.putString("user_info_name",user_info_newname.getText().toString());
                editor.putString("user_info_sex",user_info_newsex.getText().toString());
                editor.putString("user_info_phone",user_info_newphone.getText().toString());
                editor.commit();
                // 服务器端的修改，同步下本地数据就行了，懒得传值
                Log.d("uri",file.getPath());

                UserOkhttp userOkhttp = new UserOkhttp();
                userOkhttp.updata(file,userInfoActivity.this);
            }
        });
    }

    private String toId(){
        // 打码
        String Id = sp.getString("user_paper","123456789012345678");
        // 别问我上传证件的功能在哪，没这需求，要有也容易,但不想做
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
        limts limts = new limts(this);
        limts.getWrite();
        // 获取读写权限
        if (requestCode == 1 && resultCode == RESULT_OK){
            try {
                Uri uri = data.getData();
                InputStream stream = this.getContentResolver().openInputStream(uri);
                Log.d("size",stream.available()+"");
                // 获取图片文件大小
                String filePath = uri.getPath();
                Log.d("URI",filePath);
                // 图片文件地址
                file = new File(
                        this.getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath(),
                        "pic.jpg");
//                file.createNewFile();
                Log.d("filePath",file.getPath());
                // 创建一个文件
                // 输出，写入
                FileReader reader = new FileReader(filePath);
                BufferedReader reader1 = new BufferedReader(reader);
                FileWriter writer = new FileWriter(file.getPath());
                BufferedWriter writer1 = new BufferedWriter(writer);
                char [] cr = new char[8192];
                int i = 0;
                while (i!=-1){
                    writer1.write(cr);
                    i = reader1.read();
                }
                writer1.close();
                writer.close();
                reader1.close();
                reader.close();

                Glide.with(this)
                        .load(uri)
                        .placeholder(R.mipmap.kls)
                        .into(user_info_icon);
            }catch (Exception e){
                Log.e("error",e.toString());
            }
        }
    }

}