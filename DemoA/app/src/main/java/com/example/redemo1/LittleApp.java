package com.example.redemo1;

import android.app.Activity;

public class LittleApp {
    // 应用服务类
    public int image;       // 图标
    public String title;    // 标题
    public Activity[] activity;     // 跳转地址

    public LittleApp(int image,String title,Activity... activity){
        this.image=image;
        this.title=title;
        this.activity=activity;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Activity[] getActivity() {
        return activity;
    }

    public void setActivity(Activity[] activity) {
        this.activity = activity;
    }
}
