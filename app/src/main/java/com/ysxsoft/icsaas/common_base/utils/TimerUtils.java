package com.ysxsoft.icsaas.common_base.utils;

import android.annotation.SuppressLint;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class TimerUtils {

    static SimpleDateFormat format;

    /**
     * 日期格式：yyyy-MM-dd HH:mm:ss
     **/
    public static final String DF_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期格式：yyyy-MM-dd HH:mm
     **/
    public static final String DF_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

    /**
     * 日期格式：yyyy-MM-dd
     **/
    public static final String DF_YYYY_MM_DD = "yyyy-MM-dd";
    /**
     * 日期格式：MM-dd
     **/
    public static final String DF_MM_DD = "MM-dd";

    /**
     * 日期格式：yyyy-MM-dd
     **/
    public static final String DF_MM_DD_HH_MM = "MM-dd HH:mm";

    /**
     * 日期格式：HH:mm:ss
     **/
    public static final String DF_HH_MM_SS = "HH:mm:ss";

    /**
     * 日期格式：HH:mm
     **/
    public static final String DF_HH_MM = "HH:mm";

    private static final String[] FORMATS = {DF_YYYY_MM_DD_HH_MM_SS, DF_YYYY_MM_DD_HH_MM, DF_YYYY_MM_DD, DF_MM_DD_HH_MM, DF_HH_MM_SS, DF_HH_MM};

    private final static long minute = 60 * 1000;// 1分钟
    private final static long hour = 60 * minute;// 1小时
    private final static long day = 24 * hour;// 1天
    private final static long week = 7 * day;// 1周
    private final static long month = 31 * day;// 月
    private final static long year = 12 * month;// 年

    public static int getDayforYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_YEAR);
    }

    public static int getYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

    public static int getDayforMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static int getDayforMonth(int month) {

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int day;
        switch (month) {
            case 1:
                day = 0;
                break;
            case 2:
                day = 31;
                break;
            case 3:
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    day = 60;
                } else {
                    day = 59;
                }
                break;
            case 4:
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    day = 91;
                } else {
                    day = 90;
                }
                break;
            case 5:
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    day = 121;
                } else {
                    day = 120;
                }
                break;
            case 6:
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    day = 152;
                } else {
                    day = 151;
                }
                break;
            case 7:
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    day = 182;
                } else {
                    day = 181;
                }
                break;
            case 8:
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    day = 213;
                } else {
                    day = 212;
                }
                break;
            case 9:
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    day = 244;
                } else {
                    day = 243;
                }
                break;
            case 10:
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    day = 274;
                } else {
                    day = 273;
                }
                break;
            case 11:
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    day = 305;
                } else {
                    day = 304;
                }
                break;
            case 12:
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    day = 336;
                } else {
                    day = 335;
                }
                break;
            default:
                day = 0;
                break;
        }
        return day;
    }

    /**
     * 根据时间戳获取当前年龄
     *
     * @param time
     * @return
     */
    public static String formatFriendlyBirthday(long time) {
        Date date = currentTimeToDateDrop(time);
        if (date == null) {
            return null;
        }
        long diff = new Date().getTime() - date.getTime();
        long r = 0;
        if (diff > year) {
            r = (diff / year);
            return String.valueOf(r + 1) + "岁";
        }
        return "0岁";
    }

    /**
     * 倒计时
     */
    public static String countDown(long time) {
        long day = time / (3600 * 24);
        long second = time % (3600 * 24);
        long hour = second / 3600;
        second = second % 3600;
        long minute = second / 60;
        second = second % 60;

        return day + "天" + hour + "时" + minute + "分" + second + "秒";
    }

    /**
     * 将日期格式化成友好的字符串：今天，昨天，几月几日
     *
     * @param time
     * @return
     */
    public static String formatDay(long time) {
        long diff = new Date().getTime() - time * 1000;
        long r = 0;
        String timeDay = "";
        if (diff > day) {
            r = (diff / day);
        }
        if (isToday(time * 1000)) {
            timeDay = "今天";
        } else if (r == 1) {
            timeDay = "昨天";
        } else {
            timeDay = formatDateTime(time * 1000, DF_MM_DD);
        }
        return timeDay;
    }

    /**
     * 将日期格式化成友好的字符串：今天，昨天，几月几日
     *
     * @param time
     * @return
     */
    public static SpannableString formatDayForThisApp(long time) {
        long diff = new Date().getTime() - time * 1000;
        long r = 0;
        SpannableString spannableString;
        if (diff > day) {
            r = (diff / day);
        }
        if (isToday(time * 1000)) {
            spannableString = new SpannableString("今天");
            spannableString.setSpan(new AbsoluteSizeSpan(28, true), 0, 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        } else if (r == 1 || r == 0) {
            spannableString = new SpannableString("昨天");
            spannableString.setSpan(new AbsoluteSizeSpan(28, true), 0, 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        } else {
            Date date = currentTimeToDateDrop(time * 1000);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            String timeDay = "" + (calendar.get(Calendar.DAY_OF_MONTH) >= 10 ? calendar.get(Calendar.DAY_OF_MONTH) : "0" + calendar.get(Calendar.DAY_OF_MONTH)) + (calendar.get(Calendar.MONTH) + 1) + "月";

            spannableString = new SpannableString(timeDay);
            if (timeDay.length() > 2) {
                spannableString.setSpan(new AbsoluteSizeSpan(28, true), 0, 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            }
        }
        return spannableString;
    }

    /**
     * 将日期格式化成友好的字符串：几分钟前、几小时前、几天前、几月前、几年前、刚刚
     *
     * @param date
     * @return
     */
    public static String formatFriendly(Date date) {
        if (date == null) {
            return null;
        }
        long diff = new Date().getTime() - date.getTime();
        return formatFriendly(diff);
    }

    public static String formatFriendly(long diff) {
        diff = System.currentTimeMillis() - diff;
        long r = 0;
        if (diff > year) {
            r = (diff / year);
            return r + "年前";
        }
        if (diff > month) {
            r = (diff / month);
            return r + "个月前";
        }
        if (diff > day) {
            r = (diff / day);
            return r + "天前";
        }
        if (diff > hour) {
            r = (diff / hour);
            return r + "个小时前";
        }
        if (diff > minute) {
            r = (diff / minute);
            return r + "分钟前";
        }
        return "刚刚";
    }

    /**
     * 将日期以yyyy-MM-dd HH:mm:ss格式化
     *
     * @param dateL 日期
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static String formatDateTime(long dateL) {
        if (String.valueOf(dateL).length() == 10) {
            dateL = dateL * 1000;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(DF_YYYY_MM_DD_HH_MM_SS);
        Date date = new Date(dateL);
        return sdf.format(date);
    }

    /**
     * 将日期以HH:mm:ss格式化
     *
     * @param dateL 日期
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static String formatHourTime(long dateL) {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(dateL);
        SimpleDateFormat fmat = new SimpleDateFormat("HH:mm:ss");
        String time = fmat.format(calendar.getTime());
        return time;
    }

    /**
     * 将日期以yyyy-MM-dd HH:mm:ss格式化
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static String formatChatDateTime(long diff) {
        if (String.valueOf(diff).length() == 10) {
            diff = diff * 1000;
        }
        long surplus = System.currentTimeMillis() - diff;
        if (surplus > year || surplus > month || surplus > week) {
            return formatDateTime(diff, DF_MM_DD);
        }
        if (surplus < week && surplus > day * 2) {//显示周几
            return formatDate(diff);
        }
        if (surplus > day && surplus < day * 2) {
            return "昨天";
        }
        return formatDateTime(diff, DF_HH_MM);
    }

    public static String formatDateTime(long dateL, String formater) {
        if (String.valueOf(dateL).length() == 10)
            dateL = dateL * 1000;
        SimpleDateFormat sdf = new SimpleDateFormat(formater);
        return sdf.format(new Date(dateL));
    }


    /**
     * 将日期以yyyy-MM-dd HH:mm:ss格式化
     *
     * @param date     日期
     * @param formater
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static String formatDateTime(Date date, String formater) {
        SimpleDateFormat sdf = new SimpleDateFormat(formater);
        return sdf.format(date);
    }

    /**
     * 将日期字符串转成日期
     *
     * @param strDate 字符串日期
     * @return java.util.date日期类型
     */
    @SuppressLint("SimpleDateFormat")
    public static Date parseDate(String strDate) {
        DateFormat dateFormat = new SimpleDateFormat(DF_YYYY_MM_DD_HH_MM_SS);
        Date returnDate = null;
        try {
            returnDate = dateFormat.parse(strDate);
        } catch (ParseException e) {

        }
        return returnDate;

    }

    /**
     * 将日期字符串转成日期
     *
     * @param strDate 字符串日期
     * @return long 日期类型
     */
    @SuppressLint("SimpleDateFormat")
    public static long parseLong(String strDate) {
        DateFormat dateFormat = new SimpleDateFormat(DF_YYYY_MM_DD_HH_MM);
        long returnTiem = 0L;
        try {
            returnTiem = dateFormat.parse(strDate).getTime() / 1000;
        } catch (ParseException e) {

        }
        return returnTiem;

    }

    /**
     * 将日期字符串转成日期
     *
     * @param strDate 字符串日期
     * @return java.util.date日期类型
     */
    @SuppressLint("SimpleDateFormat")
    public static Date parseDate(String strDate, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date returnDate = null;
        try {
            returnDate = dateFormat.parse(strDate);
        } catch (ParseException e) {

        }
        return returnDate;

    }

    /**
     * 获取系统当前日期
     *
     * @return
     */
    public static Date gainCurrentDate() {
        return new Date();
    }

    /**
     * 判断是否是当天
     *
     * @param current 时间戳类型
     * @return true 当天 false 其他时间
     */
    public static boolean isToday(long current) {
        long zero = System.currentTimeMillis() / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
        long twelve = zero + 24 * 60 * 60 * 1000 - 1;//今天23点59分59秒的毫秒数
        long yesterday = System.currentTimeMillis() - 24 * 60 * 60 * 1000;//昨天的这一时间的毫秒数
//        System.out.println(new Timestamp(current));//当前时间
////        System.out.println(new Timestamp(yesterday));//昨天这一时间点
////        System.out.println(new Timestamp(zero));//今天零点零分零秒
////        System.out.println(new Timestamp(twelve));//今天23点59分59秒
        return current >= zero;
    }

    /**
     * 验证日期是否比当前日期早
     *
     * @param target1 比较时间1
     * @param target2 比较时间2
     * @return true 则代表target1比target2晚或等于target2，否则比target2早
     */
    public static boolean compareDate(Date target1, Date target2) {
        boolean flag = false;
        try {
            String target1DateTime = formatDateTime(target1, DF_YYYY_MM_DD_HH_MM_SS);
            String target2DateTime = formatDateTime(target2, DF_YYYY_MM_DD_HH_MM_SS);
            if (target1DateTime.compareTo(target2DateTime) <= 0) {
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("比较失败，原因：" + e.getMessage());
        }
        return flag;
    }

    /**
     * 对日期进行增加操作
     *
     * @param target 需要进行运算的日期
     * @param hour   小时
     * @return
     */
    public static Date addDateTime(Date target, double hour) {
        if (null == target || hour < 0) {
            return target;
        }

        return new Date(target.getTime() + (long) (hour * 60 * 60 * 1000));
    }

    /**
     * 对日期进行相减操作
     *
     * @param target 需要进行运算的日期
     * @param hour   小时
     * @return
     */
    public static Date subDateTime(Date target, double hour) {
        if (null == target || hour < 0) {
            return target;
        }

        return new Date(target.getTime() - (long) (hour * 60 * 60 * 1000));
    }

    /**
     * 获取系统时间的方法:月/日 时:分:秒
     */
    public static String getFormateDate() {
        Calendar calendar = Calendar.getInstance();
        int month = (calendar.get(Calendar.MONTH) + 1);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        String systemTime = (month < 10 ? "0" + month : month) + "/" + (day < 10 ? "0" + day : day) + "  " + (hour < 10 ? "0" + hour : hour) + ":" + (minute < 10 ? "0" + minute : minute) + ":" + (second < 10 ? "0" + second : second);
        return systemTime;
    }

    /**
     * 获取系统时间的方法:时:分:秒
     */
    public static String getHourAndMinute() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        return (hour < 10 ? "0" + hour : hour) + ":" + (minute < 10 ? "0" + minute : minute);
    }

    /**
     * 获取系统时间的方法:时
     */
    public static String getHour() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        return ((hour < 10 ? "0" + hour : hour) + "");
    }

    /**
     * 将2017-07-10 00:00:00 换2017-07-10
     *
     * @param strDate
     * @return
     */
    public static String strFormatStr(String strDate) {
        if (strDate.equals("")) {
            return "";
        }
        return dateToStr(strToDate(strDate));
    }

    /**
     * 2015-01-07 15:05:34
     *
     * @param strDate
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static Date strToDateHHMMSS(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    /**
     * 2015-01-07
     *
     * @param strDate
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static Date strToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    /**
     * 2015.01.07
     *
     * @param strDate
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static Date strToDateDorp(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    @SuppressLint("SimpleDateFormat")
    public static String dateToStr(Date dateDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(dateDate);
        return dateString;
    }

    /**
     * 传入一个String转化为long
     */
    @SuppressLint("SimpleDateFormat")
    public static Long stringParserLong(String param) throws ParseException {
        format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.parse(param).getTime();
    }

    /**
     * 传入一个String转化为long
     */
    @SuppressLint("SimpleDateFormat")
    public static Long stringParserLong(String param, String aformat, long defaultValue) {
        format = new SimpleDateFormat(aformat);
        try {
            return format.parse(param).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return defaultValue;
    }

    /**
     * 传入一个String转化为long
     */
    @SuppressLint("SimpleDateFormat")
    public static Long stringParserLongShort(String param) {
        format = new SimpleDateFormat("yyyy-MM-dd");
        long time = 0;
        try {
            time = format.parse(param).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    /**
     * 当前时间转换为long
     */
    @SuppressLint("SimpleDateFormat")
    public static Long currentDateParserLong() throws ParseException {
        format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.parse(format.format(Calendar.getInstance().getTime())).getTime();
    }

    /**
     * 当前时间 如: 2013-04-22 10:37:00
     */
    @SuppressLint("SimpleDateFormat")
    public static String getCurrentDate() {
        format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(Calendar.getInstance().getTime());
    }

    /**
     * 当前时间 如: 10:37
     */
    @SuppressLint("SimpleDateFormat")
    public static String getCurrentDateHHMM() {
        format = new SimpleDateFormat("HH:mm");
        return format.format(Calendar.getInstance().getTime());
    }

    /**
     * 当前时间 如: 10:37
     *
     * @throws ParseException
     */
    @SuppressLint("SimpleDateFormat")
    public static String getCurrentDateHHMMSS() {
        format = new SimpleDateFormat("HH:mm:ss");
        return format.format(Calendar.getInstance().getTime());
    }

    /**
     * 当前时间 如: 20130422
     */
    @SuppressLint("SimpleDateFormat")
    public static String getCurrentDateString() {
        format = new SimpleDateFormat("yyyyMMddHHmm");
        return format.format(Calendar.getInstance().getTime());
    }

    /**
     * 当前时间 如: 2013-04-22
     */
    @SuppressLint("SimpleDateFormat")
    public static String getCurrentTime() {
        format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(Calendar.getInstance().getTime());
    }

    @SuppressLint("SimpleDateFormat")
    public static String getSWAHDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(Calendar.getInstance().getTime());
    }

    @SuppressLint("SimpleDateFormat")
    public static Long stringToLongD(String param) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.parse(param.substring(0, param.length() - 4)).getTime();
    }

    @SuppressLint("SimpleDateFormat")
    public static Long stringToLong(String param) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmm");
        return format.parse(param).getTime();
    }

    /**
     * 获取两个日期之间的间隔天数
     *
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static int getGapCount(Date startDate, Date endDate) {
        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTime(startDate);
        fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
        fromCalendar.set(Calendar.MINUTE, 0);
        fromCalendar.set(Calendar.SECOND, 0);
        fromCalendar.set(Calendar.MILLISECOND, 0);

        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTime(endDate);
        toCalendar.set(Calendar.HOUR_OF_DAY, 0);
        toCalendar.set(Calendar.MINUTE, 0);
        toCalendar.set(Calendar.SECOND, 0);
        toCalendar.set(Calendar.MILLISECOND, 0);

        return (int) ((toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / (1000 * 60 * 60 * 24));
    }

    /**
     * 日期转换成Java字符串
     *
     * @param date
     * @return str
     */
    @SuppressLint("SimpleDateFormat")
    public static String DateToStr(Date date) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(date);
        return str;
    }

    /**
     * 字符串转换成日期
     *
     * @param str
     * @return date
     */
    @SuppressLint("SimpleDateFormat")
    public static Date StrToDate(String str) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * long转date
     * 时间戳转换成日期
     *
     * @param time
     * @return date
     */
    @SuppressLint("SimpleDateFormat")
    public static Date currentTimeToDateDrop(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d = format.format(time);
        Date date = null;
        try {
            date = format.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 字符串转换成日期
     *
     * @param str
     * @return date
     */
    @SuppressLint("SimpleDateFormat")
    public static Date StrToDateDrop(String str) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * @param time
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static long getLongTime(String time) {
        long ct = 0;
        try {
            format = new SimpleDateFormat("HH:mm:ss");
            ct = format.parse(time).getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ct;
    }

    /**
     * 判断两日期是否同一天
     *
     * @param str1
     * @param str2
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static boolean isSameDay(String str1, String str2) {

        Date day1 = null, day2 = null;
        day1 = TimerUtils.strToDate(str1);
        day2 = TimerUtils.strToDate(str2);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String ds1 = sdf.format(day1);

        String ds2 = sdf.format(day2);

        if (ds1.equals(ds2)) {
            return true;
        } else {
            return false;
        }

    }

    @SuppressLint("SimpleDateFormat")
    public static boolean isSameDay(long str1, long str2) {

        String ds1 = formatDateTime(str1, "yyyy-MM-dd");

        String ds2 = formatDateTime(str2, "yyyy-MM-dd");

        if (ds1.equals(ds2)) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 获取两个日期的时间差
     */
    @SuppressLint("SimpleDateFormat")
    public static int getTimeInterval(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int interval = 0;
        try {
            Date currentTime = new Date();// 获取现在的时间
            Date beginTime = dateFormat.parse(date);
            interval = (int) ((beginTime.getTime() - currentTime.getTime()) / (1000));// 时间差
            // 单位秒
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return interval;
    }

    /**
     * 获取两个日期的时间差 yyyy.MM.dd HH.mm.ss
     */
    @SuppressLint("SimpleDateFormat")
    public static int getInterval(String bDate, String eDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        int interval = 0;
        try {
            Date currentTime = dateFormat.parse(eDate);// 获取现在的时间
            Date beginTime = dateFormat.parse(bDate);
            interval = (int) ((beginTime.getTime() - currentTime.getTime()));// 时间差
            // 单位秒
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return interval;
    }

    @SuppressLint("SimpleDateFormat")
    public static long getTimeFormat(String date, String format) {

        DateFormat df = new SimpleDateFormat(format);
        long diff = 0;
        try {
            Date getdate = df.parse(date);
            diff = getdate.getTime();
        } catch (Exception e) {
        }
        return diff;
    }

    /**
     * 两个时间之差 求出一个long Time
     *
     * @param date
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static long getTime(String date) {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long diff = 0;
        try {
            Date currentTime = new Date();// 获取现在的时间
            Date getdate = df.parse(date);
            diff = getdate.getTime() - currentTime.getTime();

        } catch (Exception e) {
        }
        return diff;
    }

    @SuppressLint("SimpleDateFormat")
    public static long getTime(String date, String format) {

        DateFormat df = new SimpleDateFormat(format);
        long diff = 0;
        try {
            Date currentTime = new Date();// 获取现在的时间
            Date getdate = df.parse(date);
            diff = getdate.getTime() - currentTime.getTime();

        } catch (Exception e) {
        }
        return diff;
    }

    public static String getFormat(String date, int time) {
        String format = FORMATS[time];
        DateFormat df = new SimpleDateFormat(format);
        try {
            Date getdate = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return getFormat(date, ++time);
        }
        return format;
    }


    /**
     * 日期转换成Java字符串
     *
     * @param DATE1
     * @param DATE2
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static int compare_date(String DATE1, String DATE2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() >= dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    /**
     * 传入时间 算出星期几
     *
     * @param str  2014年1月3日
     * @param days 1:2014年1月4日 类推
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static String formatDate(String str, int days) {

        String dateStr = "";
        try {
            DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
            Date date = df.parse(str);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            Date d = dateFormat.parse(dateFormat.format(date));
            c.setTime(d);
            c.add(Calendar.DAY_OF_MONTH, days);
            switch (c.get(Calendar.DAY_OF_WEEK) - 1) {
                case 0:
                    dateStr = "周日";
                    break;
                case 1:
                    dateStr = "周一";
                    break;
                case 2:
                    dateStr = "周二";
                    break;
                case 3:
                    dateStr = "周三";
                    break;
                case 4:
                    dateStr = "周四";
                    break;
                case 5:
                    dateStr = "周五";
                    break;
                case 6:
                    dateStr = "周六";
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dateStr;
    }

    @SuppressLint("SimpleDateFormat")
    public static String formatDate(long str) {

        String dateStr = "";
        try {
            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(str);
            switch (c.get(Calendar.DAY_OF_WEEK) - 1) {
                case 0:
                    dateStr = "周日";
                    break;
                case 1:
                    dateStr = "周一";
                    break;
                case 2:
                    dateStr = "周二";
                    break;
                case 3:
                    dateStr = "周三";
                    break;
                case 4:
                    dateStr = "周四";
                    break;
                case 5:
                    dateStr = "周五";
                    break;
                case 6:
                    dateStr = "周六";
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dateStr;
    }


    /**
     * @param day
     * @return
     */
    private static String getDayOfWeek(int day) {
        System.out.println(day);
        String dayOfWeek = "周";
        switch (day) {
            case 1:
                dayOfWeek += "日";
                break;
            case 2:
                dayOfWeek += "一";
                break;
            case 3:
                dayOfWeek += "二";
                break;
            case 4:
                dayOfWeek += "三";
                break;
            case 5:
                dayOfWeek += "四";
                break;
            case 6:
                dayOfWeek += "五";
                break;
            case 7:
                dayOfWeek += "六";
                break;
        }
        return dayOfWeek;
    }







































    public static String getTime(int second) {
        if (second < 10) {
            return "00:0" + second;
        }
        if (second < 60) {
            return "00:" + second;
        }
        if (second < 3600) {
            int minute = second / 60;
            second = second - minute * 60;
            if (minute < 10) {
                if (second < 10) {
                    return "0" + minute + ":0" + second;
                }
                return "0" + minute + ":" + second;
            }
            if (second < 10) {
                return minute + ":0" + second;
            }
            return minute + ":" + second;
        }
        int hour = second / 3600;
        int minute = (second - hour * 3600) / 60;
        second = second - hour * 3600 - minute * 60;
        if (hour < 10) {
            if (minute < 10) {
                if (second < 10) {
                    return "0" + hour + ":0" + minute + ":0" + second;
                }
                return "0" + hour + ":0" + minute + ":" + second;
            }
            if (second < 10) {
                return "0" + hour + minute + ":0" + second;
            }
            return "0" + hour + minute + ":" + second;
        }
        if (minute < 10) {
            if (second < 10) {
                return hour + ":0" + minute + ":0" + second;
            }
            return hour + ":0" + minute + ":" + second;
        }
        if (second < 10) {
            return hour + minute + ":0" + second;
        }
        return hour + minute + ":" + second;
    }

    /**
     * All, 年月日时分秒
     * Year,年
     * Year_Mouth,年月
     * Year_Mouth_Day 年月日
     */
    public enum AppTime {
        All,
        Year,
        Year_Mouth,
        Year_Mouth_Day,
        H_M_S
    }

    private static String formatStr;

    /**
     * 格式化时间
     * 传入long 返回string
     * @param time
     * @return
     */
    public static String FormarTime(AppTime appTime, long time) {
        switch (appTime) {
            case All:
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                formatStr = dateFormat.format(time);
                break;
            case Year:
                SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy");
                formatStr = dateFormat1.format(time);
                break;
            case Year_Mouth:
                SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM");
                formatStr = dateFormat2.format(time);
                break;
            case Year_Mouth_Day:
                SimpleDateFormat dateFormat3 = new SimpleDateFormat("yyyy-MM-dd");
                formatStr = dateFormat3.format(time);
                break;
            case H_M_S:
                SimpleDateFormat dateFormat4 = new SimpleDateFormat("HH:mm:ss");
                formatStr = dateFormat4.format(time);
                break;
        }
        return formatStr;
    }

     /**
     * 格式化时间
     * 传入 date 返回string
     * @param time
     * @return
     */
    public static String FormarDateTimeStr(AppTime appTime, Date time) {
        switch (appTime) {
            case All:
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                formatStr = dateFormat.format(time);
                break;
            case Year:
                SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy");
                formatStr = dateFormat1.format(time);
                break;
            case Year_Mouth:
                SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM");
                formatStr = dateFormat2.format(time);
                break;
            case Year_Mouth_Day:
                SimpleDateFormat dateFormat3 = new SimpleDateFormat("yyyy-MM-dd");
                formatStr = dateFormat3.format(time);
                break;
            case H_M_S:
                SimpleDateFormat dateFormat4 = new SimpleDateFormat("HH:mm:ss");
                formatStr = dateFormat4.format(time);
                break;
        }
        return formatStr;
    }





    /**
     * 将秒转化为时分秒
     *
     * @param time
     * @return
     */
    public static String secToTime(int time) {
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (time <= 0)
            return "00:00";
        else {
            minute = time / 60;
            if (minute < 60) {
                second = time % 60;
                timeStr = unitFormat(minute) + ":" + unitFormat(second);
            } else {
                hour = minute / 60;
                if (hour > 99)
                    return "99:59:59";
                minute = minute % 60;
                second = time - hour * 3600 - minute * 60;
                timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);
            }
        }
        return timeStr;
    }

    public static String unitFormat(int i) {
        String retStr = null;
        if (i >= 0 && i < 10)
            retStr = "0" + Integer.toString(i);
        else
            retStr = "" + i;
        return retStr;
    }


    private static String mYear; // 当前年
    private static String mMonth; // 月
    private static String mDay;

    /**
     * 获取当前日期几月几号
     */
    public static String getDateString() {
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        mMonth = String.valueOf(c.get(Calendar.MONTH) + 1);// 获取当前月份
        mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));// 获取当前月份的日期号码
        if (!TextUtils.isEmpty(mDay) && !TextUtils.isEmpty(mMonth) && !TextUtils.isEmpty(mYear)) {
            if (Integer.parseInt(mDay) > MaxDayFromDay_OF_MONTH(Integer.parseInt(mYear), (Integer.parseInt(mMonth)))) {
                mDay = String.valueOf(MaxDayFromDay_OF_MONTH(Integer.parseInt(mYear), (Integer.parseInt(mMonth))));
            }
        }
        return mMonth + "月" + mDay + "日";
    }

    /**
     * 获取当前年月日
     * @return
     */
    public static String StringData() {
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        mYear = String.valueOf(c.get(Calendar.YEAR));// 获取当前年份
        mMonth = String.valueOf(c.get(Calendar.MONTH) + 1);// 获取当前月份
        mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));// 获取当前月份的日期号码
        if (!TextUtils.isEmpty(mDay) && !TextUtils.isEmpty(mMonth) && !TextUtils.isEmpty(mYear)) {
            if (Integer.parseInt(mDay) > MaxDayFromDay_OF_MONTH(Integer.parseInt(mYear), (Integer.parseInt(mMonth)))) {
                mDay = String.valueOf(MaxDayFromDay_OF_MONTH(Integer.parseInt(mYear), (Integer.parseInt(mMonth))));
            }
        }
        return mYear + "-" + (mMonth.length() == 1 ? "0" + mMonth : mMonth) + "-" + (mDay.length() == 1 ? "0" + mDay : mDay);
    }

    /**
     * 根据当前日期获得是星期几
     * @return
     */
    public static String getWeek(String time) {
        String Week = "";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(format.parse(time));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            Week += "周日";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 2) {
            Week += "周一";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 3) {
            Week += "周二";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 4) {
            Week += "周三";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 5) {
            Week += "周四";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 6) {
            Week += "周五";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 7) {
            Week += "周六";
        }
        return Week;
    }


    /**
     * 获取今天往后一周的日期（几月几号）
     */
    public static List<String> getSevendate() {
        List<String> dates = new ArrayList<String>();
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        for (int i = 0; i < 7; i++) {
            mYear = String.valueOf(c.get(Calendar.YEAR));// 获取当前年份
            mMonth = String.valueOf(c.get(Calendar.MONTH) + 1);// 获取当前月份
            mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH) + i);// 获取当前日份的日期号码
            if (!TextUtils.isEmpty(mDay) && !TextUtils.isEmpty(mMonth) && !TextUtils.isEmpty(mYear)) {
                if (Integer.parseInt(mDay) > MaxDayFromDay_OF_MONTH(Integer.parseInt(mYear), (i + 1))) {
                    mDay = String.valueOf(MaxDayFromDay_OF_MONTH(Integer.parseInt(mYear), (i + 1)));
                }
            }
            String date = mMonth + "月" + mDay + "日";
            dates.add(date);
        }
        return dates;
    }


    /**
     * 获取今天往后一周的集合
     */
    public static List<String> get7week() {
        String week = "";
        List<String> weeksList = new ArrayList<String>();
        List<String> dateList = get7date();
        for (String s : dateList) {
            if (s.equals(StringData())) {
                week = "今天";
            } else {
                week = getWeek(s);
            }
            weeksList.add(week);
        }
        return weeksList;
    }


    public static List<String> get7date() {
        List<String> dates = new ArrayList<String>();
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        java.text.SimpleDateFormat sim = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String date = sim.format(c.getTime());
        dates.add(date);
        for (int i = 0; i < 6; i++) {
            c.add(java.util.Calendar.DAY_OF_MONTH, 1);
            date = sim.format(c.getTime());
            dates.add(date);
        }
        return dates;
    }

    /**
     * 得到当年当月的最大日期
     **/
    public static int MaxDayFromDay_OF_MONTH(int year, int month) {
        Calendar time = Calendar.getInstance();
        time.clear();
        time.set(Calendar.YEAR, year);
        time.set(Calendar.MONTH, month - 1);//注意,Calendar对象默认一月为0                 
        int day = time.getActualMaximum(Calendar.DAY_OF_MONTH);//本月份的天数
        return day;
    }

}
