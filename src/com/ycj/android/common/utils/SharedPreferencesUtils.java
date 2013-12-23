package com.ycj.android.common.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @ClassName: SharedPreferencesUtils
 * @Description: TODO(�ֻ��洢����Ϣ�Ĺ�����)
 * @author yangchj
 * @date 2013��9��16�� ����8:03:13
 * ʹ��˵�����ڳ����е���SharedPreferencesUtils.getInstance(context)+����������
 */
public class SharedPreferencesUtils {

	private static SharedPreferencesUtils myPreference;
	private SharedPreferences sharedPreference=null; 
	private String packageName = "";
	public SharedPreferencesUtils(Context context) {
		 packageName ="FirstPreferences"; 
		 sharedPreference = context.getSharedPreferences(packageName, context.MODE_PRIVATE);
	}
	public static synchronized SharedPreferencesUtils getInstance(Context context){  
        if(myPreference == null)  
        	myPreference = new SharedPreferencesUtils(context);  
        return myPreference;  
 }  
}
