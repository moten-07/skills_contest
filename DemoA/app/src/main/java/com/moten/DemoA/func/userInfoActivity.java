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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.moten.DemoA.R;
import com.moten.DemoA.aboutIntent.HttpHelp;
import com.moten.DemoA.aboutIntent.UserOkhttp;
import com.moten.DemoA.type.limts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.lang.ref.WeakReference;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class userInfoActivity extends AppCompatActivity {
    Toolbar toolbar;
    EditText user_info_newname,user_info_newphone,remark;
    RadioButton user_info_newsex_n,user_info_newsex_w;
    TextView user_info_paper;
    Button user_info_newicon,user_info_save;
    SharedPreferences sp;
    ImageView user_info_icon;
    File file;
    String sex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        init();
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
        user_info_newsex_n = findViewById(R.id.user_info_newsex_n);
        user_info_newsex_w = findViewById(R.id.user_info_newsex_w);
        user_info_newphone = findViewById(R.id.user_info_newphone);
        user_info_paper = findViewById(R.id.user_info_paper);
        user_info_icon= findViewById(R.id.user_info_icon);
        user_info_newicon = findViewById(R.id.user_info_newicon);
        user_info_save = findViewById(R.id.user_info_save);
        remark = findViewById(R.id.remark);

        Glide.with(this)
                .load(new HttpHelp().getHearUri()+sp.getString("user_icon",null))
                .placeholder(R.mipmap.kls)
                .into(user_info_icon);
        ((TextView)findViewById(R.id.user_icon_id)).setText("账号："+sp.getString("user_id","..."));
        user_info_icon.setImageResource(R.drawable.ic_baseline_account_box_24);
        user_info_newname.setText(sp.getString("user_info_name","默认昵称"));

        user_info_newphone.setText(sp.getString("user_info_phone","1234567890"));
        user_info_paper.setText("证件号码："+toId());// +存储的号码，但要打码
        remark.setText(sp.getString("remark",null));
        sex = sp.getString("user_info_sex",null);
        if (sex.equals("1")){
            user_info_newsex_n.setChecked(true);
        }else{
            user_info_newsex_w.setChecked(true);
        }

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

                editor.putString("user_info_name",user_info_newname.getText().toString());
//                editor.putString("user_info_sex",user_info_newsex.getText().toString());
                editor.putString("user_info_phone",user_info_newphone.getText().toString());
                editor.putString("remark",remark.getText().toString());
                editor.commit();
                // 服务器端的修改，同步下本地数据就行了，懒得传值
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
                String filePath = uri.getPath();
                Log.d("URI",filePath);
                // 图片文件地址
                file = new File(
                        this.getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath(),
                        "pic.jpg");
                file.createNewFile();
                Log.d("filePath",file.getPath());
                // 创建一个文件
                // 输出，写入
                InputStream reader = this.getContentResolver().openInputStream(uri);
                OutputStream writer = new FileOutputStream(file.getPath());
                byte [] cr = new byte[8192];
                int i = 0;
                while (i!=-1){
                    i = reader.read(cr);
                    writer.write(cr);
                }
                writer.close();
                reader.close();

                Glide.with(this)
                        .load(uri)
                        .placeholder(R.mipmap.kls)
                        .into(user_info_icon);
            }catch (Exception e){
                Log.e("error",e.toString());
            }
        }else{
            // 没选择照片时的情况
            file = null;
        }
    }

}