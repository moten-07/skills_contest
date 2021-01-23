package com.moten.DemoA.type;

public class LittleApp {
    // 应用服务类
    public int image;       // 图标
    public String title;    // 标题

    public LittleApp(int image,String title){
        this.image=image;
        this.title=title;
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

}
