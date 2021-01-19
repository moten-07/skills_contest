package com.example.upphoto;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<LoadFileVo> fileList = new ArrayList<>();
    LoadPicAdapter adapter = null;
    RecyclerView rvPic;
    TextView tvNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void initAdapter(){
        rvPic = findViewById(R.id.rvPic);
        tvNum = findViewById(R.id.tvNum);
        fileList.add(new LoadFileVo());
        adapter = new LoadPicAdapter(this,fileList);
        rvPic.setAdapter(adapter);
        rvPic.setLayoutManager(new GridLayoutManager(this,3));
        adapter.setListener(new LoadPicAdapter.OnItemClickListener() {
            @Override
            public void click(View view, int positon) {
                if (fileList.size()>8){
                    Toast.makeText(MainActivity.this,"一次最多上传8张图片",Toast.LENGTH_SHORT).show();
                }else{
                    selectPic();// 选择添加图片方法
                }
            }

            @Override
            public void del(View view) {
                tvNum.setText((fileList.size()-1)+"/8");
            }
        });
    }
    String mPhotoPath;
    Uri uriImage;
    File mPhotoFile = null;
    private void selectPic() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{
                            Manifest.permission.CAMERA,
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                    }, 1);
        }
        final  CharSequence []  items = {"相册","照相"};
        AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
        dlg.setTitle("添加图片");
        dlg.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 这里which是根据选择的方式
                if(which == 0){
                    Intent intent =new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    startActivityForResult(intent,0);
                }else {
                    try {
                        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                        mPhotoPath = getSDPath()+"/"+getPhotoFileName();
                        mPhotoFile = new File((mPhotoPath));
                        if (!mPhotoFile.exists()){
                            mPhotoFile.createNewFile();
                        }
//                        uriImage = FileProvider.getUriForFile(MainActivity.this,getPackageName() + ".provider", createImageFile());
                        uriImage = FileProvider.getUriForFile(MainActivity.this,"com.ahbcd.app.tms.provider", mPhotoFile);
                        Log.i("TAG","onClick:"+mPhotoPath+"--------"+getPackageName()+".provider");
                        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                        intent.putExtra(MediaStore.EXTRA_OUTPUT,uriImage);
                        startActivityForResult(intent,1);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }).create();
        dlg.show();
    }
    public String getSDPath() {
        File sdDir = null;
        boolean sdCardExsit = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        if (sdCardExsit) {
            sdDir = Environment.getExternalStorageDirectory();
        }
        return sdDir.toString();
    }

    private String getPhotoFileName() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("'IMG'_yyyyMMdd_HHmmss");
        return dateFormat.format(date) + ".jpg";
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}