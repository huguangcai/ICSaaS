package com.ysxsoft.icsaas.common_base.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.util.Timer;
import java.util.TimerTask;

public class KeyBoardUtils {

	/**
	 * 关闭软键盘
	 *
	 * @param mContext
	 * @param view
	 */
	public static void colseKeyboard(Context mContext, View view) {
		try {
			InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
		} catch (Exception e) {
		}
	}

	/**
	 * 关闭手机软件盘
	 *
	 * @param activity
	 */
	public static void colsePhoneKeyboard(Activity activity) {
		InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
		if (imm.isActive() && activity.getCurrentFocus() != null) {
			if (activity.getCurrentFocus().getWindowToken() != null) {
				imm.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
			}
		}
	}

	/**
	 * 打开软件盘
	 *
	 * @param mContext
	 */
	public static void openKeyboard(Context mContext) {
		InputMethodManager inputMethodManager = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
		inputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
	}

	/**
	 * 打开软键盘
	 *
	 * @param mEditText  输入框
	 * @param mContext   上下文
	 */
	public static void openKeybord(EditText mEditText, Context mContext)
	{
		InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.showSoftInput(mEditText, InputMethodManager.RESULT_SHOWN);
		imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
	}

	/**
	 * 关闭软键盘
	 *
	 * @param mEditText 输入框
	 * @param mContext  上下文
	 */
	public static void closeKeybord(EditText mEditText, Context mContext) {
		InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
	}

	/**
	 * 通过定时器强制隐藏虚拟键盘
	 */
	public static void TimerHideKeyboard(final View v) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
				if (imm.isActive()) {
					imm.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);
				}
			}
		}, 10);
	}

	/**
	 * 输入法是否显示
	 */
	public static boolean KeyBoard(EditText edittext) {
		boolean bool = false;
		InputMethodManager imm = (InputMethodManager) edittext.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
		if (imm.isActive()) {
			bool = true;
		}
		return bool;
	}
	/**
	 * 切换软键盘的状态
	 * 如当前为收起变为弹出,若当前为弹出变为收起
	 */
	public static void toggleKeybord(EditText edittext) {
		InputMethodManager inputMethodManager = (InputMethodManager)
				edittext.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
		inputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
	}

	/**
	 * 强制隐藏输入法键盘
	 */
	public static void hideKeybord(EditText edittext) {
		InputMethodManager inputMethodManager = (InputMethodManager)
				edittext.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
		if (inputMethodManager.isActive()) {
			inputMethodManager.hideSoftInputFromWindow(edittext.getWindowToken(), 0);
		}
	}

	/**
	 * 强制显示输入法键盘
	 */
	public static void showKeybord(EditText edittext) {
		InputMethodManager inputMethodManager = (InputMethodManager)
				edittext.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
		inputMethodManager.showSoftInput(edittext, InputMethodManager.SHOW_FORCED);
	}

	public static void showKeyBord(Context context){
		InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
	}

	/**
	 * 输入法是否显示
	 */
	public static boolean isKeybord(EditText edittext) {
		boolean bool = false;
		InputMethodManager inputMethodManager = (InputMethodManager)
				edittext.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
		if (inputMethodManager.isActive()) {
			bool = true;
		}
		return bool;
	}

	/**
	 * 隐藏输入法
	 *
	 * @param mAct activity
	 */
	public static void hideInputMethod(Activity mAct) {
		try {// hide keybord anyway
			View v = mAct.getWindow().getCurrentFocus();
			if (v != null) {
				InputMethodManager imm = (InputMethodManager) mAct.getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
			}
		} catch (Exception e) {
		}
	}

	/**
	 * 显示输入法
	 *
	 * @param mAct activity
	 */
	public static void showInputMethod( Activity mAct) {
		View v = mAct.getCurrentFocus();
		if (null == v) {
			return;
		}
		((InputMethodManager) mAct.getSystemService(Activity.INPUT_METHOD_SERVICE)).showSoftInput(v, 0);
	}

}
