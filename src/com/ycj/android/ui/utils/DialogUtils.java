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
 * 显示对话框的工具类
 * @author yangchj
 * @date 2013-12-18 上午10:50:00
 */
public class DialogUtils {

	/**
	 * 普通对话框
	 * @param context  上下文对象
	 * @param Title  标题
	 * @param Msg 提示的内容
	 * @param Ico 显示的资源图标
	 */
	public static void Show(Context context, String Title, String Msg, int Ico) {
		Builder ad = new AlertDialog.Builder(context).setTitle(Title).setMessage(Msg).setIcon(Ico);
		ad.setCancelable(false);
		Dialog alert = ad.create();
		alert.show();
	}
	
	/**
	 *  列表显示的对话框
	 *  
	  * @param context  上下文对象
	 * @param Title  标题
	 * @param Ico 显示的资源图标
	 * @param Array_Frut  选项列表集合
	 * @param onClick 选择列表的事件
	 */
	public static void Show(Context context,String Title,int Ico,String[] Array_Frut,DialogInterface.OnClickListener onClick)
	{
		Builder ad = new AlertDialog.Builder(context).setTitle(Title).setItems(Array_Frut,onClick).setIcon(Ico);
		ad.setCancelable(false);
		Dialog alert = ad.create();
		alert.show();
	}
	  
	/**
	 * 带按钮的对话框
	 * 
	 * @param context  上下文对象
	 * @param Title  标题
	 * @param Msg 提示的内容
	 * @param Ico 显示的资源图标
	 * @param onClick 按钮集合(最多可显示3个按钮)
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
