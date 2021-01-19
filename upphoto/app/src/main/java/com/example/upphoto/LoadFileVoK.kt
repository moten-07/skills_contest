package com.example.upphoto

import android.graphics.Bitmap
import java.io.File

class LoadFileVoK {
    var file: File? = null
    var pg // 图片下方进度条
            = 0
    var isUpload = false // 标识该文件是否上传

    var bitmap: Bitmap? = null

}