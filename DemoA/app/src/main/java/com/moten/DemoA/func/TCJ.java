package com.moten.DemoA.func;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TCJ {
    // to comment json
    /**
     * total : 5
     * rows : [{"searchValue":null,"createBy":null,"createTime":"2020-10-12 17:28:42","updateBy":null,"updateTime":null,"remark":null,"params":{},"userId":2,"pressId":11,"content":"近期，受冷空气频繁影响，我国北方地区明显降温，本周局地降温幅度可达8～10℃以上。北方多地陆续启动供暖工作暖人心。","nickName":"吴霄","userName":"zhangsan","avatar":"/profile/2020/12/28/8edfb0e3-9d96-4a56-9f6b-4ac8b11ae237.png"},{"searchValue":null,"createBy":null,"createTime":"2020-12-29 17:52:18","updateBy":null,"updateTime":null,"remark":null,"params":{},"userId":184,"pressId":11,"content":"hhhhhhh","nickName":"SmartCity","userName":"smartcity","avatar":"/profile/2021/01/13/2c126bec-7928-4eba-9c42-679e5d81944a.gif"},{"searchValue":null,"createBy":null,"createTime":"2020-12-29 17:53:01","updateBy":null,"updateTime":null,"remark":null,"params":{},"userId":184,"pressId":11,"content":"老子评论系统做成啦！！！","nickName":"SmartCity","userName":"smartcity","avatar":"/profile/2021/01/13/2c126bec-7928-4eba-9c42-679e5d81944a.gif"},{"searchValue":null,"createBy":null,"createTime":"2021-01-20 14:31:02","updateBy":null,"updateTime":null,"remark":null,"params":{},"userId":629,"pressId":11,"content":"好啊","nickName":"噼里啪啦","userName":"drake","avatar":"/profile/2021/01/28/08f7e9b8-fb0b-4728-96ea-ed4a1754bf92.gif"},{"searchValue":null,"createBy":null,"createTime":"2021-01-20 16:23:18","updateBy":null,"updateTime":null,"remark":null,"params":{},"userId":629,"pressId":11,"content":"@SmartCity 真厉害","nickName":"噼里啪啦","userName":"drake","avatar":"/profile/2021/01/28/08f7e9b8-fb0b-4728-96ea-ed4a1754bf92.gif"}]
     * code : 200
     * msg : 查询成功
     */

    @SerializedName("total")
    public Integer total;
    @SerializedName("code")
    public Integer code;
    @SerializedName("msg")
    public String msg;
    @SerializedName("rows")
    public List<Rows> rows;

    public static class Rows {
        /**
         * searchValue : null
         * createBy : null
         * ->createTime : 2020-10-12 17:28:42
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * userId : 2
         * pressId : 11
         * ->content : 近期，受冷空气频繁影响，我国北方地区明显降温，本周局地降温幅度可达8～10℃以上。北方多地陆续启动供暖工作暖人心。
         * ->nickName : 吴霄
         * userName : zhangsan
         * ->avatar : /profile/2020/12/28/8edfb0e3-9d96-4a56-9f6b-4ac8b11ae237.png
         */

        @SerializedName("searchValue")
        public Object searchValue;
        @SerializedName("createBy")
        public Object createBy;
        @SerializedName("createTime")
        public String createTime;
        @SerializedName("updateBy")
        public Object updateBy;
        @SerializedName("updateTime")
        public Object updateTime;
        @SerializedName("remark")
        public Object remark;
        @SerializedName("params")
        public Params params;
        @SerializedName("userId")
        public Integer userId;
        @SerializedName("pressId")
        public Integer pressId;
        @SerializedName("content")
        public String content;
        @SerializedName("nickName")
        public String nickName;
        @SerializedName("userName")
        public String userName;
        @SerializedName("avatar")
        public String avatar;

        public static class Params {
        }

        @Override
        public String toString() {
            return "Rows{" +
                    "searchValue=" + searchValue +
                    ", createBy=" + createBy +
                    ", createTime='" + createTime + '\'' +
                    ", updateBy=" + updateBy +
                    ", updateTime=" + updateTime +
                    ", remark=" + remark +
                    ", params=" + params +
                    ", userId=" + userId +
                    ", pressId=" + pressId +
                    ", content='" + content + '\'' +
                    ", nickName='" + nickName + '\'' +
                    ", userName='" + userName + '\'' +
                    ", avatar='" + avatar + '\'' +
                    '}';
        }
    }
}
