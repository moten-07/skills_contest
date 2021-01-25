package com.moten.DemoA.func;

import androidx.work.Data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TNTJ {
    // to News Type json
    /**
     * msg : 操作成功
     * code : 200
     * data : [{"searchValue":null,"createBy":"admin","createTime":"2020-10-12 15:43:58","updateBy":null,"updateTime":null,"remark":null,"params":{},"dictCode":36,"dictSort":0,"dictLabel":"时政","dictValue":"1","dictType":"press_category","cssClass":null,"listClass":null,"isDefault":"N","status":"0","default":false},{"searchValue":null,"createBy":"admin","createTime":"2020-10-12 15:44:14","updateBy":null,"updateTime":null,"remark":null,"params":{},"dictCode":37,"dictSort":1,"dictLabel":"基层","dictValue":"2","dictType":"press_category","cssClass":null,"listClass":null,"isDefault":"N","status":"0","default":false},{"searchValue":null,"createBy":"admin","createTime":"2020-10-12 15:44:23","updateBy":null,"updateTime":null,"remark":null,"params":{},"dictCode":38,"dictSort":2,"dictLabel":"广播","dictValue":"3","dictType":"press_category","cssClass":null,"listClass":null,"isDefault":"N","status":"0","default":false},{"searchValue":null,"createBy":"admin","createTime":"2020-10-12 15:48:33","updateBy":null,"updateTime":null,"remark":null,"params":{},"dictCode":39,"dictSort":3,"dictLabel":"电视","dictValue":"4","dictType":"press_category","cssClass":null,"listClass":null,"isDefault":"N","status":"0","default":false},{"searchValue":null,"createBy":"admin","createTime":"2020-10-12 15:48:49","updateBy":null,"updateTime":null,"remark":null,"params":{},"dictCode":40,"dictSort":4,"dictLabel":"旅游","dictValue":"5","dictType":"press_category","cssClass":null,"listClass":null,"isDefault":"N","status":"0","default":false},{"searchValue":null,"createBy":"admin","createTime":"2020-10-12 15:49:06","updateBy":null,"updateTime":null,"remark":null,"params":{},"dictCode":41,"dictSort":5,"dictLabel":"视频","dictValue":"6","dictType":"press_category","cssClass":null,"listClass":null,"isDefault":"N","status":"0","default":false}]
     */

    @SerializedName("msg")
    private String msg;
    @SerializedName("code")
    private Integer code;
    @SerializedName("data")
    private List<Data> data;

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

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public static class Data {
        /**
         * searchValue : null
         * createBy : admin
         * createTime : 2020-10-12 15:43:58
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * dictCode : 36
         * dictSort : 0
         * dictLabel : 时政
         * dictValue : 1
         * dictType : press_category
         * cssClass : null
         * listClass : null
         * isDefault : N
         * status : 0
         * default : false
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
        @SerializedName("dictCode")
        private Integer dictCode;
        @SerializedName("dictSort")
        private Integer dictSort;
        @SerializedName("dictLabel")
        private String dictLabel;
        @SerializedName("dictValue")
        private String dictValue;
        @SerializedName("dictType")
        private String dictType;
        @SerializedName("cssClass")
        private Object cssClass;
        @SerializedName("listClass")
        private Object listClass;
        @SerializedName("isDefault")
        private String isDefault;
        @SerializedName("status")
        private String status;
        @SerializedName("default")
        private Boolean defaultX;

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

        public Integer getDictCode() {
            return dictCode;
        }

        public void setDictCode(Integer dictCode) {
            this.dictCode = dictCode;
        }

        public Integer getDictSort() {
            return dictSort;
        }

        public void setDictSort(Integer dictSort) {
            this.dictSort = dictSort;
        }

        public String getDictLabel() {
            return dictLabel;
        }

        public void setDictLabel(String dictLabel) {
            this.dictLabel = dictLabel;
        }

        public String getDictValue() {
            return dictValue;
        }

        public void setDictValue(String dictValue) {
            this.dictValue = dictValue;
        }

        public String getDictType() {
            return dictType;
        }

        public void setDictType(String dictType) {
            this.dictType = dictType;
        }

        public Object getCssClass() {
            return cssClass;
        }

        public void setCssClass(Object cssClass) {
            this.cssClass = cssClass;
        }

        public Object getListClass() {
            return listClass;
        }

        public void setListClass(Object listClass) {
            this.listClass = listClass;
        }

        public String getIsDefault() {
            return isDefault;
        }

        public void setIsDefault(String isDefault) {
            this.isDefault = isDefault;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Boolean getDefaultX() {
            return defaultX;
        }

        public void setDefaultX(Boolean defaultX) {
            this.defaultX = defaultX;
        }

        public static class Params {
        }

        @Override
        public String toString() {
            return "Data{" +
                    "searchValue=" + searchValue +
                    ", createBy='" + createBy + '\'' +
                    ", createTime='" + createTime + '\'' +
                    ", updateBy=" + updateBy +
                    ", updateTime=" + updateTime +
                    ", remark=" + remark +
                    ", params=" + params +
                    ", dictCode=" + dictCode +
                    ", dictSort=" + dictSort +
                    ", dictLabel='" + dictLabel + '\'' +
                    ", dictValue='" + dictValue + '\'' +
                    ", dictType='" + dictType + '\'' +
                    ", cssClass=" + cssClass +
                    ", listClass=" + listClass +
                    ", isDefault='" + isDefault + '\'' +
                    ", status='" + status + '\'' +
                    ", defaultX=" + defaultX +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "TNTJ{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
