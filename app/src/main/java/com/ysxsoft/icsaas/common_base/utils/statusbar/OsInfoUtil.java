package com.ysxsoft.icsaas.common_base.utils.statusbar;

import android.app.Activity;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author wushange
 * 检测ROM 是miui还是flyme
 */
public class OsInfoUtil {

	private static final String KEY_MIUI_VERSION_CODE = "ro.miui.ui.version.code";
	private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
	private static final String KEY_MIUI_INTERNAL_STORAGE = "ro.miui.internal.storage";

	public static boolean isMIUI() {
		try {
			final BuildProperties prop = BuildProperties.newInstance();
			return prop.getProperty(KEY_MIUI_VERSION_CODE, null) != null
					|| prop.getProperty(KEY_MIUI_VERSION_NAME, null) != null
					|| prop.getProperty(KEY_MIUI_INTERNAL_STORAGE, null) != null;
		} catch (final IOException e) {
			return false;
		}
	}

	public static boolean isFlyme() {
		try {
			// Invoke Build.hasSmartBar()
			final Method method = Build.class.getMethod("hasSmartBar");
			return method != null;
		} catch (final Exception e) {
			return false;
		}
	}

	public static int getVirtualKeyHeight(Activity activity){
		int noHasVirtualKey = getNoHasVirtualKey(activity);
		int hasVirtualKey = getHasVirtualKey(activity);
		return hasVirtualKey-noHasVirtualKey;
	}

	private static int getNoHasVirtualKey(Activity context) {
		return context.getWindowManager().getDefaultDisplay().getHeight();
	}

	/**
	 * 通过反射，获取包含虚拟键的整体屏幕高度
	 *
	 * @return
	 */
	private static int getHasVirtualKey(Activity activity) {
		int dpi = 0;
		Display display = activity.getWindowManager().getDefaultDisplay();
		DisplayMetrics dm = new DisplayMetrics();
		@SuppressWarnings("rawtypes")
        Class c;
		try {
			c = Class.forName("android.view.Display");
			@SuppressWarnings("unchecked")
            Method method = c.getMethod("getRealMetrics", DisplayMetrics.class);
			method.invoke(display, dm);
			dpi = dm.heightPixels;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dpi;
	}

}
