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
     * user : {"searchValue":null,"createBy":"","createTime":"2021-01-26 07:16:50","updateBy":null,"updateTime":null,"remark":null,"params":{},"userId":668,"deptId":null,"userName":"nameIsPi","oldPwd":null,"nickName":"pi","email":"","phonenumber":"31415926535","sex":"1","avatar":"","salt":null,"status":"0","delFlag":"0","loginIp":"","loginDate":null,"dept":null,"roles":[],"roleIds":null,"postIds":null,"idCard":null,"file":null,"admin":false}
     */

    @SerializedName("msg")
    private String msg;
    @SerializedName("code")
    private Integer code;
    @SerializedName("user")
    private User user;
    @SerializedName("permissions")
    private List<?> permissions;
    @SerializedName("roles")
    private List<?> roles;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<?> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<?> permissions) {
        this.permissions = permissions;
    }

    public List<?> getRoles() {
        return roles;
    }

    public void setRoles(List<?> roles) {
        this.roles = roles;
    }

    public static class User {
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
         * nickName : pi                        ***
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
         * idCard : null
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

        public Object getSearchValue() {
            return searchValue;
        }

        public void setSearchValue(Object searchValue) {
            this.searchValue = searchValue;
        }

        public String getCreateBy() {
            return createBy;
        }

        public void setCreateBy(String createBy) {
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

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
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

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public Object getDeptId() {
            return deptId;
        }

        public void setDeptId(Object deptId) {
            this.deptId = deptId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Object getOldPwd() {
            return oldPwd;
        }

        public void setOldPwd(Object oldPwd) {
            this.oldPwd = oldPwd;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhonenumber() {
            return phonenumber;
        }

        public void setPhonenumber(String phonenumber) {
            this.phonenumber = phonenumber;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public Object getSalt() {
            return salt;
        }

        public void setSalt(Object salt) {
            this.salt = salt;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDelFlag() {
            return delFlag;
        }

        public void setDelFlag(String delFlag) {
            this.delFlag = delFlag;
        }

        public String getLoginIp() {
            return loginIp;
        }

        public void setLoginIp(String loginIp) {
            this.loginIp = loginIp;
        }

        public Object getLoginDate() {
            return loginDate;
        }

        public void setLoginDate(Object loginDate) {
            this.loginDate = loginDate;
        }

        public Object getDept() {
            return dept;
        }

        public void setDept(Object dept) {
            this.dept = dept;
        }

        public Object getRoleIds() {
            return roleIds;
        }

        public void setRoleIds(Object roleIds) {
            this.roleIds = roleIds;
        }

        public Object getPostIds() {
            return postIds;
        }

        public void setPostIds(Object postIds) {
            this.postIds = postIds;
        }

        public Object getIdCard() {
            return idCard;
        }

        public void setIdCard(Object idCard) {
            this.idCard = idCard;
        }

        public Object getFile() {
            return file;
        }

        public void setFile(Object file) {
            this.file = file;
        }

        public Boolean getAdmin() {
            return admin;
        }

        public void setAdmin(Boolean admin) {
            this.admin = admin;
        }

        public List<?> getRoles() {
            return roles;
        }

        public void setRoles(List<?> roles) {
            this.roles = roles;
        }
    }
}
