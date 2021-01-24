package com.moten.DemoA.func;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TAFJ {
    // to Application Field Json：应用领域数据类

    /**
     * total : 6
     * rows : [{"searchValue":null,"createBy":null,"createTime":"2020-10-12 18:17:23","updateBy":null,"updateTime":"2020-10-19 16:56:47","remark":null,"params":{},"id":2,"serviceName":"城市地铁","serviceDesc":"城市地铁路线","serviceType":"1","imgUrl":"/profile/ditie.png","pid":1,"isRecommend":1,"link":"metro_query/index"},{"searchValue":null,"createBy":null,"createTime":"2020-10-12 18:17:33","updateBy":null,"updateTime":"2020-10-19 16:56:47","remark":null,"params":{},"id":3,"serviceName":"智慧巴士","serviceDesc":"智慧巴士站点","serviceType":"1","imgUrl":"/profile/bus.png","pid":1,"isRecommend":1,"link":"bus_query/custom_shuttle"},{"searchValue":null,"createBy":null,"createTime":"2020-10-12 18:17:58","updateBy":null,"updateTime":"2020-10-19 16:56:47","remark":null,"params":{},"id":5,"serviceName":"门诊预约","serviceDesc":"快捷方便不要出门也能门诊预约","serviceType":"1","imgUrl":"/profile/menzheng.png","pid":1,"isRecommend":1,"link":"outpatient/hospitalList"},{"searchValue":null,"createBy":null,"createTime":"2020-10-12 18:18:21","updateBy":null,"updateTime":"2020-10-19 16:56:47","remark":null,"params":{},"id":7,"serviceName":"生活缴费","serviceDesc":"不要出门也能缴费","serviceType":"2","imgUrl":"/profile/live.png","pid":1,"isRecommend":1,"link":"living_expenses/index"},{"searchValue":null,"createBy":null,"createTime":"2020-10-12 18:18:39","updateBy":null,"updateTime":"2020-10-19 16:56:47","remark":null,"params":{},"id":9,"serviceName":"违章查询","serviceDesc":"查询车辆违章","serviceType":"3","imgUrl":"/profile/weizhang.png","pid":1,"isRecommend":1,"link":"traffic/index"},{"searchValue":null,"createBy":null,"createTime":"2020-10-23 16:17:56","updateBy":null,"updateTime":"2020-10-23 16:17:58","remark":null,"params":{},"id":17,"serviceName":"停车场","serviceDesc":"查询停车场","serviceType":"3","imgUrl":"/profile/pack.png","pid":1,"isRecommend":1,"link":"park/index"}]
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



    public static class Rows {

        /**
         * searchValue : null
         * createBy : null
         * createTime : 2020-10-12 18:17:23
         * updateBy : null
         * updateTime : 2020-10-19 16:56:47
         * remark : null
         * params : {}
         * id : 2
         * serviceName : 城市地铁
         * serviceDesc : 城市地铁路线
         * serviceType : 1
         * imgUrl : /profile/ditie.png
         * pid : 1
         * isRecommend : 1
         * link : metro_query/index
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
        @SerializedName("serviceName")
        private String serviceName;
        @SerializedName("serviceDesc")
        private String serviceDesc;
        @SerializedName("serviceType")
        private String serviceType;
        @SerializedName("imgUrl")
        private String imgUrl;
        @SerializedName("pid")
        private Integer pid;
        @SerializedName("isRecommend")
        private Integer isRecommend;
        @SerializedName("link")
        private String link;

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

        public String getServiceName() {
            return serviceName;
        }

        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
        }

        public String getServiceDesc() {
            return serviceDesc;
        }

        public void setServiceDesc(String serviceDesc) {
            this.serviceDesc = serviceDesc;
        }

        public String getServiceType() {
            return serviceType;
        }

        public void setServiceType(String serviceType) {
            this.serviceType = serviceType;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public Integer getPid() {
            return pid;
        }

        public void setPid(Integer pid) {
            this.pid = pid;
        }

        public Integer getIsRecommend() {
            return isRecommend;
        }

        public void setIsRecommend(Integer isRecommend) {
            this.isRecommend = isRecommend;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

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
                    ", serviceName='" + serviceName + '\'' +
                    ", serviceDesc='" + serviceDesc + '\'' +
                    ", serviceType='" + serviceType + '\'' +
                    ", imgUrl='" + imgUrl + '\'' +
                    ", pid=" + pid +
                    ", isRecommend=" + isRecommend +
                    ", link='" + link + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "TAFJ{" +
                "total=" + total +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", rows=" + rows +
                '}';
    }
}
