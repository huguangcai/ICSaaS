package com.ysxsoft.icsaas.common_base.utils;

/**
 * Create By 胡
 * on 2020/3/3 0003
 */
public class StringUtils {
    /**
     * 获取字符串的前三位
     *
     * @param str
     * @param i   前几位
     * @return
     */
    public static String subBefore3Num(String str, int i) {
        return str.substring(0, i);
    }

    /**
     * 获取字符串的后四位数
     *
     * @param str 字符串
     * @param i   后几位
     * @return
     */
    public static String subAfter4Num(String str, int i) {
        return str.substring(str.length() - i, str.length());
    }
}
