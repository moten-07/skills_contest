package com.moten.DemoA.func;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TPIJFID {
    // to personal information Json From ID
    // 从ID获取的个人信息
    /**
     * msg : 操作成功    ***
     * code : 200       ***
     * roleIds : []
     * data : {"searchValue":null,"createBy":"","createTime":"2021-01-26 07:16:50","updateBy":null,"updateTime":null,"remark":null,"params":{},"userId":668,"deptId":null,"userName":"nameIsPi","oldPwd":null,"nickName":"pi","email":"","phonenumber":"31415926535","sex":"1","avatar":"","salt":null,"status":"0","delFlag":"0","loginIp":"","loginDate":null,"dept":null,"roles":[],"roleIds":null,"postIds":null,"idCard":null,"file":null,"admin":false}
     * postIds : []
     * roles : [{"searchValue":null,"createBy":null,"createTime":"2018-03-16 11:33:00","updateBy":null,"updateTime":null,"remark":"普通角色","params":{},"roleId":2,"roleName":"普通角色","roleKey":"common","roleSort":"2","dataScope":"1","status":"0","delFlag":"0","flag":false,"menuIds":null,"deptIds":null,"admin":false},{"searchValue":null,"createBy":null,"createTime":"2020-10-26 10:09:04","updateBy":null,"updateTime":null,"remark":"测试","params":{},"roleId":3,"roleName":"测试","roleKey":"commons","roleSort":"4","dataScope":"1","status":"0","delFlag":"0","flag":false,"menuIds":null,"deptIds":null,"admin":false}]
     * posts : [{"searchValue":null,"createBy":"admin","createTime":"2018-03-16 11:33:00","updateBy":null,"updateTime":null,"remark":"","params":{},"postId":1,"postCode":"ceo","postName":"董事长","postSort":"1","status":"0","flag":false},{"searchValue":null,"createBy":"admin","createTime":"2018-03-16 11:33:00","updateBy":null,"updateTime":null,"remark":"111","params":{},"postId":2,"postCode":"se","postName":"项目经理","postSort":"10","status":"0","flag":false},{"searchValue":null,"createBy":"admin","createTime":"2018-03-16 11:33:00","updateBy":null,"updateTime":null,"remark":"","params":{},"postId":3,"postCode":"hr","postName":"人力资源","postSort":"3","status":"0","flag":false},{"searchValue":null,"createBy":"admin","createTime":"2018-03-16 11:33:00","updateBy":null,"updateTime":null,"remark":"","params":{},"postId":4,"postCode":"user","postName":"普通员工","postSort":"4","status":"0","flag":false}]
     */

    @SerializedName("msg")
    private String msg;
    @SerializedName("code")
    private Integer code;
    @SerializedName("data")
    private Data data;
    @SerializedName("roleIds")
    private List<?> roleIds;
    @SerializedName("postIds")
    private List<?> postIds;
    @SerializedName("roles")
    private List<Roles> roles;
    @SerializedName("posts")
    private List<Posts> posts;

    public static class Data {
        /**
         * searchValue : null
         * createBy :
         * createTime : 2021-01-26 07:16:50
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * userId : 668                         ***
         * deptId : null
         * userName : nameIsPi                  ***
         * oldPwd : null
         * nickName : pi
         * email :
         * phonenumber : 31415926535            ***
         * sex : 1                              ***
         * avatar :
         * salt : null
         * status : 0
         * delFlag : 0
         * loginIp :
         * loginDate : null
         * dept : null
         * roles : []
         * roleIds : null
         * postIds : null
         * idCard : null                        ***
         * file : null
         * admin : false
         */

        @SerializedName("searchValue")
        private Object searchValue;
        @SerializedName("createBy")
        private String createBy;
        @SerializedName("createTime")
        private String createTime;
        @SerializedName("updateBy")
        private Object updateBy;
        @SerializedName("updateTime")
        private Object updateTime;
        @SerializedName("remark")
        private Object remark;
        @SerializedName("params")
        private Params params;
        @SerializedName("userId")
        private Integer userId;
        @SerializedName("deptId")
        private Object deptId;
        @SerializedName("userName")
        private String userName;
        @SerializedName("oldPwd")
        private Object oldPwd;
        @SerializedName("nickName")
        private String nickName;
        @SerializedName("email")
        private String email;
        @SerializedName("phonenumber")
        private String phonenumber;
        @SerializedName("sex")
        private String sex;
        @SerializedName("avatar")
        private String avatar;
        @SerializedName("salt")
        private Object salt;
        @SerializedName("status")
        private String status;
        @SerializedName("delFlag")
        private String delFlag;
        @SerializedName("loginIp")
        private String loginIp;
        @SerializedName("loginDate")
        private Object loginDate;
        @SerializedName("dept")
        private Object dept;
        @SerializedName("roleIds")
        private Object roleIds;
        @SerializedName("postIds")
        private Object postIds;
        @SerializedName("idCard")
        private Object idCard;
        @SerializedName("file")
        private Object file;
        @SerializedName("admin")
        private Boolean admin;
        @SerializedName("roles")
        private List<?> roles;

        public static class Params {
        }
    }

    public static class Roles {
        /**
         * searchValue : null
         * createBy : null
         * createTime : 2018-03-16 11:33:00
         * updateBy : null
         * updateTime : null
         * remark : 普通角色
         * params : {}
         * roleId : 2
         * roleName : 普通角色
         * roleKey : common
         * roleSort : 2
         * dataScope : 1
         * status : 0
         * delFlag : 0
         * flag : false
         * menuIds : null
         * deptIds : null
         * admin : false
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
        private Object updateTime;
        @SerializedName("remark")
        private String remark;
        @SerializedName("params")
        private Params params;
        @SerializedName("roleId")
        private Integer roleId;
        @SerializedName("roleName")
        private String roleName;
        @SerializedName("roleKey")
        private String roleKey;
        @SerializedName("roleSort")
        private String roleSort;
        @SerializedName("dataScope")
        private String dataScope;
        @SerializedName("status")
        private String status;
        @SerializedName("delFlag")
        private String delFlag;
        @SerializedName("flag")
        private Boolean flag;
        @SerializedName("menuIds")
        private Object menuIds;
        @SerializedName("deptIds")
        private Object deptIds;
        @SerializedName("admin")
        private Boolean admin;

        public static class Params {
        }
    }

    public static class Posts {
        /**
         * searchValue : null
         * createBy : admin
         * createTime : 2018-03-16 11:33:00
         * updateBy : null
         * updateTime : null
         * remark :
         * params : {}
         * postId : 1
         * postCode : ceo
         * postName : 董事长
         * postSort : 1
         * status : 0
         * flag : false
         */

        @SerializedName("searchValue")
        private Object searchValue;
        @SerializedName("createBy")
        private String createBy;
        @SerializedName("createTime")
        private String createTime;
        @SerializedName("updateBy")
        private Object updateBy;
        @SerializedName("updateTime")
        private Object updateTime;
        @SerializedName("remark")
        private String remark;
        @SerializedName("params")
        private Params params;
        @SerializedName("postId")
        private Integer postId;
        @SerializedName("postCode")
        private String postCode;
        @SerializedName("postName")
        private String postName;
        @SerializedName("postSort")
        private String postSort;
        @SerializedName("status")
        private String status;
        @SerializedName("flag")
        private Boolean flag;


        public static class Params {
        }
    }
}
