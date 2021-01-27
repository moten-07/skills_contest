package com.moten.DemoA.func;

import com.google.gson.annotations.SerializedName;

import java.util.List;
public class TPIJFID {
    // to personal information Json From ID
    // 从ID获取的个人信息
    /**
     * msg : 操作成功
     * code : 200
     * roleIds : [1]
     * data : {"searchValue":null,"createBy":"admin","createTime":"2018-03-16 11:33:00","updateBy":null,"updateTime":null,"remark":"管理员","params":{},"userId":1,"deptId":103,"userName":"admin","oldPwd":null,"nickName":"宋哥","email":"songge@163.com","phonenumber":"15888888888","sex":"0","avatar":"/profile/2020/10/26/27e7fd58-0972-4dbf-941c-c16a341558c7.png","salt":null,"status":"0","delFlag":"0","loginIp":"127.0.0.1","loginDate":"2018-03-16T11:33:00.000+0800","dept":{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"deptId":103,"parentId":102,"ancestors":null,"deptName":"研发部门","orderNum":"1","leader":"张三","phone":null,"email":null,"status":"0","delFlag":null,"parentName":null,"children":[]},"roles":[{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"roleId":1,"roleName":"超级管理员","roleKey":"admin","roleSort":"1","dataScope":"1","status":"0","delFlag":null,"flag":false,"menuIds":null,"deptIds":null,"admin":true}],"roleIds":null,"postIds":null,"idCard":"211224199506053265","file":null,"admin":true}
     * postIds : [1]
     * roles : [{"searchValue":null,"createBy":null,"createTime":"2018-03-16 11:33:00","updateBy":null,"updateTime":null,"remark":"超级管理员","params":{},"roleId":1,"roleName":"超级管理员","roleKey":"admin","roleSort":"1","dataScope":"1","status":"0","delFlag":"0","flag":false,"menuIds":null,"deptIds":null,"admin":true},{"searchValue":null,"createBy":null,"createTime":"2018-03-16 11:33:00","updateBy":null,"updateTime":null,"remark":"普通角色","params":{},"roleId":2,"roleName":"普通角色","roleKey":"common","roleSort":"2","dataScope":"1","status":"0","delFlag":"0","flag":false,"menuIds":null,"deptIds":null,"admin":false},{"searchValue":null,"createBy":null,"createTime":"2020-10-26 10:09:04","updateBy":null,"updateTime":null,"remark":"测试","params":{},"roleId":3,"roleName":"测试","roleKey":"commons","roleSort":"4","dataScope":"1","status":"0","delFlag":"0","flag":false,"menuIds":null,"deptIds":null,"admin":false}]
     * posts : [{"searchValue":null,"createBy":"admin","createTime":"2018-03-16 11:33:00","updateBy":null,"updateTime":null,"remark":"","params":{},"postId":1,"postCode":"ceo","postName":"董事长","postSort":"1","status":"0","flag":false},{"searchValue":null,"createBy":"admin","createTime":"2018-03-16 11:33:00","updateBy":null,"updateTime":null,"remark":"111","params":{},"postId":2,"postCode":"se","postName":"项目经理","postSort":"10","status":"0","flag":false},{"searchValue":null,"createBy":"admin","createTime":"2018-03-16 11:33:00","updateBy":null,"updateTime":null,"remark":"","params":{},"postId":3,"postCode":"hr","postName":"人力资源","postSort":"3","status":"0","flag":false},{"searchValue":null,"createBy":"admin","createTime":"2018-03-16 11:33:00","updateBy":null,"updateTime":null,"remark":"","params":{},"postId":4,"postCode":"user","postName":"普通员工","postSort":"4","status":"0","flag":false}]
     */

    @SerializedName("msg")
    public String msg;
    @SerializedName("code")
    public Integer code;
    @SerializedName("data")
    public Data data;
    @SerializedName("roleIds")
    public List<Integer> roleIds;
    @SerializedName("postIds")
    public List<Integer> postIds;
    @SerializedName("roles")
    public List<Roles> roles;
    @SerializedName("posts")
    public List<Posts> posts;

    public static class Data {
        /**
         * searchValue : null
         * createBy : admin
         * createTime : 2018-03-16 11:33:00
         * updateBy : null
         * updateTime : null
         * ->remark : 管理员
         * params : {}
         * ->userId : 1
         * deptId : 103
         * ->userName : admin
         * oldPwd : null
         * ->nickName : 宋哥
         * email : songge@163.com
         * ->phonenumber : 15888888888
         * ->sex : 0
         * ->avatar : /profile/2020/10/26/27e7fd58-0972-4dbf-941c-c16a341558c7.png
         * salt : null
         * status : 0
         * delFlag : 0
         * loginIp : 127.0.0.1
         * loginDate : 2018-03-16T11:33:00.000+0800
         * dept : {"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"deptId":103,"parentId":102,"ancestors":null,"deptName":"研发部门","orderNum":"1","leader":"张三","phone":null,"email":null,"status":"0","delFlag":null,"parentName":null,"children":[]}
         * roles : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"roleId":1,"roleName":"超级管理员","roleKey":"admin","roleSort":"1","dataScope":"1","status":"0","delFlag":null,"flag":false,"menuIds":null,"deptIds":null,"admin":true}]
         * roleIds : null
         * postIds : null
         * ->idCard : 211224199506053265
         * file : null
         * admin : true
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
        public String remark;
        @SerializedName("params")
        public Params params;
        @SerializedName("userId")
        public Integer userId;
        @SerializedName("deptId")
        public Integer deptId;
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
        public String loginDate;
        @SerializedName("dept")
        public Dept dept;
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
        public List<Roles> roles;

        public static class Params {
        }


        public static class Dept {
            /**
             * searchValue : null
             * createBy : null
             * createTime : null
             * updateBy : null
             * updateTime : null
             * remark : null
             * params : {}
             * deptId : 103
             * parentId : 102
             * ancestors : null
             * deptName : 研发部门
             * orderNum : 1
             * leader : 张三
             * phone : null
             * email : null
             * status : 0
             * delFlag : null
             * parentName : null
             * children : []
             */

