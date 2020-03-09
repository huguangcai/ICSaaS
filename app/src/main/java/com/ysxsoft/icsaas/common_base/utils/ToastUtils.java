package com.ysxsoft.icsaas.common_base.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ysxsoft.icsaas.R;


public class ToastUtils {
	//对话框时长号(毫秒)
	private static int duration = 200;

	//自定义toast对象
	private static Toast toast;
	private static Context mContext;

	public static void init(Context context) {
		mContext = context;
	}
	/**
	 * 自定义短Toast调用
	 * @param message 显示文本
	 * @return void
	 */
	public static void shortToast( String message) {
		toast = new Toast(mContext);
		toast.setDuration(Toast.LENGTH_SHORT);
		View view = ((LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.view_toast, null);
		TextView textView = (TextView) view.findViewById(R.id.toastContent);
		textView.setText(message);
		toast.setView(view);
		toast.setGravity(Gravity.CENTER,0,0);
		toast.show();
	}

	/**
	 * 自定义长Toast调用
	 * @param message 显示文本
	 * @return void
	 */
	public static void longToast( String message) {
		if (null == toast) {
			toast = new Toast(mContext);
			toast.setDuration(Toast.LENGTH_LONG);
			View view = ((LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.view_toast, null);
			TextView textView = (TextView) view.findViewById(R.id.toastContent);
			textView.setText(message);
			toast.setView(view);
			toast.show();
		} else {
			TextView textView = (TextView) toast.getView().findViewById(R.id.toastContent);
			textView.setText(message);
			toast.show();
		}
	}

	/**
	 * 取消显示Toast
	 *
	 */
	public static void cancelToast() {
		if (null != toast) {
			toast.cancel();
		}
	}

	/**
	 * 默认Toast调用
	 * @param message 显示文本
	 */
	@SuppressLint("WrongConstant")
	public static void Toast(final String message) {
		Toast.makeText(mContext, message, duration).show();
	}

	/**
	 * 将最长使用的显示方法单独提出来，方便使用。
	 * 屏幕中心位置短时间显示Toast。
	 * @param message
	 */
	public static void show(String message) {
		ToastShortCenter(message);
	}

	/**
	 * 屏幕底部中间位置显示短时间Toast
	 *
	 * @param message
	 */
	public static void ToastShortBottomCenter( String message) {
		if (mContext != null) {
			Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
		}
	}

	/**
	 * 屏幕底部左边位置短时间显示Toast
	 *
	 * @param context
	 * @param message
	 */
	public static void ToastShortBottomLeft(Context context, String message) {
		if (context != null) {

			Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.BOTTOM | Gravity.LEFT, 0, 0);
			toast.show();
		}
	}

	/**
	 * 屏幕底部右边位置短时间显示Toast
	 * @param message
	 */
	public static void ToastShortBottomRight( String message) {

		if (mContext != null) {

			Toast toast = Toast.makeText(mContext, message, Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.BOTTOM | Gravity.RIGHT, 0, 0);
			toast.show();
		}
	}

	/**
	 * 屏幕中心位置短时间显示Toast
	 * @param message
	 */
	public static void ToastShortCenter(String message) {
		if (mContext != null) {
			Toast toast = Toast.makeText(mContext, message, Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
		}
	}

	/**
	 * 屏幕中心左边位置短时间显示Toast
	 * @param message
	 */
	public static void ToastShortCenterLeft(String message) {
		if (mContext != null) {

			Toast toast = Toast.makeText(mContext, message, Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER | Gravity.LEFT, 0, 0);
			toast.show();
		}
	}

	/**
	 * 屏幕中心右边位置短时间显示Toast
	 * @param message
	 */
	public static void ToastShortCenterRight( String message) {
		if (mContext != null) {

			Toast toast = Toast.makeText(mContext, message, Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER | Gravity.RIGHT, 0, 0);
			toast.show();
		}
	}

	/**
	 * 屏幕顶部中心位置短时间显示Toast
	 * @param message
	 */
	public static void ToastShortTopCenter( String message) {
		if (mContext != null) {
			Toast toast = Toast.makeText(mContext, message, Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.TOP, 0, 0);
			toast.show();
		}
	}

	/**
	 * 屏幕顶部左边位置短时间显示Toast
	 * @param message
	 */
	public static void ToastShortTopLeft(String message) {
		if (mContext != null) {
			Toast toast = Toast.makeText(mContext, message, Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);
			toast.show();
		}
	}

	/**
	 * 屏幕顶部右边位置短时间显示Toast
	 * @param message
	 */
	public static void ToastShortTopRight( String message) {
		if (mContext != null) {

			Toast toast = Toast.makeText(mContext, message, Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.TOP | Gravity.RIGHT, 0, 0);
			toast.show();
		}
	}

	/**
	 * 屏幕底部中间位置显示长时间Toast
	 * @param message
	 */
	public static void ToastLongBottomCenter( String message) {
		if (mContext != null) {

			Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
		}
	}

	/**
	 * 屏幕底部左边位置长时间显示Toast
	 * @param message
	 */
	public static void ToastLongBottomLeft( String message) {
		if (mContext != null) {

			Toast toast = Toast.makeText(mContext, message, Toast.LENGTH_LONG);
			toast.setGravity(Gravity.BOTTOM | Gravity.LEFT, 0, 0);
			toast.show();
		}
	}

	/**
	 * 屏幕底部右边位置长时间显示Toast
	 * @param message
	 */
	public static void ToastLongBottomRight( String message) {
		if (mContext != null) {

			Toast toast = Toast.makeText(mContext, message, Toast.LENGTH_LONG);
			toast.setGravity(Gravity.BOTTOM | Gravity.RIGHT, 0, 0);
			toast.show();
		}
	}

	/**
	 * 屏幕中心位置长时间显示Toast
	 * @param message
	 */
	public static void ToastLongCenter( String message) {
		if (mContext != null) {
			Toast toast = Toast.makeText(mContext, message, Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
		}
	}

	/**
	 * 屏幕中心左边位置长时间显示Toast
	 * @param message
	 */
	public static void ToastLongCenterLeft( String message) {
		if (mContext != null) {

			Toast toast = Toast.makeText(mContext, message, Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER | Gravity.LEFT, 0, 0);
			toast.show();
		}
	}

	/**
	 * 屏幕中心右边位置短时间显示Toast
	 * @param message
	 */
	public static void ToastLongCenterRight( String message) {
		if (mContext != null) {

			Toast toast = Toast.makeText(mContext, message, Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER | Gravity.RIGHT, 0, 0);
			toast.show();
		}
	}

	/**
	 * 屏幕顶部中心位置长时间显示Toast
	 * @param message
	 */
	public static void ToastLongTopCenter( String message) {
		if (mContext != null) {

			Toast toast = Toast.makeText(mContext, message, Toast.LENGTH_LONG);
			toast.setGravity(Gravity.TOP, 0, 0);
			toast.show();
		}
	}

	/**
	 * 屏幕顶部左边位置长时间显示Toast
	 * @param message
	 */
	public static void ToastLongTopLeft( String message) {
		if (mContext != null) {

			Toast toast = Toast.makeText(mContext, message, Toast.LENGTH_LONG);
			toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);
			toast.show();
		}
	}

	/**
	 * 屏幕顶部右边位置长时间显示Toast
	 *
	 * @param message
	 */
	public static void ToastLongTopRight( String message) {
		if (mContext != null) {

			Toast toast = Toast.makeText(mContext, message, Toast.LENGTH_LONG);
			toast.setGravity(Gravity.TOP | Gravity.RIGHT, 0, 0);
			toast.show();
		}
	}


}
