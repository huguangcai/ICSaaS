package com.ysxsoft.icsaas.common_base.utils;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create By 胡
 * on 2020/3/3 0003
 */
public class CheckUtils {


    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        return false;
    }

    /**
     * 检测手机号的格式是否正确
     *
     * @param phonenumber
     * @return
     */
    public static boolean checkPhoneNum(String phonenumber) {
        String regExp = "^13[0-9]{9}$|^14[0-9]{9}$|^15[0-9]{9}$|^18[0-9]{9}$|16[0-9]{9}$|^17[0-9]{9}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(phonenumber);
        return m.find();
    }

    /**
     * 检测身份证号格式是否正确
     *
     * @param idNum
     * @return
     */
    public static boolean checkIdNum(String idNum) {
        String regExp = "^(\\d{15}$|^\\d{18}$|^\\d{17}(\\d|X|x))$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(idNum);
        return m.find();
    }

    /**
     * 核对车牌号
     *
     * @param carNBum
     * @return
     */
    public static boolean checkCarNum(String carNBum) {
        String regExp = "[\u4e00-\u9fa5]{1}[a-zA-Z]{1}[a-zA-Z_0-9]{5}";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(carNBum);
        return m.find();
    }

}
