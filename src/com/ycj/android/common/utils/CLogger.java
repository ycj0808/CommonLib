﻿package com.ycj.android.common.utils;

import java.util.Hashtable;

import android.util.Log;
/**
 * @ClassName: CLogger
 * @Description: TODO(对android中打印日志的封装类)
 * @author yangchj
 * @date 2013-5-3 上午9:17:15
 */
public class CLogger  {
	
	private final static boolean logFlag = true;  
    public final static String tag = "[AppName]";  
    private final static int logLevel = Log.VERBOSE;  
    private static Hashtable<String, CLogger> sLoggerTable = new Hashtable<String, CLogger>();  
    private String  mClassName;   
    private static CLogger ylog;  
    private static final String  YCHJ = "@yangchj@ ";  
    private CLogger(String name)  
    {  
        mClassName = name;  
    }  
      
    /** 
     *  
     * @param className 
     * @return 
     */  
    @SuppressWarnings("unused")  
    private static CLogger getLogger(String className)  
    {  
    	CLogger classLogger = (CLogger) sLoggerTable.get(className);  
        if(classLogger == null)  
        {  
            classLogger = new CLogger(className);  
            sLoggerTable.put(className, classLogger);  
        }  
        return classLogger;  
    }  
      
    /** 
     * Purpose:Mark user two 
     * @return 
     */  
    public static CLogger yLog()  
    {  
        if(ylog == null)  
        {  
            ylog = new CLogger(YCHJ);  
        }  
        return ylog;  
    }  
      
    /** 
     * Get The Current Function Name 
     * @return 
     */  
    private String getFunctionName()  
    {  
        StackTraceElement[] sts = Thread.currentThread().getStackTrace();  
        if(sts == null)  
        {  
            return null;  
        }  
        for(StackTraceElement st : sts)  
        {  
            if(st.isNativeMethod())  
            {  
                continue;  
            }  
            if(st.getClassName().equals(Thread.class.getName()))  
            {  
                continue;  
            }  
            if(st.getClassName().equals(this.getClass().getName()))  
            {  
                continue;  
            }  
            return mClassName + "[ " + Thread.currentThread().getName() + ": "  
                    + st.getFileName() + ":" + st.getLineNumber() + " "  
                    + st.getMethodName() + " ]";  
        }  
        return null;  
    }  
      
    /** 
     * The Log Level:i 
     * @param str 
     */  
    public void i(Object str)  
    {  
        if(logFlag)  
        {  
            if(logLevel <= Log.INFO)  
            {  
                String name = getFunctionName();  
                if(name != null)  
                {  
                    Log.i(tag, name + " - " + str);  
                }  
                else  
                {  
                    Log.i(tag, str.toString());  
                }  
            }  
        }  
          
    }  
      
    /** 
     * The Log Level:d 
     * @param str 
     */  
    public void d(Object str)  
    {  
        if(logFlag)  
        {  
            if(logLevel <= Log.DEBUG)  
            {  
                String name = getFunctionName();  
                if(name != null)  
                {  
                    Log.d(tag, name + " - " + str);  
                }  
                else  
                {  
                    Log.d(tag, str.toString());  
                }  
            }  
        }  
    }  
      
    /** 
     * The Log Level:V 
     * @param str 
     */  
    public void v(Object str)  
    {  
        if(logFlag)  
        {  
            if(logLevel <= Log.VERBOSE)  
            {  
                String name = getFunctionName();  
                if(name != null)  
                {  
                    Log.v(tag, name + " - " + str);  
                }  
                else  
                {  
                    Log.v(tag, str.toString());  
                }  
            }  
        }  
    }  
      
    /** 
     * The Log Level:w 
     * @param str 
     */  
    public void w(Object str)  
    {  
        if(logFlag)  
        {  
            if(logLevel <= Log.WARN)  
            {  
                String name = getFunctionName();  
                if(name != null)  
                {  
                    Log.w(tag, name + " - " + str);  
                }  
                else  
                {  
                    Log.w(tag, str.toString());  
                }  
            }  
        }  
    }  
      
    /** 
     * The Log Level:e 
     * @param str 
     */  
    public void e(Object str)  
    {  
        if(logFlag)  
        {  
            if(logLevel <= Log.ERROR)  
            {  
                String name = getFunctionName();  
                if(name != null)  
                {  
                    Log.e(tag, name + " - " + str);  
                }  
                else  
                {  
                    Log.e(tag, str.toString());  
                }  
            }  
        }  
    }  
      
    /** 
     * The Log Level:e 
     * @param ex 
     */  
    public void e(Exception ex)  
    {  
        if(logFlag)  
        {  
            if(logLevel <= Log.ERROR)  
            {  
                Log.e(tag, "error", ex);  
            }  
        }  
    }  
      
    /** 
     * The Log Level:e 
     * @param log 
     * @param tr 
     */  
    public void e(String log, Throwable tr)  
    {  
        if(logFlag)  
        {  
            String line = getFunctionName();  
            Log.e(tag, "{Thread:" + Thread.currentThread().getName() + "}"  
                    + "[" + mClassName + line + ":] " + log + "\n", tr);  
        }  
    }  
}
