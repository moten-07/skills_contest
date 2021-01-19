package com.example.upphoto;

import android.graphics.Bitmap;

import java.io.File;

public class LoadFileVo {
    File file;
    int pg;                     // 图片下方进度条
    boolean isUpload = false;   // 标识该文件是否上传
    Bitmap bitmap;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public int getPg() {
        return pg;
    }

    public void setPg(int pg) {
        this.pg = pg;
    }

    public boolean isUpload() {
        return isUpload;
    }

    public void setUpload(boolean upload) {
        isUpload = upload;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
