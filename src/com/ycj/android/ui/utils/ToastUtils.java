package com.ycj.android.ui.utils;

import android.app.Activity;
import android.os.Looper;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * 对Toast类方法的封装
 * 
 * @author yangchj
 * @date 2013-12-18 上午10:47:37
 */
public class ToastUtils {

	/**
	 * 显示对提示的方法(全部)
	 * 
	 * @param isThread
	 *            是否用于线程
	 * @param activity
	 *            当前请求页面的Activity
	 * @param Msg
	 *            提示信息的内容
	 * @param TimeOut
	 *            页面显示停留的时间！如：Toast.{*} 或 自定义秒
	 * @param Gravity
	 *            显示的位置！如：Gravity.{*}
	 * @param xOffset
	 *            水平X轴的位置
	 * @param yOffset
	 *            水平Y轴的位置
	 */
	public static void Show(boolean IsThread, Activity activity, String Msg,
			int TimeOut, int Gravity, int xOffset, int yOffset) {
		if (IsThread)
			Looper.prepare();
		Toast toast = Toast.makeText(activity, Msg, TimeOut);
		toast.setGravity(Gravity, xOffset, yOffset);
		toast.show();
		if (IsThread)
			Looper.loop();
	}

	/**
	 * 显示对提示的方法(简单默认)|处理线程安全
	 * 
	 * @param isThread
	 *            是否用于线程
	 * @param activity
	 *            当前请求页面的Activity
	 * @param Msg
	 *            提示信息的内容
	 * @param TimeOut
	 *            页面显示停留的时间！如：Toast.{*} 或 自定义秒
	 */
	public static void Show(boolean IsThread, Activity activity, String Msg,
			int TimeOut) {
		Show(IsThread, activity, Msg, TimeOut, Gravity.BOTTOM, 0, 0);
	}

	/**
	 * 显示对提示的方法(自定义位置)|处理线程安全
	 * 
	 * @param isThread
	 *            是否用于线程
	 * @param activity
	 *            当前请求页面的Activity
	 * @param Msg
	 *            提示信息的内容
	 * @param TimeOut
	 *            页面显示停留的时间！如：Toast.{*} 或 自定义秒
	 * @param Gravity
	 *            显示的位置！如：Gravity.{*}
	 */
	public static void Show(boolean IsThread, Activity activity, String Msg,
			int TimeOut, int Gravity) {
		Show(IsThread, activity, Msg, TimeOut, Gravity, 0, 0);
	}

	/**
	 * 显示对提示的方法(自定义视图)|处理线程安全
	 * 
	 * @param isThread
	 *            是否用于线程
	 * @param activity
	 *            当前请求页面的Activity
	 * @param view
	 *            提示信息的内容
	 * @param TimeOut
	 *            页面显示停留的时间！如：Toast.{*} 或 自定义秒
	 * @param Gravity
	 *            显示的位置！如：Gravity.{*}
	 * @param xOffset
	 *            水平X轴的位置
	 * @param yOffset
	 *            水平Y轴的位置
	 */
	public static void Show(boolean IsThread, Activity activity, View view,
			int TimeOut, int Gravity, int xOffset, int yOffset) {
		if (IsThread)
			Looper.prepare();
		Toast toast = new Toast(activity);
		toast.setGravity(Gravity, xOffset, yOffset);
		toast.setDuration(TimeOut);
		toast.setView(view);
		toast.show();
		if (IsThread)
			Looper.loop();
	}

	/**
	 * 显示Toast,直接传入字符串
	 * 
	 * @param activity
	 * @param content
	 */
	public static void showToast(final Activity activity, final String content) {
		/*
		 * activity.runOnUiThread(new Runnable() {
		 * 
		 * @Override public void run() { Toast toast = Toast.makeText(activity,
		 * content, Toast.LENGTH_SHORT); toast.show(); } });
		 */
		showToast(activity, content, Gravity.CENTER, 0, 0);
	}

	/**
	 * 显示Toast,内容来自资源文件
	 * 
	 * @param activity
	 * @param resId
	 */
	public static void showToast(final Activity activity, final int resId) {
		/*
		 * activity.runOnUiThread(new Runnable() {
		 * 
		 * @Override public void run() { Toast toast = Toast.makeText(activity,
		 * activity.getString(resId), Toast.LENGTH_SHORT); toast.show(); } });
		 */
		showToast(activity, activity.getString(resId), Gravity.CENTER, 0, 0);
	}

	/**
	 * 显示Toast
	 * 
	 * @param activity
	 * @param content
	 * @param gravity
	 * @param xOffset
	 * @param yOffset
	 */
	public static void showToast(final Activity activity, final String content,
			final int gravity, final int xOffset, final int yOffset) {
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				Toast toast = Toast.makeText(activity, content,
						Toast.LENGTH_SHORT);
				toast.setGravity(gravity, xOffset, yOffset);
				toast.show();
			}
		});
	}

	/**
	 * 显示自定义的Toast
	 * 
	 * @param activity
	 * @param view
	 * @param content
	 * @param gravity
	 * @param xOffset
	 * @param yOffset
	 */
	public static void showToast(final Activity activity, final View view,
			final String content, final int gravity, final int xOffset,
			final int yOffset) {
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				Toast toast = Toast.makeText(activity, content,
						Toast.LENGTH_SHORT);
				toast.setGravity(gravity, xOffset, yOffset);
				toast.setView(view);
				toast.show();
			}
		});
	}

	/**
	 * 显示带有图片及文字的Toast
	 * 
	 * @param activity
	 * @param view
	 * @param content
	 * @param gravity
	 * @param xOffset
	 * @param yOffset
	 */
	public static void showToast(final Activity activity, final ImageView view,
			final String content, final int gravity, final int xOffset,
			final int yOffset) {
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				Toast toast = Toast.makeText(activity, content,
						Toast.LENGTH_SHORT);
				toast.setGravity(gravity, xOffset, yOffset);
				LinearLayout toastView = (LinearLayout) toast.getView();
				toastView.addView(view, 0);
				toast.show();
			}
		});
	}
	/**
	  * @Title: 自定义显示图片和文字
	  * @Description: TODO
	  * @param @param activity
	  * @param @param view
	  * @param @param content
	  * @param @param gravity    设定文件
	  * @return void    返回类型
	  * @throws
	  */
	public static void showToast(final Activity activity, final ImageView view,
			final String content, int gravity) {
		Toast toast = Toast.makeText(activity, content, Toast.LENGTH_SHORT);
		toast.setGravity(gravity, 0, 0);
		LinearLayout toastView = (LinearLayout) toast.getView();
		toastView.addView(view, 0);
		toast.show();
	}
}
