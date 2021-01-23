package com.moten.DemoA.func;

import com.google.gson.annotations.SerializedName;
import com.moten.DemoA.aboutIntent.HttpHelp;
import com.moten.DemoA.aboutIntent.UserOkhttp;

import java.util.ArrayList;
import java.util.List;
public class TGAMSJ {

    // 全称为：toGuideAndMainSlideshowJson,即引导页和主页轮播图Json
    // 正常人谁会起全称啊，缩写已经是最大的尊重了
    // 这俩除了值都一样

    /**
     * total : 5
     * rows : [{"id":5,"imgUrl":"/profile/1-yingdao.jpg","type":"47",
     * "createTime":"2020-10-12T22:55:17.000+0800","sort":"1","display":"N"},
     * {"id":6,"imgUrl":"/profile/2-yingdao.jpg","type":"47","createTime":"2020-10-12T22:55:17.000+0800","sort":"2","display":"N"},{"id":7,"imgUrl":"/profile/3-yingdao.jpg","type":"47","createTime":"2020-10-12T22:55:17.000+0800","sort":"3","display":"N"},{"id":8,"imgUrl":"/profile/4-yingdao.jpg","type":"47","createTime":"2020-10-12T22:55:17.000+0800","sort":"4","display":"N"},{"id":9,"imgUrl":"/profile/5-yingdao.jpg","type":"47","createTime":"2020-10-12T22:55:17.000+0800","sort":"5","display":"N"}]
     * code : 200
     * msg : 查询成功
     */

    @SerializedName("total")
    private Integer total;
    @SerializedName("code")
    private Integer code;
    @SerializedName("msg")
    private String msg;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<RowsDTO> getRows() {
        return rows;
    }

    public void setRows(List<RowsDTO> rows) {
        this.rows = rows;
    }

    @SerializedName("rows")
    private List<RowsDTO> rows;

    public static class RowsDTO {
        /**
         * id : 5
         * imgUrl : /profile/1-yingdao.jpg
         * type : 47
         * createTime : 2020-10-12T22:55:17.000+0800
         * sort : 1
         * display : N
         */

        @SerializedName("id")
        private Integer id;
        @SerializedName("imgUrl")
        private String imgUrl;
        @SerializedName("type")
        private String type;
        @SerializedName("createTime")
        private String createTime;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getDisplay() {
            return display;
        }

        public void setDisplay(String display) {
            this.display = display;
        }

        @SerializedName("sort")
        private String sort;
        @SerializedName("display")
        private String display;

        public RowsDTO(Integer id, String imgUrl, String type,
                       String createTime, String sort, String display) {
            this.id = id;
            this.imgUrl = imgUrl;
            this.type = type;
            this.createTime = createTime;
            this.sort = sort;
            this.display = display;
        }

        public static List<RowsDTO>imglist(){
            List<TGAMSJ.RowsDTO>imglist = new UserOkhttp().getGAMImg(1,10,45);
            return imglist;
        }
    }
}
