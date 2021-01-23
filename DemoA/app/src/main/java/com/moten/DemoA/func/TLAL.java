package com.moten.DemoA.func;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TLAL {
    // toLittleAppList:应用领域类
    // 这生成器真好用
    /**
     * total : 6
     * rows : [
     * {"searchValue":null,"createBy":null,"createTime":"2020-10-12 18:17:23",
     * "updateBy":null,"updateTime":"2020-10-19 16:56:47","remark":null,"params":{},
     * "id":2,"serviceName":"城市地铁","serviceDesc":"城市地铁路线","serviceType":"1",
     * "imgUrl":"/profile/ditie.png","pid":1,"isRecommend":1,"link":"metro_query/index"},
     * {"searchValue":null,"createBy":null,"createTime":"2020-10-12 18:17:33","updateBy":null,"updateTime":"2020-10-19 16:56:47","remark":null,"params":{},"id":3,"serviceName":"智慧巴士","serviceDesc":"智慧巴士站点","serviceType":"1","imgUrl":"/profile/bus.png","pid":1,"isRecommend":1,"link":"bus_query/custom_shuttle"},{"searchValue":null,"createBy":null,"createTime":"2020-10-12 18:17:58","updateBy":null,"updateTime":"2020-10-19 16:56:47","remark":null,"params":{},"id":5,"serviceName":"门诊预约","serviceDesc":"快捷方便不要出门也能门诊预约","serviceType":"1","imgUrl":"/profile/menzheng.png","pid":1,"isRecommend":1,"link":"outpatient/hospitalList"},{"searchValue":null,"createBy":null,"createTime":"2020-10-12 18:18:21","updateBy":null,"updateTime":"2020-10-19 16:56:47","remark":null,"params":{},"id":7,"serviceName":"生活缴费","serviceDesc":"不要出门也能缴费","serviceType":"2","imgUrl":"/profile/live.png","pid":1,"isRecommend":1,"link":"living_expenses/index"},{"searchValue":null,"createBy":null,"createTime":"2020-10-12 18:18:39","updateBy":null,"updateTime":"2020-10-19 16:56:47","remark":null,"params":{},"id":9,"serviceName":"违章查询","serviceDesc":"查询车辆违章","serviceType":"3","imgUrl":"/profile/weizhang.png","pid":1,"isRecommend":1,"link":"traffic/index"},{"searchValue":null,"createBy":null,"createTime":"2020-10-23 16:17:56","updateBy":null,"updateTime":"2020-10-23 16:17:58","remark":null,"params":{},"id":17,"serviceName":"停车场","serviceDesc":"查询停车场","serviceType":"3","imgUrl":"/profile/pack.png","pid":1,"isRecommend":1,"link":"park/index"}]
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
    private List<RowsDTO> rows;

    public static class RowsDTO {
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
        private ParamsDTO params;
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

        public RowsDTO(Integer id,String serviceName,String imgUrl){
            this.id = id;
            this.serviceName = serviceName;
            this.imgUrl = imgUrl;
        }

        public List<RowsDTO> iconList(){
            List<RowsDTO>list = new ArrayList<>();
            list.add(new RowsDTO(2,"城市地铁","/profile/ditie.png"));
            list.add(new RowsDTO(3,"智慧巴士","/profile/bus.png"));
            list.add(new RowsDTO(5,"门诊预约","/profile/menzheng.png"));
            list.add(new RowsDTO(7,"生活缴费","/profile/live.png"));
            list.add(new RowsDTO(9,"违章查询","/profile/weizhang.png"));
            list.add(new RowsDTO(17,"停车场","/profile/pack.png"));

            return list;
        }
        public static class ParamsDTO {
        }
    }
}
