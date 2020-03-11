package com.ysxsoft.icsaas.modle;

/**
 * Create By 胡
 * on 2020/3/11 0011
 */
public class LoginBean {
    /**
     * code : 0
     * info : {"companyId":"string","token":"string","userId":"string"}
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
        /**
         * companyId : string
         * token : string
         * userId : string
         */

        private String companyId;
        private String token;
        private String userId;

        public String getCompanyId() {
            return companyId;
        }

        public void setCompanyId(String companyId) {
            this.companyId = companyId;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}
