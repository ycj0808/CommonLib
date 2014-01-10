package com.ycj.android.common.utils;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * @ClassName: CommonUtils
 * @Description: TODO(����������)
 * @author yangchj
 * @date 2013-9-15 ����9:16:50
 * 1.��Map�Ĳ���
 * 2.���ַ�������ֵ������ת��
 * 3.��ȡUUID
 */
public class CommonUtils {

	/**
	 * @Title: mapHasValue
	 * @Description: TODO(�ж�Map���Ƿ����Key)
	 * @return boolean    ��������
	 * @throws
	 */
	public static boolean mapHasValue(Map paramMap, String key){
		boolean flag=false;
		if(paramMap!=null&&paramMap.containsKey("key")&&!paramMap.get(key).toString().equals("")){
			flag=true;
		}
		return flag;
	}
	/**
	 * @Title: mapEquValue
	 * @Description: TODO(�ж�Map��Keyֵ����Value)
	 * @return boolean    ��������
	 * @throws
	 */
	public boolean mapEquValue(Map paramMap, String key, String value){
		boolean flag=false;
		if(mapHasValue(paramMap, key)&&paramMap.get(key).toString().equalsIgnoreCase(value)){
			flag=true;
		}
		return flag;
	}
	/**
	 * @Title: mapUnequValue
	 * @Description: TODO(�ж�Map��Keyֵ������Value)
	 * @return boolean    ��������
	 * @throws
	 */
	public boolean mapUnequValue(Map paramMap, String key, String value){
		boolean flag=false;
		if(mapHasValue(paramMap, key)&&!mapEquValue(paramMap,key,value)){
			flag=true;
		}
		return flag;
	}
	/**
	 * @Title: getValByKey
	 * @Description: TODO(ȡMap�е�ֵ)
	 * @return String    ��������
	 * @throws
	 */
	public String getValByKey(Map paramMap, String key) {
		return mapHasValue(paramMap, key)?paramMap.get(key).toString():"";
	}
	
	/**
	 * �ַ���ת��Ϊ����
	 * 
	 * @param value
	 *            ��Ҫת�����ַ���
	 * @param defaultValue
	 *            ת�ﻻʧ��ʱ�����ֵ
	 * @return ת���������
	 */
	public static int strToInt(String value, int defaultValue) {
		try {
			return Integer.valueOf(value);
		} catch (Exception e) {
			return defaultValue;
		}
	}
	
	/**
	 * �ַ���ת��Ϊ������
	 * 
	 * @param value
	 *            ��Ҫת�����ַ���
	 * @param defaultValue
	 *            ת�ﻻʧ��ʱ�����ֵ
	 * @return ת���������
	 */
	public static long strToInt(String value, long defaultValue) {
		try {
			return Long.valueOf(value);
		} catch (Exception e) {
			return defaultValue;
		}
	}
	
	/**
	 * ת��16�����ַ���Ϊ����
	 * 
	 * @param value
	 *            ��Ҫת�����ַ���
	 * @param defaultValue
	 *            ת�ﻻʧ��ʱ�����ֵ
	 * @return ת���������
	 */
	public static int hexToInt(String value, int defaultValue) {
		try {
			return Integer.parseInt(value, 16);
		} catch (Exception e) {
			return defaultValue;
		}
	}
	
	/**
	 * ת��16�����ַ���Ϊ������
	 * 
	 * @param value
	 *            ��Ҫת�����ַ���
	 * @param defaultValue
	 *            ת�ﻻʧ��ʱ�����ֵ
	 * @return ת���������
	 */
	public static long hexToInt(String value, long defaultValue) {
		try {
			return Long.parseLong(value, 16);
		} catch (Exception e) {
			return defaultValue;
		}
	}
	
	/**
	 * ת��Ϊ��������
	 * 
	 * @param value
	 *            ��Ҫת�����ַ���
	 * @param defaultValue
	 *            ת�ﻻʧ��ʱ�����ֵ
	 * @return ת���������
	 */
	public static float strToFloat(String value, float defaultValue) {
		try {
			return Float.valueOf(value);
		} catch (Exception e) {
			return defaultValue;
		}
	}
	
	/**
	 * ת��Ϊ��������
	 * 
	 * @param value
	 *            ��Ҫת�����ַ���
	 * @param defaultValue
	 *            ת�ﻻʧ��ʱ�����ֵ
	 * @return ת���������
	 */
	public static double strToDouble(String value, double defaultValue) {
		try {
			return Double.valueOf(value);
		} catch (Exception e) {
			return defaultValue;
		}
	}
	
	/**
	 * ��������GUID
	 * 
	 * @return ����GUID
	 */
	public static String getGUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * ����nλα�����(n���ֵΪ128)
	 * 
	 * @param strLength
	 * @return
	 */
	public String getFixLenthString(int n) {
		String res = "NaN";
		if (n < 129) {
			n++;
			Random rm = new Random();
			BigDecimal pross = new BigDecimal((1 + rm.nextDouble())
					* Math.pow(10, n));
			String fixLenthString = String.valueOf(pross);
			res = fixLenthString.substring(2, n + 1);
		}
		return res;
	}
	
	
	
}
