package com.example.redemo1.func;

import com.example.redemo1.aboutIntent.HttpHelp;

import java.util.ArrayList;
import java.util.List;

public class TMSJ {
    // 全称为：toMainSlideshowJson,即首页轮播图Json
    // 正常人谁会起全称啊，缩写已经是最大的尊重了
    /* {
     * "total": 5,
     * "rows": [{},{},{},{}],
     * "code": 200,
     * "msg": "查询成功"
     * }
     */
    public Integer total;
    public List<RowsBean> rows;
    public Integer code;
    public String msg;

    public static class RowsBean{

        /* "rows":[{
         * "id": 5,
         * "imgUrl": "/profile/1-yingdao.jpg",
         * "type": "47",
         * "createTime": "2020-10-12T22:55:17.000+0800",
         * "sort": "1",
         * "display": "N"
         * },
         * {...}
         * ...
         * {...}
         * ]
         */
        public int id;
        public String imgUrl;
        public String type;
        public String createTime;
        public String sort;
        public String display;

        public RowsBean(int id,
                        String imgUrl,
                        String type,
                        String createTime,
                        String sort,
                        String display){
            this.id = id;
            this.imgUrl = imgUrl;
            this.type = type;
            this.createTime = createTime;
            this.sort = sort;
            this.display = display;
        }
        @Override
        public String toString() {
            return "RowsBean{" +
                    "id=" + id +
                    ", imgUrl='" + imgUrl + '\'' +
                    ", type='" + type + '\'' +
                    ", createTime='" + createTime + '\'' +
                    ", sort='" + sort + '\'' +
                    ", display='" + display + '\'' +
                    '}';
        }
        public static List<RowsBean>imglist(){
            HttpHelp help = new HttpHelp();
            List<TMSJ.RowsBean>imglist = new ArrayList<>();
            // 应该通过HttpHelp的getMainImg（1,10）获取，然后解析、绑定到imglist中
            // 暂时先这样,主要是解析还没做上去
            imglist.add(new TMSJ.RowsBean(10,
                    help.getHearUri()+"/profile/home2.png",
                    "45",
                    "2020-10-12T22:55:17.000+0800",
                    "2","N"));
            imglist.add(new TMSJ.RowsBean(11,
                    help.getHearUri()+"/profile/home3.png",
                    "45",
                    "2020-10-12T22:55:17.000+0800",
                    "3","N"));
            imglist.add(new TMSJ.RowsBean(12,
                    help.getHearUri()+"/profile/home4.png",
                    "45",
                    "2020-10-12T22:55:17.000+0800",
                    "4","N"));
            imglist.add(new TMSJ.RowsBean(13,
                    help.getHearUri()+"/profile/home1.png",
                    "45",
                    "2020-10-12T22:55:17.000+0800",
                    "1","N"));
            return imglist;
        }
    }

    @Override
    public String toString() {
        return "tojson{" +
                "total=" + total +
                ", rows=" + rows +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
