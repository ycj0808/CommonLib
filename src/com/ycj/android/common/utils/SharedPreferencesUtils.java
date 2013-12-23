package com.ycj.android.common.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @ClassName: SharedPreferencesUtils
 * @Description: TODO(手机存储简单信息的工具类)
 * @author yangchj
 * @date 2013年9月16日 下午8:03:13
 * 使用说明：在程序中调用SharedPreferencesUtils.getInstance(context)+方法名即可
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
