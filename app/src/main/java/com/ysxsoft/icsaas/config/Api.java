package com.ysxsoft.icsaas.config;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Create By 胡
 * on 2020/3/11 0011
 */
public class Api {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    public static RequestBody BodyJson(String data){
        return RequestBody.create(JSON, data);
    }
}
