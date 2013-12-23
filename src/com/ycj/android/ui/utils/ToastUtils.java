package com.ycj.android.ui.utils;
import android.app.Activity;
import android.os.Looper;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

/**
 * ��Toast�෽���ķ�װ
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
	public static void Show(boolean IsThread, Activity activity, String Msg,int TimeOut) {
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
	public static void Show(boolean IsThread, Activity activity, String Msg,int TimeOut, int Gravity) {
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
