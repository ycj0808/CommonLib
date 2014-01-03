package com.ycj.android.common.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetUtils {
	/**
	  * @Title: �ж��Ƿ�����������
	  * @Description: TODO
	  * @param     context
	  * @param     �趨�ļ�
	  * @return boolean    ��������
	  * @throws
	  */
	public static boolean isNetWorkConnected(Context context){
		if(context!=null){
			ConnectivityManager mConnectivityManager=(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mNetworkInfo=mConnectivityManager.getActiveNetworkInfo();
			if(mNetworkInfo!=null){
				return mNetworkInfo.isAvailable();
			}
		}
		return false;
	}
	/**
	  * @Title: �ж�WIFI�����Ƿ����
	  * @Description: TODO
	  * @param     context
	  * @param     �趨�ļ�
	  * @return boolean    ��������
	  * @throws
	  */
	public static boolean isWifiConnected(Context context) {  
	    if (context != null) {  
	        ConnectivityManager mConnectivityManager = (ConnectivityManager) context  
	                .getSystemService(Context.CONNECTIVITY_SERVICE);  
	        NetworkInfo mWiFiNetworkInfo = mConnectivityManager  
	                .getNetworkInfo(ConnectivityManager.TYPE_WIFI);  
	        if (mWiFiNetworkInfo != null) {  
	            return mWiFiNetworkInfo.isAvailable();  
	        }  
	    }  
	    return false;  
	}
	/**
	  * @Title: �ж�MOBILE�����Ƿ����
	  * @Description: TODO
	  * @param @param context
	  * @param @return    �趨�ļ�
	  * @return boolean    ��������
	  * @throws
	 */
	public static boolean isMobileConnected(Context context) {  
	    if (context != null) {  
	        ConnectivityManager mConnectivityManager = (ConnectivityManager) context  
	                .getSystemService(Context.CONNECTIVITY_SERVICE);  
	        NetworkInfo mMobileNetworkInfo = mConnectivityManager  
	                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);  
	        if (mMobileNetworkInfo != null) {  
	            return mMobileNetworkInfo.isAvailable();  
	        }  
	    }  
	    return false;  
	}
	/**
	  * @Title: ��ȡ��ǰ�������ӵ�������Ϣ
	  * ��ȡ��ǰ������״̬  -1��û������  1��WIFI����2��wap����3��net����
	  * @Description: TODO
	  * @param @param context
	  * @param @return    �趨�ļ�
	  * @return int    ��������
	  * @throws
	  */
	public static int getConnectedType(Context context) {  
	    if (context != null) {  
	        ConnectivityManager mConnectivityManager = (ConnectivityManager) context  
	                .getSystemService(Context.CONNECTIVITY_SERVICE);  
	        NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();  
	        if (mNetworkInfo != null && mNetworkInfo.isAvailable()) {  
	            return mNetworkInfo.getType();  
	        }  
	    }  
	    return -1;  
	}
	
}



















