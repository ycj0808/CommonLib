package com.ycj.android.ui.utils;
import android.app.Activity;
import android.os.Looper;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

/**
 * 对Toast类方法的封装
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
	public static void Show(boolean IsThread, Activity activity, String Msg,int TimeOut, int Gravity, int xOffset, int yOffset) {
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
	public static void Show(boolean IsThread, Activity activity, String Msg,int TimeOut) {
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
	public static void Show(boolean IsThread, Activity activity, String Msg,int TimeOut, int Gravity) {
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
	public static void Show(boolean IsThread, Activity activity, View view,int TimeOut, int Gravity, int xOffset, int yOffset) {
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
}
