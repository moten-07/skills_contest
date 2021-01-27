package com.moten.DemoA.func;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TPIJFT {
    // to personal information Json From Token
    // 从Token获取的个人信息

    /**
     * msg : 操作成功
     * code : 200
     * permissions : []
     * roles : []
     * user : {"searchValue":null,"createBy":"","createTime":"2021-01-27 09:50:58","updateBy":null,"updateTime":null,"remark":null,"params":{},"userId":676,"deptId":null,"userName":"可以是中文吗","oldPwd":null,"nickName":"中文账号","email":"","phonenumber":"49235781600","sex":"1","avatar":"","salt":null,"status":"0","delFlag":"0","loginIp":"","loginDate":null,"dept":null,"roles":[],"roleIds":null,"postIds":null,"idCard":null,"file":null,"admin":false}
     */

    @SerializedName("msg")
    public String msg;
    @SerializedName("code")
    public Integer code;
    @SerializedName("user")
    public User user;
    @SerializedName("permissions")
    public List<?> permissions;
    @SerializedName("roles")
    public List<?> roles;

    public static class User {
        @Override
        public String toString() {
            return "User{" +
                    "searchValue=" + searchValue +
                    ", createBy='" + createBy + '\'' +
                    ", createTime='" + createTime + '\'' +
                    ", updateBy=" + updateBy +
                    ", updateTime=" + updateTime +
                    ", remark=" + remark +
                    ", params=" + params +
                    ", userId=" + userId +
                    ", deptId=" + deptId +
                    ", userName='" + userName + '\'' +
                    ", oldPwd=" + oldPwd +
                    ", nickName='" + nickName + '\'' +
                    ", email='" + email + '\'' +
                    ", phonenumber='" + phonenumber + '\'' +
                    ", sex='" + sex + '\'' +
                    ", avatar='" + avatar + '\'' +
                    ", salt=" + salt +
                    ", status='" + status + '\'' +
                    ", delFlag='" + delFlag + '\'' +
                    ", loginIp='" + loginIp + '\'' +
                    ", loginDate=" + loginDate +
                    ", dept=" + dept +
                    ", roleIds=" + roleIds +
                    ", postIds=" + postIds +
                    ", idCard=" + idCard +
                    ", file=" + file +
                    ", admin=" + admin +
                    ", roles=" + roles +
                    '}';
        }

        /**
         * searchValue : null
         * createBy :
         * createTime : 2021-01-27 09:50:58
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * userId : 676
         * deptId : null
         * ->userName : 可以是中文吗
         * oldPwd : null
         * ->nickName : 中文账号
         * email :
         * ->phonenumber : 49235781600
         * sex : 1
         * ->avatar :
         * salt : null
         * status : 0
         * delFlag : 0
         * loginIp :
         * loginDate : null
         * dept : null
         * roles : []
         * roleIds : null
         * postIds : null
         * ->idCard : null
         * file : null
         * admin : false
         */

        @SerializedName("searchValue")
        public Object searchValue;
        @SerializedName("createBy")
        public String createBy;
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
        @SerializedName("deptId")
        public Object deptId;
        @SerializedName("userName")
        public String userName;
        @SerializedName("oldPwd")
        public Object oldPwd;
        @SerializedName("nickName")
        public String nickName;
        @SerializedName("email")
        public String email;
        @SerializedName("phonenumber")
        public String phonenumber;
        @SerializedName("sex")
        public String sex;
        @SerializedName("avatar")
        public String avatar;
        @SerializedName("salt")
        public Object salt;
        @SerializedName("status")
        public String status;
        @SerializedName("delFlag")
        public String delFlag;
        @SerializedName("loginIp")
        public String loginIp;
        @SerializedName("loginDate")
        public Object loginDate;
        @SerializedName("dept")
        public Object dept;
        @SerializedName("roleIds")
        public Object roleIds;
        @SerializedName("postIds")
        public Object postIds;
        @SerializedName("idCard")
        public String idCard;
        @SerializedName("file")
        public Object file;
        @SerializedName("admin")
        public Boolean admin;
        @SerializedName("roles")
        public List<?> roles;

        public static class Params {
        }
    }

    @Override
    public String toString() {
        return "TPIJFT{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", user=" + user +
                ", permissions=" + permissions +
                ", roles=" + roles +
                '}';
    }
}
