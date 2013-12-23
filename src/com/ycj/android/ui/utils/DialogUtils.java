package com.ycj.android.ui.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;

/**
 * ��ʾ�Ի���Ĺ�����
 * @author yangchj
 * @date 2013-12-18 ����10:50:00
 */
public class DialogUtils {

	/**
	 * ��ͨ�Ի���
	 * @param context  �����Ķ���
	 * @param Title  ����
	 * @param Msg ��ʾ������
	 * @param Ico ��ʾ����Դͼ��
	 */
	public static void Show(Context context, String Title, String Msg, int Ico) {
		Builder ad = new AlertDialog.Builder(context).setTitle(Title).setMessage(Msg).setIcon(Ico);
		ad.setCancelable(false);
		Dialog alert = ad.create();
		alert.show();
	}
	
	/**
	 *  �б���ʾ�ĶԻ���
	 *  
	  * @param context  �����Ķ���
	 * @param Title  ����
	 * @param Ico ��ʾ����Դͼ��
	 * @param Array_Frut  ѡ���б���
	 * @param onClick ѡ���б���¼�
	 */
	public static void Show(Context context,String Title,int Ico,String[] Array_Frut,DialogInterface.OnClickListener onClick)
	{
		Builder ad = new AlertDialog.Builder(context).setTitle(Title).setItems(Array_Frut,onClick).setIcon(Ico);
		ad.setCancelable(false);
		Dialog alert = ad.create();
		alert.show();
	}
	  
	/**
	 * ����ť�ĶԻ���
	 * 
	 * @param context  �����Ķ���
	 * @param Title  ����
	 * @param Msg ��ʾ������
	 * @param Ico ��ʾ����Դͼ��
	 * @param onClick ��ť����(������ʾ3����ť)
	 */
	public static void Show(Context context, String Title, String Msg,int Ico,HashMap<String, DialogInterface.OnClickListener> onClick) {
		Builder ad =new AlertDialog.Builder(context).setTitle(Title).setMessage(Msg).setIcon(Ico);
		Iterator<Entry<String, DialogInterface.OnClickListener>> ite = onClick.entrySet().iterator();
		Entry<String, DialogInterface.OnClickListener> entry;
		int i=1;
		while (ite.hasNext()) {
			entry = ite.next();
			if (i==1)
				ad.setPositiveButton(entry.getKey().toString(), entry.getValue());
			else if (i==2)
				ad.setNegativeButton(entry.getKey().toString(), entry.getValue());
			else
				ad.setNeutralButton(entry.getKey().toString(), entry.getValue());
			i++;
		}
		ad.setCancelable(false); 
		Dialog alert = ad.create();
		alert.show();
	}
}
