package com.example.redemo1.type;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.util.Log;
import android.content.pm.PackageManager;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import static android.content.Context.LOCATION_SERVICE;


public class limts {
    // 权限列表
    Activity activity;
    public limts(Activity activity){ this.activity=activity;}
    String [] limits=new String[]{
            Manifest.permission.INTERNET,
            Manifest.permission.ACCESS_FINE_LOCATION // 较为精确的定位信息
    };

    String getToGps;



    public void getInternet(){
        // 申请手机网络访问权限
        int internet = ContextCompat.checkSelfPermission(activity.getBaseContext(),limits[0]);
        if(internet!= PackageManager.PERMISSION_GRANTED){
            // 不属于危险权限，直接在AndroidManifest中获取即可
            ActivityCompat.requestPermissions(activity,new String[]{limits[0]},100);
        }
        Log.d("Visit internet",(internet==PackageManager.PERMISSION_GRANTED)+"");
    }

    public void getGPS(Context context){
        // 申请位置信息
        int gps=ContextCompat.checkSelfPermission(activity.getBaseContext(),limits[1]);
        if (gps !=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(activity,new String[]{limits[1]},100);
        }
        Log.d("Visit gps",(gps==PackageManager.PERMISSION_GRANTED)+"");
        LocationManager locationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(context,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
        &&ActivityCompat.checkSelfPermission(context,Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // 权限检查
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER, // 指定GPS定位提供者
                1000,// 间隔时间
                1, // 位置间隔
                new LocationListener() { // 监听GPS定位信息是否改变
                    @Override
                    public void onLocationChanged(@NonNull Location location) {
                        // GPS信息发生改变时
                    }

                    @Override
                    public void onProviderDisabled(@NonNull String provider) {
                        // 定位提供者启动时,可不写（AS4.1）
                    }

                    @Override
                    public void onProviderEnabled(@NonNull String provider) {
                        // 定位提供者关闭时,可不写（AS4.1）
                    }
                }
        );
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        // 获取最新的定位信息
        locationUpdates(location);
    }

    public void locationUpdates(Location location){
        if(location!=null){
            // 判断定位信息是否为空
            StringBuilder stringBuilder = new StringBuilder();  // 创建字符串构建器，用于记录定位信息
            stringBuilder.append("您的位置是：\n");
            stringBuilder.append("经度：\n");
            stringBuilder.append(location.getLongitude());
            stringBuilder.append("\n纬度：");
            stringBuilder.append(location.getLatitude());
            getToGps=stringBuilder.toString();
        }else{
            getToGps="没有获取到GPS信息";
        }
    }
}
