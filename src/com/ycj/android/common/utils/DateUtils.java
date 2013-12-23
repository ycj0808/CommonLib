package com.ycj.android.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
	public static String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
	
	/**
	 * @Title: stringDate
	 * @Description: TODO(������ת��Ϊyyyy-MM-dd��ʽ�ַ���)
	 * @return String    ��������
	 * @throws
	 */
	public static String stringDate(Date date){
		if(date==null){
			return "";
		}else{
			return dateFormat.format(date);
		}
	}
	/**
	 * @Title: stringDate
	 * @Description: TODO(������ת��Ϊָ����ʽ�ַ���)
	 * @return String    ��������
	 * @throws
	 */
	public static String stringDate(Date date,String format){
		if(date==null){
			return "";
		}else{
			SimpleDateFormat df=new SimpleDateFormat(format);
			return df.format(date);
		}
	}
	/**
	 * @Title: dateString
	 * @Description: TODO(���̶���ʽ�ַ���ת��Ϊyyyy-MM-dd)
	 * @return Date    ��������
	 * @throws
	 */
	public static Date dateString(String strDate){
		try {
			return dateFormat.parse(strDate);
		} catch (ParseException e) {
			return null;
		}
	}
	/**
	 * ��ȡϵͳʱ��
	 * @param format
	 * @return
	 */
	public static String getNowTime(String format) {
		String result = "";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date curDate = new Date(System.currentTimeMillis()); // ��ȡ��ǰʱ��
		result = sdf.format(curDate);
		return result;
	}
}
