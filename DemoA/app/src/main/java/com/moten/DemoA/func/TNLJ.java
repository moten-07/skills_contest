package com.moten.DemoA.func;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TNLJ {
    //to News List Json
    /**
     * total : 5
     * rows : [{"searchValue":null,"createBy":null,"createTime":"2020-10-12 16:06:58","updateBy":null,"updateTime":"2020-10-12 16:07:01","remark":null,"params":{},"id":5,"title":"外交部：将妥善安排驻休斯敦总领馆人员","content":"汪文斌：关于中国驻休斯敦总领馆馆员的有关情况，相信你已经从媒体上看到了。我这里要说的是，对于中国驻休斯敦总领馆的人员，中方将会作出妥善的安排。","imgUrl":"/profile/xwen3.jpg","pressCategory":"时政","isRecommend":0,"likeNumber":258,"viewsNumber":300,"userId":1,"pressStatus":0},{"searchValue":null,"createBy":null,"createTime":"2020-10-12 16:30:49","updateBy":null,"updateTime":"2020-10-12 16:30:51","remark":null,"params":{},"id":6,"title":"民宿设计，再造空间之美","content":"近年来，伴随特色小镇、美丽乡村建设扎实推进，依托乡村闲置民居进行改造再利用的民宿业快速发展，民宿设计成为国内建筑领域的热点话题之一。一些乡村民宿经过设计改造，既保留了民居的古朴之美，亦适应了现代生活方式，在一定程度上带动了乡村整体发展。","imgUrl":"/profile/xwn4.jpg","pressCategory":"时政","isRecommend":1,"likeNumber":200,"viewsNumber":210,"userId":1,"pressStatus":0},{"searchValue":null,"createBy":null,"createTime":"2020-10-12 16:31:29","updateBy":null,"updateTime":"2020-10-12 16:31:32","remark":null,"params":{},"id":7,"title":"短视频唯流量走不远","content":"当前，短视频平台深入人们的日常生活，但部分网红为吸引用户点赞、转发、赚流量频出\u201c奇招\u201d，有的甚至突破法律红线。业内人士指出，优质内容才是网络平台健康发展的王牌，企图以突破底线来吸引眼球、换取流量的做法，于德不符、于法不容，这样的博主\u201c走不好也走不远\u201d。","imgUrl":"/profile/xwem5.jpg","pressCategory":"时政","isRecommend":0,"likeNumber":140,"viewsNumber":188,"userId":1,"pressStatus":0},{"searchValue":null,"createBy":null,"createTime":"2020-10-12 16:32:19","updateBy":null,"updateTime":"2020-10-12 16:32:21","remark":null,"params":{},"id":8,"title":"文创月饼：莫以文创之名过度包装","content":"距离中秋节还有不到10天，月饼也进入销售高潮。借着文创风的盛行，造型新颖、包装精美的文创月饼今年依然走俏。但记者发现，即便在倡导节俭的新风尚下，\u201c小饼装大盒\u201d的情形依然存在。","imgUrl":"/profile/xwens.jpg","pressCategory":"时政","isRecommend":0,"likeNumber":154,"viewsNumber":220,"userId":1,"pressStatus":0},{"searchValue":null,"createBy":null,"createTime":"2020-10-12 16:33:15","updateBy":null,"updateTime":"2020-10-12 16:33:19","remark":null,"params":{},"id":9,"title":"首都机场\u201c十一\u201d当日将迎旅客出港高峰","content":"\u201c国庆\u201d\u201c中秋\u201d双节将至，据首都机场预测，9月28日至10月11日，首都机场计划起降航班1.43万架次，日均1021架次;运送旅客218.9万人次，日均15.64万人次。首都机场提醒，携带月饼坐飞机，需确认月饼礼盒内是否配有刀叉(包括塑料刀叉)或者红酒，以提前办理托运手续。","imgUrl":"/profile/xwens.jpg","pressCategory":"时政","isRecommend":0,"likeNumber":123,"viewsNumber":321,"userId":1,"pressStatus":0}]
     * code : 200
     * msg : 查询成功
     */

    @SerializedName("total")
    private Integer total;
    @SerializedName("code")
    private Integer code;
    @SerializedName("msg")
    private String msg;
    @SerializedName("rows")
    private List<Rows> rows;

    public static class Rows {

        /**
         * searchValue : null
         * createBy : null
         * createTime : 2020-10-12 16:06:58
         * updateBy : null
         * updateTime : 2020-10-12 16:07:01
         * remark : null
         * params : {}
         * id : 5
         * title : 外交部：将妥善安排驻休斯敦总领馆人员
         * content : 汪文斌：关于中国驻休斯敦总领馆馆员的有关情况，相信你已经从媒体上看到了。我这里要说的是，对于中国驻休斯敦总领馆的人员，中方将会作出妥善的安排。
         * imgUrl : /profile/xwen3.jpg
         * pressCategory : 时政
         * isRecommend : 0
         * likeNumber : 258
         * viewsNumber : 300
         * userId : 1
         * pressStatus : 0
         */

        @SerializedName("searchValue")
        private Object searchValue;
        @SerializedName("createBy")
        private Object createBy;
        @SerializedName("createTime")
        private String createTime;
        @SerializedName("updateBy")
        private Object updateBy;
        @SerializedName("updateTime")
        private String updateTime;
        @SerializedName("remark")
        private Object remark;
        @SerializedName("params")
        private Params params;
        @SerializedName("id")
        private Integer id;
        @SerializedName("title")
        private String title;
        @SerializedName("content")
        private String content;
        @SerializedName("imgUrl")
        private String imgUrl;
        @SerializedName("pressCategory")
        private String pressCategory;
        @SerializedName("isRecommend")
        private Integer isRecommend;
        @SerializedName("likeNumber")
        private Integer likeNumber;
        @SerializedName("viewsNumber")
        private Integer viewsNumber;
        @SerializedName("userId")
        private Integer userId;
        @SerializedName("pressStatus")
        private Integer pressStatus;

        public static class Params {
        }

        @Override
        public String toString() {
            return "Rows{" +
                    "searchValue=" + searchValue +
                    ", createBy=" + createBy +
                    ", createTime='" + createTime + '\'' +
                    ", updateBy=" + updateBy +
                    ", updateTime='" + updateTime + '\'' +
                    ", remark=" + remark +
                    ", params=" + params +
                    ", id=" + id +
                    ", title='" + title + '\'' +
                    ", content='" + content + '\'' +
                    ", imgUrl='" + imgUrl + '\'' +
                    ", pressCategory='" + pressCategory + '\'' +
                    ", isRecommend=" + isRecommend +
                    ", likeNumber=" + likeNumber +
                    ", viewsNumber=" + viewsNumber +
                    ", userId=" + userId +
                    ", pressStatus=" + pressStatus +
                    '}';
        }

        public Object getSearchValue() {
            return searchValue;
        }

        public void setSearchValue(Object searchValue) {
            this.searchValue = searchValue;
        }

        public Object getCreateBy() {
            return createBy;
        }

        public void setCreateBy(Object createBy) {
            this.createBy = createBy;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(Object updateBy) {
            this.updateBy = updateBy;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public Params getParams() {
            return params;
        }

        public void setParams(Params params) {
            this.params = params;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getPressCategory() {
            return pressCategory;
        }

        public void setPressCategory(String pressCategory) {
            this.pressCategory = pressCategory;
        }

        public Integer getIsRecommend() {
            return isRecommend;
        }

        public void setIsRecommend(Integer isRecommend) {
            this.isRecommend = isRecommend;
        }

        public Integer getLikeNumber() {
            return likeNumber;
        }

        public void setLikeNumber(Integer likeNumber) {
            this.likeNumber = likeNumber;
        }

        public Integer getViewsNumber() {
            return viewsNumber;
        }

        public void setViewsNumber(Integer viewsNumber) {
            this.viewsNumber = viewsNumber;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public Integer getPressStatus() {
            return pressStatus;
        }

        public void setPressStatus(Integer pressStatus) {
            this.pressStatus = pressStatus;
        }
    }

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

    public List<Rows> getRows() {
        return rows;
    }

    public void setRows(List<Rows> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "TNLJ{" +
                "total=" + total +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", rows=" + rows +
                '}';
    }
}
