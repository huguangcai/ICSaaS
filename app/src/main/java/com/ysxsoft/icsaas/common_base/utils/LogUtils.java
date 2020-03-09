package com.ysxsoft.icsaas.common_base.utils;

import android.util.Log;

import com.google.zxing.common.StringUtils;


/**
 * 日志工具类
 */

public class LogUtils {
	public static final String TAG = "LogUtils";
	public static final boolean LOG_OPEN_DEBUG = true;

	public static void e(String message) {
		if (!CheckUtils.isEmpty(message)) {
			if (LOG_OPEN_DEBUG) {
				Log.e(TAG, message);
			}
		} else {
			Log.e(TAG, "==>数据为空:" + message);
		}
	}

	public static void i(String message) {
		if (!CheckUtils.isEmpty(message)) {
			if (LOG_OPEN_DEBUG) {
				Log.i(TAG, message);
			}
		} else {
			Log.i(TAG, "==>数据为空:" + message);
		}
	}

	public static void d(String tag, String message) {
		if (message == null) {
			return;
		}
		if (LOG_OPEN_DEBUG) {
			Log.d(tag, message);
		}
	}

	public static void i(String tag, String message) {
		if (!CheckUtils.isEmpty(message)) {
			if (LOG_OPEN_DEBUG) {
				Log.i(tag, message);
			}
		} else {
			Log.i(tag, "==>数据为空:" + message);
		}
	}

	public static void w(String tag, String message) {
		if (!CheckUtils.isEmpty(message)) {
			if (LOG_OPEN_DEBUG) {
				Log.w(tag, message);
			}
		} else {
			Log.w(tag, "==>数据为空:" + message);
		}
	}

	public static void e(String tag, String message) {
		if (!CheckUtils.isEmpty(message)) {
			if (LOG_OPEN_DEBUG) {
				Log.e(tag, message);
			} else {
				Log.e(tag, "==>数据为空:" + message);
			}
		}
	}

	public static void v(String tag, String message) {
		if (!CheckUtils.isEmpty(message)) {
			if (LOG_OPEN_DEBUG) {
				Log.v(tag, message);
			} else {
				Log.v(tag, "==>数据为空:" + message);
			}
		}
	}
}
