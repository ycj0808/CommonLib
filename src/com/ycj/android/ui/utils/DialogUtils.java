package com.ycj.android.ui.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

/**
 * ��ʾ�Ի���Ĺ�����
 * @author yangchj
 * @date 2013-12-18 ����10:50:00
 */
@SuppressLint("NewApi")
public class DialogUtils {

	/**
     * Show Alert Dialog with resource id.
     * @param context Activity context.
     * @param titleId title id
     * @param messageId message id
     */
    @SuppressLint("NewApi")
	public static void showAlert(Context context, int titleId, int messageId) {
        Dialog dlg = new AlertDialog.Builder(context)
            .setIconAttribute(android.R.attr.alertDialogIcon)
            .setTitle(titleId)
            .setPositiveButton(android.R.string.ok, null)
            .setMessage(messageId)
            .create();
        dlg.show();
    }
	
    /**
     * Show Alert Dialog with String text.
     * @param context Activity context.
     * @param title Title
     * @param message Message
     */
    @SuppressLint("NewApi")
	public static void showAlert(Context context, String title, String message) {
        Dialog dlg = new AlertDialog.Builder(context)
            .setIconAttribute(android.R.attr.alertDialogIcon)
            .setTitle(title)
            .setPositiveButton(android.R.string.ok, null)
            .setMessage(message)
            .create();
        
        dlg.show();
    }
    
    
    /**
     * Show Alert Dialog with two buttons.
     * @param context
     * @param titleId
     * @param messageId
     * @param positiveButtontxt
     * @param positiveListener
     * @param negativeButtontxt
     * @param negativeListener
     */
    public static void showAlert(Context context, int titleId, int messageId,
            CharSequence positiveButtontxt, DialogInterface.OnClickListener positiveListener,
            CharSequence negativeButtontxt, DialogInterface.OnClickListener negativeListener) {
        Dialog dlg = new AlertDialog.Builder(context)
            .setIconAttribute(android.R.attr.alertDialogIcon)
            .setTitle(titleId)
            .setPositiveButton(positiveButtontxt, positiveListener)
            .setNegativeButton(negativeButtontxt, negativeListener)
            .setMessage(messageId)
            .setCancelable(false)
            .create();
        dlg.show();
    }
    
    /**
     * Show Alert Dialog with positive button.
     * @param context
     * @param titleId
     * @param messageId
     * @param positiveButtontxt
     * @param positiveListener
     */
    public static void showAlert(Context context, int titleId, int messageId,
            CharSequence positiveButtontxt, DialogInterface.OnClickListener positiveListener) {
        Dialog dlg = new AlertDialog.Builder(context)
            .setIconAttribute(android.R.attr.alertDialogIcon)
            .setTitle(titleId)
            .setPositiveButton(positiveButtontxt, positiveListener)
            .setMessage(messageId)
            .setCancelable(false)
            .create();
        
        dlg.show();
    }
    
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
	/**
	  * @Title: �Զ���Ĵ���������dialog
	  * @Description: TODO
	  * @param @param mContext
	  * @param @param view
	  * @param @return    �趨�ļ�
	  * @return Dialog    ��������
	  * @throws
	 */
	public static Dialog showProgressBar(Context mContext,View view){
		Dialog  mDialog = new AlertDialog.Builder(mContext).create();
		mDialog.setCanceledOnTouchOutside(false);
    	mDialog.show();
    	mDialog.setContentView(view);
    	return mDialog;
	}
}
