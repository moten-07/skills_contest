package com.moten.DemoA.func;

import com.google.gson.annotations.SerializedName;

public class TALJ {
    // to about Login Json
    // 登录信息相关
    /**
     * msg : 操作成功
     * code : 200
     * token : eyJhbGciOiJIUzUxMiJ9.eyJsb2dpbl91c2VyX2tleSI6IjM5NjU1MTlmLTBmYzEtNDU0OC1iNmExLWJjY2IzNmQ3YjIxOCJ9.GZEl7LjsW3sxKfGBDcPsCstznG-hev8--MJwE1jxue2O5jL9lOBl6zqOwhgCTzuqFcnk2OCczyFzlyfo0QswTA
     */
    @SerializedName("msg")
    private String msg;
    @SerializedName("code")
    private Integer code;
    @SerializedName("token")
    private String token;

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
