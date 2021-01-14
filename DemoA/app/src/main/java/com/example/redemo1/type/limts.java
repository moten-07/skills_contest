package com.example.redemo1.type;

import android.Manifest;
import android.app.Activity;
import android.location.LocationManager;
import android.util.Log;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


public class limts {
    // 权限列表
    Activity activity;
    public limts(Activity activity){ this.activity=activity;}
    String [] limits=new String[]{
            Manifest.permission.INTERNET,
            Manifest.permission.ACCESS_FINE_LOCATION
    };
    public void getInternet(){
        // 申请手机网络访问权限
        int internet = ContextCompat.checkSelfPermission(activity.getBaseContext(),limits[0]);
        if(internet!= PackageManager.PERMISSION_GRANTED){
            // 不属于危险权限，直接在AndroidManifest中获取即可
            ActivityCompat.requestPermissions(activity,new String[]{limits[0]},100);
        }
        Log.d("Visit internet",(internet==PackageManager.PERMISSION_GRANTED)+"");
    }

    public void getGPS(){
        // 申请位置信息
        int gps=ContextCompat.checkSelfPermission(activity.getBaseContext(),limits[1]);
        if (gps !=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(activity,new String[]{limits[1]},100);
        }
        Log.d("Visit gps",(gps==PackageManager.PERMISSION_GRANTED)+"");
    }
}
