package com.ysxsoft.icsaas.common_base.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/******************************************
 * 类描述: 获取设备信息工具类
 *
 * @version: V1.0
 * @author: huguangcai
 * @time: 2017-08-08 10:14
 ******************************************/

public final class DeviceUtils {

    private DeviceUtils() {
    }

    /**
     * 获取屏幕宽高度
     *
     * @param context
     * @param isWidth 是否获取屏幕宽度true为是，false为获取高度
     * @return
     */
    public static int getScreenWidthAndHeight(Context context, boolean isWidth) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return isWidth ? metrics.widthPixels : metrics.heightPixels;
    }

    /**
     * @param context
     * @param isWidth
     * @return
     */
    public static int getNormalDialogWidthOrHeight(Context context, boolean isWidth) {
        if (isWidth) {
            return getScreenWidthAndHeight(context, isWidth) * 4 / 5;
        }
        return getScreenWidthAndHeight(context, isWidth) / 2;
    }

    /**
     * 获取设备状态栏高度
     *
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /**
     * 获取app版本名称
     *
     * @param context
     * @return
     */
    public static String getVersionName(Context context) {
        PackageInfo pi;

        try {
            PackageManager pm = context.getPackageManager();
            pi = pm.getPackageInfo(context.getPackageName(),
                    PackageManager.GET_CONFIGURATIONS);
            return pi.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "1.0.0";
    }

    /**
     * 获取配置渠道号
     *
     * @return
     */
    public static String getChannel(Context context) {
        ApplicationInfo appInfo = null;
        try {
            appInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        if (appInfo != null && appInfo.metaData != null) {
            return String.valueOf(appInfo.metaData.get("UMENG_CHANNEL"));
        }
        return null;
    }

    /**
     * 获取umeng APPKEY
     *
     * @param context
     * @return
     */
    public static String getUmengAppKey(Context context) {
        ApplicationInfo appInfo = null;
        try {
            appInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(),PackageManager.GET_META_DATA);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        if (appInfo != null && appInfo.metaData != null) {
            return String.valueOf(appInfo.metaData.get("UMENG_APPKEY"));
        }
        return null;
    }

    /**
     * 获取umeng SECRET
     *
     * @param context
     * @return
     */
    public static String getUmengAppSecret(Context context) {
        ApplicationInfo appInfo = null;
        try {
            appInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(),PackageManager.GET_META_DATA);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        if (appInfo != null && appInfo.metaData != null) {
            return String.valueOf(appInfo.metaData.get("UMENG_MESSAGE_SECRET"));
        }
        return null;
    }

    /**
     * 获取进程号对应的进程名
     *
     * @param pid 进程号
     * @return 进程名
     */
    public static String getProcessName(int pid) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 获取手机IMEI号
     *
     * @param context
     * @return
     */
    public static String getPhoneIMEI(Context context) {
        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
    }

    /**
     * 获取手机IMSI号
     *
     * @param context
     * @return
     */
    public static String getPhoneIMSI(Context context) {
        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getSubscriberId();
    }

    /**
     * 获取制造商
     *
     * @return
     */
    public static String getVendor() {
        return Build.MANUFACTURER;
    }

    /**
     * 获取产品型号
     *
     * @return
     */
    public static String getProduct() {
        return Build.PRODUCT;
    }

    /**
     * 获取当前默认系统使用语言类型
     *
     * @return
     */
    public static String getSystemLanguage() {
        return Locale.getDefault().getLanguage();
    }

    /**
     * 获取当前系统版本
     *
     * @return
     */
    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    /**
     * 判断网络类型
     *
     * @param context
     * @return
     */
    public static String NetType(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = cm.getActiveNetworkInfo();
            String typeName = info.getTypeName().toLowerCase(); // WIFI/MOBILE
            if (typeName.equalsIgnoreCase("wifi")) {
            } else {
                typeName = info.getExtraInfo().toLowerCase();
                // 3gnet/3gwap/uninet/uniwap/cmnet/cmwap/ctnet/ctwap
            }
            return typeName;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 网络是否可用
     *
     * @param mContext
     * @return
     */
    public static boolean isNetworkAvaiable(Context mContext) {
        ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        return (info != null && info.isConnected());
    }



    /**
     * 是否正在运行
     *
     * @param context
     * @param packageName
     * @return
     */
    public static boolean isRunning(Context context, String packageName) {
        boolean isAppRunning = false;
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> list = am.getRunningTasks(100);
        for (ActivityManager.RunningTaskInfo info : list) {
            if (info.topActivity.getPackageName().equals(packageName)
                    && info.baseActivity.getPackageName().equals(packageName)) {
                isAppRunning = true;
                break;
            }
        }
        return isAppRunning;
    }

    /**
     * 启动app
     *
     * @param context
     * @param appName
     */
    public static void launchApp(Context context, String appName) {
        PackageManager packageManager = context.getPackageManager();
        // 获取手机里的应用列表
        List<PackageInfo> pInfo = packageManager.getInstalledPackages(0);
        for (int i = 0; i < pInfo.size(); i++) {
            PackageInfo p = pInfo.get(i);
            // 获取相关包的<application>中的label信息，也就是-->应用程序的名字
            String label = packageManager
                    .getApplicationLabel(p.applicationInfo).toString();
            System.out.println(label);
            if (label.equals(appName)) { // 比较label
                String pName = p.packageName; // 获取包名
                Intent intent = new Intent();
                // 获取intent
                intent = packageManager.getLaunchIntentForPackage(pName);
                context.startActivity(intent);

            }

        }
    }
    /**
     * 分享功能
     *
     * @param mContext      上下文
     * @param activityTitle Activity的名字
     * @param msgTitle      消息标题
     * @param msgText       消息内容
     * @param imgPath       图片路径，不分享图片则传null
     */
    public static void shareMsg(Context mContext, String activityTitle,
                                String msgTitle, String msgText, String imgPath) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        if (imgPath == null || imgPath.equals("")) {
            intent.setType("text/plain"); // 纯文本
        } else {
            File f = new File(imgPath);
            if (f != null && f.exists() && f.isFile()) {
                intent.setType("image/jpg");
                Uri u = Uri.fromFile(f);
                intent.putExtra(Intent.EXTRA_STREAM, u);
            }
        }
        intent.putExtra(Intent.EXTRA_SUBJECT, msgTitle);
        intent.putExtra(Intent.EXTRA_TEXT, msgText);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(Intent.createChooser(intent, activityTitle));
    }

    /**
     * GSON解析json数据
     *
     * @param json
     * @param cls
     */

    public static <T> T parse(String json, Type cls) {
        try {
            Gson gson = new Gson();
            return gson.fromJson(json, cls);
        } catch (Exception e) {
            Log.i("", "数据解析异常--" + e.getMessage());
        }
        return null;
    }

    /**
     * 拍照sd卡地址
     **/
    public static String getImageSDpath() {
        if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            return Environment.getExternalStorageDirectory().toString() + "/Camera/Nuctech";
        } else {
            return Environment.getExternalStorageDirectory().toString() + "/DCIM/Camera/Nuctech";
        }
    }

    /**
     * 创建图片名称
     *
     * @param dateTaken
     * @return
     */
    public static String createName(long dateTaken) {
        Date date = new Date(dateTaken);
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat dateFormat = new SimpleDateFormat("'IMG'_yyyyMMdd_HHmmss");
        return dateFormat.format(date);
    }
    /**
     * 获取版本号
     * 获得软件VersionCode
     */
    public static int getVersionCode(Context context) {
        PackageManager manager = context.getPackageManager();
        try {
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            return info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
        }
        return 0;
    }

    /**
     * 获得包名
     *
     * @param context
     * @return
     */
    public static String getPackageName(Context context) {
        PackageManager manager = context.getPackageManager();
        try {
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            return info.packageName;
        } catch (PackageManager.NameNotFoundException e) {
        }
        return "";
    }

    /**
     * 获取图标 bitmap
     *
     * @param context
     */
    public static synchronized Bitmap getLogoBitmap(Context context) {
        PackageManager packageManager = null;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = context.getApplicationContext().getPackageManager();
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            applicationInfo = null;
        }
        Drawable d = packageManager.getApplicationIcon(applicationInfo); //xxx根据自己的情况获取drawable
        BitmapDrawable bd = (BitmapDrawable) d;
        Bitmap bm = bd.getBitmap();
        return bm;
    }

}
