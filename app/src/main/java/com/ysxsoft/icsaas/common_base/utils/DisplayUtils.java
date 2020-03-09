package com.ysxsoft.icsaas.common_base.utils;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/**
 * Create By 胡
 * on 2020/3/3 0003
 */
public class DisplayUtils {

    private static float sNoncompatDensity;
    private static float sNoncompatScaledDensity;
    /**
     * 今日头条适配方案  以宽360dp  为基准
     *
     * @param activity
     * @param application
     */
    public static void setCustomDensity(Activity activity, final Application application) {
        DisplayMetrics appDisplayMetrics = application.getResources().getDisplayMetrics();
        if (sNoncompatDensity == 0) {
            sNoncompatDensity = appDisplayMetrics.density;
            sNoncompatScaledDensity = appDisplayMetrics.scaledDensity;
            application.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(Configuration newConfig) {
                    if (newConfig != null && newConfig.fontScale > 0) {
                        sNoncompatScaledDensity = application.getResources().getDisplayMetrics().scaledDensity;
                    }
                }

                @Override
                public void onLowMemory() {

                }
            });
            float targetDensity = appDisplayMetrics.widthPixels / 360;
            float targetScaleDensity = targetDensity * (sNoncompatScaledDensity / sNoncompatDensity);
            int targetDensityDpi = (int) (160 * targetDensity);

            appDisplayMetrics.density = targetDensity;
            appDisplayMetrics.scaledDensity = targetScaleDensity;
            appDisplayMetrics.densityDpi = targetDensityDpi;

            DisplayMetrics activityDisplayMetrics = activity.getResources().getDisplayMetrics();
            activityDisplayMetrics.density = targetDensity;
            activityDisplayMetrics.scaledDensity = targetScaleDensity;
            activityDisplayMetrics.densityDpi = targetDensityDpi;

        }
    }

    /**
     * 获取状态栏高度
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        int statusBarHeight = 0;
        int resouceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        statusBarHeight = context.getResources().getDimensionPixelSize(resouceId);
        return statusBarHeight;
    }

    /**
     * 获取底部栏高度
     * @param context
     * @return
     */
    public static int getNavigationBarHeight(Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        int height = resources.getDimensionPixelSize(resourceId);
        return height;
    }

    /**
     * 获取设备像素密度
     * @param context
     * @return
     */
    public static int getDensityDpi(Context context) {
        return context.getResources().getDisplayMetrics().densityDpi;
    }

    /**
     *获取设备宽度
     * @param context
     * @return
     */
    public static int getDisplayWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * 获取设备高度
     * @param context
     * @return
     */
    public static int getDisplayHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }



    /**
     * dp转px
     *
     * @param context
     * @param dpVal
     * @return
     */
    public static int dp2px(Context context, float dpVal) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpVal * scale + 0.5f);
    }

    /**
     * sp转px
     *
     * @param context
     * @param spVal
     * @return
     */
    public static int sp2px(Context context, float spVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                spVal, context.getResources().getDisplayMetrics());
    }

    /**
     * px转dp
     *
     * @param context
     * @param pxVal
     * @return
     */
    public static float px2dp(Context context, float pxVal) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (pxVal / scale);
    }

    /**
     * px转sp
     *
     * @param pxVal
     * @param pxVal
     * @return
     */
    public static float px2sp(Context context, float pxVal) {
        return (pxVal / context.getResources().getDisplayMetrics().scaledDensity);
    }

}