            @SerializedName("searchValue")
            public Object searchValue;
            @SerializedName("createBy")
            public Object createBy;
            @SerializedName("createTime")
            public Object createTime;
            @SerializedName("updateBy")
            public Object updateBy;
            @SerializedName("updateTime")
            public Object updateTime;
            @SerializedName("remark")
            public Object remark;
            @SerializedName("params")
            public Params params;
            @SerializedName("deptId")
            public Integer deptId;
            @SerializedName("parentId")
            public Integer parentId;
            @SerializedName("ancestors")
            public Object ancestors;
            @SerializedName("deptName")
            public String deptName;
            @SerializedName("orderNum")
            public String orderNum;
            @SerializedName("leader")
            public String leader;
            @SerializedName("phone")
            public Object phone;
            @SerializedName("email")
            public Object email;
            @SerializedName("status")
            public String status;
            @SerializedName("delFlag")
            public Object delFlag;
            @SerializedName("parentName")
            public Object parentName;
            @SerializedName("children")
            public List<?> children;

            public static class Params {
            }
        }

        public static class Roles {
            /**
             * searchValue : null
             * createBy : null
             * createTime : null
             * updateBy : null
             * updateTime : null
             * remark : null
             * params : {}
             * roleId : 1
             * roleName : 超级管理员
             * roleKey : admin
             * roleSort : 1
             * dataScope : 1
             * status : 0
             * delFlag : null
             * flag : false
             * menuIds : null
             * deptIds : null
             * admin : true
             */

            @SerializedName("searchValue")
            public Object searchValue;
            @SerializedName("createBy")
            public Object createBy;
            @SerializedName("createTime")
            public Object createTime;
            @SerializedName("updateBy")
            public Object updateBy;
            @SerializedName("updateTime")
            public Object updateTime;
            @SerializedName("remark")
            public Object remark;
            @SerializedName("params")
            public Params params;
            @SerializedName("roleId")
            public Integer roleId;
            @SerializedName("roleName")
            public String roleName;
            @SerializedName("roleKey")
            public String roleKey;
            @SerializedName("roleSort")
            public String roleSort;
            @SerializedName("dataScope")
            public String dataScope;
            @SerializedName("status")
            public String status;
            @SerializedName("delFlag")
            public Object delFlag;
            @SerializedName("flag")
            public Boolean flag;
            @SerializedName("menuIds")
            public Object menuIds;
            @SerializedName("deptIds")
            public Object deptIds;
            @SerializedName("admin")
            public Boolean admin;

            public static class Params {
            }
        }
    }

    public static class Roles {
        /**
         * searchValue : null
         * createBy : null
         * createTime : 2018-03-16 11:33:00
         * updateBy : null
         * updateTime : null
         * remark : 超级管理员
         * params : {}
         * roleId : 1
         * roleName : 超级管理员
         * roleKey : admin
         * roleSort : 1
         * dataScope : 1
         * status : 0
         * delFlag : 0
         * flag : false
         * menuIds : null
         * deptIds : null
         * admin : true
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
        public String remark;
        @SerializedName("params")
        public Params params;
        @SerializedName("roleId")
        public Integer roleId;
        @SerializedName("roleName")
        public String roleName;
        @SerializedName("roleKey")
        public String roleKey;
        @SerializedName("roleSort")
        public String roleSort;
        @SerializedName("dataScope")
        public String dataScope;
        @SerializedName("status")
        public String status;
        @SerializedName("delFlag")
        public String delFlag;
        @SerializedName("flag")
        public Boolean flag;
        @SerializedName("menuIds")
        public Object menuIds;
        @SerializedName("deptIds")
        public Object deptIds;
        @SerializedName("admin")
        public Boolean admin;

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
        public String remark;
        @SerializedName("params")
        public Params params;
        @SerializedName("postId")
        public Integer postId;
        @SerializedName("postCode")
        public String postCode;
        @SerializedName("postName")
        public String postName;
        @SerializedName("postSort")
        public String postSort;
        @SerializedName("status")
        public String status;
        @SerializedName("flag")
        public Boolean flag;

        public static class Params {
        }
    }
}
