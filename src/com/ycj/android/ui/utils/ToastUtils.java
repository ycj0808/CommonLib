package com.ycj.android.ui.utils;

import android.app.Activity;
import android.os.Looper;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * ��Toast�෽���ķ�װ
 * 
 * @author yangchj
 * @date 2013-12-18 ����10:47:37
 */
public class ToastUtils {

	/**
	 * ��ʾ����ʾ�ķ���(ȫ��)
	 * 
	 * @param isThread
	 *            �Ƿ������߳�
	 * @param activity
	 *            ��ǰ����ҳ���Activity
	 * @param Msg
	 *            ��ʾ��Ϣ������
	 * @param TimeOut
	 *            ҳ����ʾͣ����ʱ�䣡�磺Toast.{*} �� �Զ�����
	 * @param Gravity
	 *            ��ʾ��λ�ã��磺Gravity.{*}
	 * @param xOffset
	 *            ˮƽX���λ��
	 * @param yOffset
	 *            ˮƽY���λ��
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
	 * ��ʾ����ʾ�ķ���(��Ĭ��)|�����̰߳�ȫ
	 * 
	 * @param isThread
	 *            �Ƿ������߳�
	 * @param activity
	 *            ��ǰ����ҳ���Activity
	 * @param Msg
	 *            ��ʾ��Ϣ������
	 * @param TimeOut
	 *            ҳ����ʾͣ����ʱ�䣡�磺Toast.{*} �� �Զ�����
	 */
	public static void Show(boolean IsThread, Activity activity, String Msg,
			int TimeOut) {
		Show(IsThread, activity, Msg, TimeOut, Gravity.BOTTOM, 0, 0);
	}

	/**
	 * ��ʾ����ʾ�ķ���(�Զ���λ��)|�����̰߳�ȫ
	 * 
	 * @param isThread
	 *            �Ƿ������߳�
	 * @param activity
	 *            ��ǰ����ҳ���Activity
	 * @param Msg
	 *            ��ʾ��Ϣ������
	 * @param TimeOut
	 *            ҳ����ʾͣ����ʱ�䣡�磺Toast.{*} �� �Զ�����
	 * @param Gravity
	 *            ��ʾ��λ�ã��磺Gravity.{*}
	 */
	public static void Show(boolean IsThread, Activity activity, String Msg,
			int TimeOut, int Gravity) {
		Show(IsThread, activity, Msg, TimeOut, Gravity, 0, 0);
	}

	/**
	 * ��ʾ����ʾ�ķ���(�Զ�����ͼ)|�����̰߳�ȫ
	 * 
	 * @param isThread
	 *            �Ƿ������߳�
	 * @param activity
	 *            ��ǰ����ҳ���Activity
	 * @param view
	 *            ��ʾ��Ϣ������
	 * @param TimeOut
	 *            ҳ����ʾͣ����ʱ�䣡�磺Toast.{*} �� �Զ�����
	 * @param Gravity
	 *            ��ʾ��λ�ã��磺Gravity.{*}
	 * @param xOffset
	 *            ˮƽX���λ��
	 * @param yOffset
	 *            ˮƽY���λ��
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
	 * ��ʾToast,ֱ�Ӵ����ַ���
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
	 * ��ʾToast,����������Դ�ļ�
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
	 * ��ʾToast
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
	 * ��ʾ�Զ����Toast
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
	 * ��ʾ����ͼƬ�����ֵ�Toast
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
	  * @Title: �Զ�����ʾͼƬ������
	  * @Description: TODO
	  * @param @param activity
	  * @param @param view
	  * @param @param content
	  * @param @param gravity    �趨�ļ�
	  * @return void    ��������
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
