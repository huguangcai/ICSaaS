package com.ysxsoft.icsaas.modle;

/**
 * Create By 胡
 * on 2020/3/11 0011
 */
public class LoginOutBean {

    /**
     * code : 0
     * info : {}
     * message : success
     */

    private String code;
    private InfoBean info;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class InfoBean {
    }
}
