package com.ycj.android.common.utils;

import java.util.regex.Pattern;

public class RegexUtils {

	/**
	 * @Title: ��֤Email�ĸ�ʽ
	 * @Description: TODO
	 * @param @param email
	 * @param @return �趨�ļ�
	 * @return boolean ��������
	 * @throws
	 */
	public static boolean checkEmail(String email) {
		String regex = "\\w+@\\w+\\.[a-z]+(\\.[a-z]+)?";
		return Pattern.matches(regex, email);
	}

	/**
	 * @Title: ��֤���֤����
	 * @Description: TODO
	 * @param @param idCard
	 * @param @return �趨�ļ�
	 * @return boolean ��������
	 * @throws
	 */
	public static boolean checkIdCard(String idCard) {
		String regex = "[1-9]\\d{13,16}[a-zA-Z0-9]{1}";
		return Pattern.matches(regex, idCard);
	}

	/**
	 * @Title: ��֤�ֻ�����
	 * @Description: TODO
	 * @param @param mobile
	 * @param @return �趨�ļ�
	 * @return boolean ��������
	 * @throws
	 */
	public static boolean checkMobile(String mobile) {
		String regex = "(\\+\\d+)?1[3458]\\d{9}$";
		return Pattern.matches(regex, mobile);
	}

	/**
	 * @Title: ��֤�̻�
	 * @Description: TODO
	 * @param @param phone
	 * @param @return �趨�ļ�
	 * @return boolean ��������
	 * @throws
	 */
	public static boolean checkPhone(String phone) {
		String regex = "(\\+\\d+)?(\\d{3,4}\\-?)?\\d{7,8}$";
		return Pattern.matches(regex, phone);
	}

	/**
	 * @Title: ��֤����
	 * @Description: TODO
	 * @param @param digit
	 * @param @return �趨�ļ�
	 * @return boolean ��������
	 * @throws
	 */
	public static boolean checkDigit(String digit) {
		String regex = "\\-?[1-9]\\d+";
		return Pattern.matches(regex, digit);
	}

	/**
	 * @Title: ��֤������
	 * @Description: TODO
	 * @param @param decimals
	 * @param @return �趨�ļ�
	 * @return boolean ��������
	 * @throws
	 */
	public static boolean checkDecimals(String decimals) {
		String regex = "\\-?[1-9]\\d+(\\.\\d+)?";
		return Pattern.matches(regex, decimals);
	}

	/**
	 * @Title: ��֤�հ��ַ�
	 * @Description: TODO
	 * @param @param blankSpace
	 * @param @return �趨�ļ�
	 * @return boolean ��������
	 * @throws
	 */
	public static boolean checkBlankSpace(String blankSpace) {
		String regex = "\\s+";
		return Pattern.matches(regex, blankSpace);
	}

	/**
	 * @Title: ��֤�й�
	 * @Description: TODO
	 * @param @param chinese
	 * @param @return �趨�ļ�
	 * @return boolean ��������
	 * @throws
	 */
	public static boolean checkChinese(String chinese) {
		String regex = "^[\u4E00-\u9FA5]+$";
		return Pattern.matches(regex, chinese);
	}

	/**
	 * @Title: ��֤����
	 * @Description: TODO
	 * @param @param birthday ���ڣ���ʽ��1992-09-03����1992.09.03
	 * @param @return �趨�ļ�
	 * @return boolean ��������
	 * @throws
	 */
	public static boolean checkBirthday(String birthday) {
		String regex = "[1-9]{4}([-./])\\d{1,2}\\1\\d{1,2}";
		return Pattern.matches(regex, birthday);
	}

	/**
	 * @Title: ��֤URL
	 * @Description: ��ʽ��http://blog.csdn.net:80/xyang81/article/details/7705960?
	 *               �� http://www.csdn.net:80
	 * @param @param url
	 * @param @return �趨�ļ�
	 * @return boolean ��������
	 * @throws
	 */
	public static boolean checkURL(String url) {
		String regex = "(https?://(w{3}\\.)?)?\\w+\\.\\w+(\\.[a-zA-Z]+)*(:\\d{1,5})?(/\\w*)*(\\??(.+=.*)?(&.+=.*)?)?";
		return Pattern.matches(regex, url);
	}
	/**
	  * @Title: ƥ���й���������
	  * @Description: TODO
	  * @param @param postcode
	  * @param @return    �趨�ļ�
	  * @return boolean    ��������
	  * @throws
	 */
	public static boolean checkPostcode(String postcode) {
		String regex = "[1-9]\\d{5}";
		return Pattern.matches(regex, postcode);
	}
	/**
	  * @Title: ƥ��IP��ַ(��ƥ�䣬��ʽ���磺192.168.1.1��127.0.0.1��û��ƥ��IP�εĴ�С)
	  * @Description: TODO
	  * @param @param ipAddress
	  * @param @return    �趨�ļ�
	  * @return boolean    ��������
	  * @throws
	  */
	public static boolean checkIpAddress(String ipAddress) { 
        String regex = "[1-9](\\d{1,2})?\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))"; 
        return Pattern.matches(regex, ipAddress); 
    } 
	
}
